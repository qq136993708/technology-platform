package com.pcitc.base.stp.IntlProject;

import java.util.ArrayList;
import java.util.List;

public class IntlProjectApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntlProjectApplyExample() {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(String value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(String value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(String value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(String value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(String value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLike(String value) {
            addCriterion("apply_id like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotLike(String value) {
            addCriterion("apply_id not like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<String> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<String> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(String value1, String value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(String value1, String value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyTitleIsNull() {
            addCriterion("apply_title is null");
            return (Criteria) this;
        }

        public Criteria andApplyTitleIsNotNull() {
            addCriterion("apply_title is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTitleEqualTo(String value) {
            addCriterion("apply_title =", value, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleNotEqualTo(String value) {
            addCriterion("apply_title <>", value, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleGreaterThan(String value) {
            addCriterion("apply_title >", value, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleGreaterThanOrEqualTo(String value) {
            addCriterion("apply_title >=", value, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleLessThan(String value) {
            addCriterion("apply_title <", value, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleLessThanOrEqualTo(String value) {
            addCriterion("apply_title <=", value, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleLike(String value) {
            addCriterion("apply_title like", value, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleNotLike(String value) {
            addCriterion("apply_title not like", value, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleIn(List<String> values) {
            addCriterion("apply_title in", values, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleNotIn(List<String> values) {
            addCriterion("apply_title not in", values, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleBetween(String value1, String value2) {
            addCriterion("apply_title between", value1, value2, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyTitleNotBetween(String value1, String value2) {
            addCriterion("apply_title not between", value1, value2, "applyTitle");
            return (Criteria) this;
        }

        public Criteria andApplyContentIsNull() {
            addCriterion("apply_content is null");
            return (Criteria) this;
        }

        public Criteria andApplyContentIsNotNull() {
            addCriterion("apply_content is not null");
            return (Criteria) this;
        }

        public Criteria andApplyContentEqualTo(String value) {
            addCriterion("apply_content =", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentNotEqualTo(String value) {
            addCriterion("apply_content <>", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentGreaterThan(String value) {
            addCriterion("apply_content >", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("apply_content >=", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentLessThan(String value) {
            addCriterion("apply_content <", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentLessThanOrEqualTo(String value) {
            addCriterion("apply_content <=", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentLike(String value) {
            addCriterion("apply_content like", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentNotLike(String value) {
            addCriterion("apply_content not like", value, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentIn(List<String> values) {
            addCriterion("apply_content in", values, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentNotIn(List<String> values) {
            addCriterion("apply_content not in", values, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentBetween(String value1, String value2) {
            addCriterion("apply_content between", value1, value2, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyContentNotBetween(String value1, String value2) {
            addCriterion("apply_content not between", value1, value2, "applyContent");
            return (Criteria) this;
        }

        public Criteria andApplyNameIsNull() {
            addCriterion("apply_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyNameIsNotNull() {
            addCriterion("apply_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNameEqualTo(String value) {
            addCriterion("apply_name =", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotEqualTo(String value) {
            addCriterion("apply_name <>", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThan(String value) {
            addCriterion("apply_name >", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_name >=", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThan(String value) {
            addCriterion("apply_name <", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThanOrEqualTo(String value) {
            addCriterion("apply_name <=", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLike(String value) {
            addCriterion("apply_name like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotLike(String value) {
            addCriterion("apply_name not like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameIn(List<String> values) {
            addCriterion("apply_name in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotIn(List<String> values) {
            addCriterion("apply_name not in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameBetween(String value1, String value2) {
            addCriterion("apply_name between", value1, value2, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotBetween(String value1, String value2) {
            addCriterion("apply_name not between", value1, value2, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIsNull() {
            addCriterion("apply_code is null");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIsNotNull() {
            addCriterion("apply_code is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCodeEqualTo(String value) {
            addCriterion("apply_code =", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotEqualTo(String value) {
            addCriterion("apply_code <>", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeGreaterThan(String value) {
            addCriterion("apply_code >", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_code >=", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLessThan(String value) {
            addCriterion("apply_code <", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLessThanOrEqualTo(String value) {
            addCriterion("apply_code <=", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLike(String value) {
            addCriterion("apply_code like", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotLike(String value) {
            addCriterion("apply_code not like", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIn(List<String> values) {
            addCriterion("apply_code in", values, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotIn(List<String> values) {
            addCriterion("apply_code not in", values, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeBetween(String value1, String value2) {
            addCriterion("apply_code between", value1, value2, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotBetween(String value1, String value2) {
            addCriterion("apply_code not between", value1, value2, "applyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeIsNull() {
            addCriterion("intl_apply_code is null");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeIsNotNull() {
            addCriterion("intl_apply_code is not null");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeEqualTo(String value) {
            addCriterion("intl_apply_code =", value, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeNotEqualTo(String value) {
            addCriterion("intl_apply_code <>", value, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeGreaterThan(String value) {
            addCriterion("intl_apply_code >", value, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("intl_apply_code >=", value, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeLessThan(String value) {
            addCriterion("intl_apply_code <", value, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeLessThanOrEqualTo(String value) {
            addCriterion("intl_apply_code <=", value, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeLike(String value) {
            addCriterion("intl_apply_code like", value, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeNotLike(String value) {
            addCriterion("intl_apply_code not like", value, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeIn(List<String> values) {
            addCriterion("intl_apply_code in", values, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeNotIn(List<String> values) {
            addCriterion("intl_apply_code not in", values, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeBetween(String value1, String value2) {
            addCriterion("intl_apply_code between", value1, value2, "intlApplyCode");
            return (Criteria) this;
        }

        public Criteria andIntlApplyCodeNotBetween(String value1, String value2) {
            addCriterion("intl_apply_code not between", value1, value2, "intlApplyCode");
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

        public Criteria andFlowStartStatusIsNull() {
            addCriterion("flow_start_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusIsNotNull() {
            addCriterion("flow_start_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusEqualTo(Integer value) {
            addCriterion("flow_start_status =", value, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusNotEqualTo(Integer value) {
            addCriterion("flow_start_status <>", value, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusGreaterThan(Integer value) {
            addCriterion("flow_start_status >", value, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_start_status >=", value, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusLessThan(Integer value) {
            addCriterion("flow_start_status <", value, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusLessThanOrEqualTo(Integer value) {
            addCriterion("flow_start_status <=", value, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusIn(List<Integer> values) {
            addCriterion("flow_start_status in", values, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusNotIn(List<Integer> values) {
            addCriterion("flow_start_status not in", values, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusBetween(Integer value1, Integer value2) {
            addCriterion("flow_start_status between", value1, value2, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStartStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_start_status not between", value1, value2, "flowStartStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusIsNull() {
            addCriterion("flow_end_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusIsNotNull() {
            addCriterion("flow_end_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusEqualTo(Integer value) {
            addCriterion("flow_end_status =", value, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusNotEqualTo(Integer value) {
            addCriterion("flow_end_status <>", value, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusGreaterThan(Integer value) {
            addCriterion("flow_end_status >", value, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_end_status >=", value, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusLessThan(Integer value) {
            addCriterion("flow_end_status <", value, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusLessThanOrEqualTo(Integer value) {
            addCriterion("flow_end_status <=", value, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusIn(List<Integer> values) {
            addCriterion("flow_end_status in", values, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusNotIn(List<Integer> values) {
            addCriterion("flow_end_status not in", values, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusBetween(Integer value1, Integer value2) {
            addCriterion("flow_end_status between", value1, value2, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowEndStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_end_status not between", value1, value2, "flowEndStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusIsNull() {
            addCriterion("flow_current_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusIsNotNull() {
            addCriterion("flow_current_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusEqualTo(Integer value) {
            addCriterion("flow_current_status =", value, "flowCurrentStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusNotEqualTo(Integer value) {
            addCriterion("flow_current_status <>", value, "flowCurrentStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusGreaterThan(Integer value) {
            addCriterion("flow_current_status >", value, "flowCurrentStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_current_status >=", value, "flowCurrentStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusLessThan(Integer value) {
            addCriterion("flow_current_status <", value, "flowCurrentStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("flow_current_status <=", value, "flowCurrentStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusIn(List<Integer> values) {
            addCriterion("flow_current_status in", values, "flowCurrentStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusNotIn(List<Integer> values) {
            addCriterion("flow_current_status not in", values, "flowCurrentStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusBetween(Integer value1, Integer value2) {
            addCriterion("flow_current_status between", value1, value2, "flowCurrentStatus");
            return (Criteria) this;
        }

        public Criteria andFlowCurrentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_current_status not between", value1, value2, "flowCurrentStatus");
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

        public Criteria andDcProjectTypeIsNull() {
            addCriterion("dc_project_type is null");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeIsNotNull() {
            addCriterion("dc_project_type is not null");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeEqualTo(String value) {
            addCriterion("dc_project_type =", value, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeNotEqualTo(String value) {
            addCriterion("dc_project_type <>", value, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeGreaterThan(String value) {
            addCriterion("dc_project_type >", value, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dc_project_type >=", value, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeLessThan(String value) {
            addCriterion("dc_project_type <", value, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("dc_project_type <=", value, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeLike(String value) {
            addCriterion("dc_project_type like", value, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeNotLike(String value) {
            addCriterion("dc_project_type not like", value, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeIn(List<String> values) {
            addCriterion("dc_project_type in", values, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeNotIn(List<String> values) {
            addCriterion("dc_project_type not in", values, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeBetween(String value1, String value2) {
            addCriterion("dc_project_type between", value1, value2, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectTypeNotBetween(String value1, String value2) {
            addCriterion("dc_project_type not between", value1, value2, "dcProjectType");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureIsNull() {
            addCriterion("dc_project_nature is null");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureIsNotNull() {
            addCriterion("dc_project_nature is not null");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureEqualTo(String value) {
            addCriterion("dc_project_nature =", value, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureNotEqualTo(String value) {
            addCriterion("dc_project_nature <>", value, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureGreaterThan(String value) {
            addCriterion("dc_project_nature >", value, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureGreaterThanOrEqualTo(String value) {
            addCriterion("dc_project_nature >=", value, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureLessThan(String value) {
            addCriterion("dc_project_nature <", value, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureLessThanOrEqualTo(String value) {
            addCriterion("dc_project_nature <=", value, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureLike(String value) {
            addCriterion("dc_project_nature like", value, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureNotLike(String value) {
            addCriterion("dc_project_nature not like", value, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureIn(List<String> values) {
            addCriterion("dc_project_nature in", values, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureNotIn(List<String> values) {
            addCriterion("dc_project_nature not in", values, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureBetween(String value1, String value2) {
            addCriterion("dc_project_nature between", value1, value2, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectNatureNotBetween(String value1, String value2) {
            addCriterion("dc_project_nature not between", value1, value2, "dcProjectNature");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeIsNull() {
            addCriterion("dc_project_bulid_type is null");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeIsNotNull() {
            addCriterion("dc_project_bulid_type is not null");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeEqualTo(String value) {
            addCriterion("dc_project_bulid_type =", value, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeNotEqualTo(String value) {
            addCriterion("dc_project_bulid_type <>", value, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeGreaterThan(String value) {
            addCriterion("dc_project_bulid_type >", value, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dc_project_bulid_type >=", value, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeLessThan(String value) {
            addCriterion("dc_project_bulid_type <", value, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeLessThanOrEqualTo(String value) {
            addCriterion("dc_project_bulid_type <=", value, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeLike(String value) {
            addCriterion("dc_project_bulid_type like", value, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeNotLike(String value) {
            addCriterion("dc_project_bulid_type not like", value, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeIn(List<String> values) {
            addCriterion("dc_project_bulid_type in", values, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeNotIn(List<String> values) {
            addCriterion("dc_project_bulid_type not in", values, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeBetween(String value1, String value2) {
            addCriterion("dc_project_bulid_type between", value1, value2, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectBulidTypeNotBetween(String value1, String value2) {
            addCriterion("dc_project_bulid_type not between", value1, value2, "dcProjectBulidType");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryIsNull() {
            addCriterion("dc_project_category is null");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryIsNotNull() {
            addCriterion("dc_project_category is not null");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryEqualTo(String value) {
            addCriterion("dc_project_category =", value, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryNotEqualTo(String value) {
            addCriterion("dc_project_category <>", value, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryGreaterThan(String value) {
            addCriterion("dc_project_category >", value, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("dc_project_category >=", value, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryLessThan(String value) {
            addCriterion("dc_project_category <", value, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryLessThanOrEqualTo(String value) {
            addCriterion("dc_project_category <=", value, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryLike(String value) {
            addCriterion("dc_project_category like", value, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryNotLike(String value) {
            addCriterion("dc_project_category not like", value, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryIn(List<String> values) {
            addCriterion("dc_project_category in", values, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryNotIn(List<String> values) {
            addCriterion("dc_project_category not in", values, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryBetween(String value1, String value2) {
            addCriterion("dc_project_category between", value1, value2, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectCategoryNotBetween(String value1, String value2) {
            addCriterion("dc_project_category not between", value1, value2, "dcProjectCategory");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelIsNull() {
            addCriterion("dc_project_level is null");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelIsNotNull() {
            addCriterion("dc_project_level is not null");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelEqualTo(String value) {
            addCriterion("dc_project_level =", value, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelNotEqualTo(String value) {
            addCriterion("dc_project_level <>", value, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelGreaterThan(String value) {
            addCriterion("dc_project_level >", value, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelGreaterThanOrEqualTo(String value) {
            addCriterion("dc_project_level >=", value, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelLessThan(String value) {
            addCriterion("dc_project_level <", value, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelLessThanOrEqualTo(String value) {
            addCriterion("dc_project_level <=", value, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelLike(String value) {
            addCriterion("dc_project_level like", value, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelNotLike(String value) {
            addCriterion("dc_project_level not like", value, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelIn(List<String> values) {
            addCriterion("dc_project_level in", values, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelNotIn(List<String> values) {
            addCriterion("dc_project_level not in", values, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelBetween(String value1, String value2) {
            addCriterion("dc_project_level between", value1, value2, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andDcProjectLevelNotBetween(String value1, String value2) {
            addCriterion("dc_project_level not between", value1, value2, "dcProjectLevel");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyIsNull() {
            addCriterion("plant_money is null");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyIsNotNull() {
            addCriterion("plant_money is not null");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyEqualTo(Double value) {
            addCriterion("plant_money =", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyNotEqualTo(Double value) {
            addCriterion("plant_money <>", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyGreaterThan(Double value) {
            addCriterion("plant_money >", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("plant_money >=", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyLessThan(Double value) {
            addCriterion("plant_money <", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyLessThanOrEqualTo(Double value) {
            addCriterion("plant_money <=", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyIn(List<Double> values) {
            addCriterion("plant_money in", values, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyNotIn(List<Double> values) {
            addCriterion("plant_money not in", values, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyBetween(Double value1, Double value2) {
            addCriterion("plant_money between", value1, value2, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyNotBetween(Double value1, Double value2) {
            addCriterion("plant_money not between", value1, value2, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsIsNull() {
            addCriterion("plant_money_items is null");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsIsNotNull() {
            addCriterion("plant_money_items is not null");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsEqualTo(String value) {
            addCriterion("plant_money_items =", value, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsNotEqualTo(String value) {
            addCriterion("plant_money_items <>", value, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsGreaterThan(String value) {
            addCriterion("plant_money_items >", value, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsGreaterThanOrEqualTo(String value) {
            addCriterion("plant_money_items >=", value, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsLessThan(String value) {
            addCriterion("plant_money_items <", value, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsLessThanOrEqualTo(String value) {
            addCriterion("plant_money_items <=", value, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsLike(String value) {
            addCriterion("plant_money_items like", value, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsNotLike(String value) {
            addCriterion("plant_money_items not like", value, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsIn(List<String> values) {
            addCriterion("plant_money_items in", values, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsNotIn(List<String> values) {
            addCriterion("plant_money_items not in", values, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsBetween(String value1, String value2) {
            addCriterion("plant_money_items between", value1, value2, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyItemsNotBetween(String value1, String value2) {
            addCriterion("plant_money_items not between", value1, value2, "plantMoneyItems");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxIsNull() {
            addCriterion("money_contain_tax is null");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxIsNotNull() {
            addCriterion("money_contain_tax is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxEqualTo(Integer value) {
            addCriterion("money_contain_tax =", value, "moneyContainTax");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxNotEqualTo(Integer value) {
            addCriterion("money_contain_tax <>", value, "moneyContainTax");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxGreaterThan(Integer value) {
            addCriterion("money_contain_tax >", value, "moneyContainTax");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("money_contain_tax >=", value, "moneyContainTax");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxLessThan(Integer value) {
            addCriterion("money_contain_tax <", value, "moneyContainTax");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxLessThanOrEqualTo(Integer value) {
            addCriterion("money_contain_tax <=", value, "moneyContainTax");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxIn(List<Integer> values) {
            addCriterion("money_contain_tax in", values, "moneyContainTax");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxNotIn(List<Integer> values) {
            addCriterion("money_contain_tax not in", values, "moneyContainTax");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxBetween(Integer value1, Integer value2) {
            addCriterion("money_contain_tax between", value1, value2, "moneyContainTax");
            return (Criteria) this;
        }

        public Criteria andMoneyContainTaxNotBetween(Integer value1, Integer value2) {
            addCriterion("money_contain_tax not between", value1, value2, "moneyContainTax");
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

        public Criteria andMoneyRmbIsNull() {
            addCriterion("money_rmb is null");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbIsNotNull() {
            addCriterion("money_rmb is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbEqualTo(Double value) {
            addCriterion("money_rmb =", value, "moneyRmb");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbNotEqualTo(Double value) {
            addCriterion("money_rmb <>", value, "moneyRmb");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbGreaterThan(Double value) {
            addCriterion("money_rmb >", value, "moneyRmb");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbGreaterThanOrEqualTo(Double value) {
            addCriterion("money_rmb >=", value, "moneyRmb");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbLessThan(Double value) {
            addCriterion("money_rmb <", value, "moneyRmb");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbLessThanOrEqualTo(Double value) {
            addCriterion("money_rmb <=", value, "moneyRmb");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbIn(List<Double> values) {
            addCriterion("money_rmb in", values, "moneyRmb");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbNotIn(List<Double> values) {
            addCriterion("money_rmb not in", values, "moneyRmb");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbBetween(Double value1, Double value2) {
            addCriterion("money_rmb between", value1, value2, "moneyRmb");
            return (Criteria) this;
        }

        public Criteria andMoneyRmbNotBetween(Double value1, Double value2) {
            addCriterion("money_rmb not between", value1, value2, "moneyRmb");
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

        public Criteria andBuildYearsIsNull() {
            addCriterion("build_years is null");
            return (Criteria) this;
        }

        public Criteria andBuildYearsIsNotNull() {
            addCriterion("build_years is not null");
            return (Criteria) this;
        }

        public Criteria andBuildYearsEqualTo(String value) {
            addCriterion("build_years =", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsNotEqualTo(String value) {
            addCriterion("build_years <>", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsGreaterThan(String value) {
            addCriterion("build_years >", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsGreaterThanOrEqualTo(String value) {
            addCriterion("build_years >=", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsLessThan(String value) {
            addCriterion("build_years <", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsLessThanOrEqualTo(String value) {
            addCriterion("build_years <=", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsLike(String value) {
            addCriterion("build_years like", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsNotLike(String value) {
            addCriterion("build_years not like", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsIn(List<String> values) {
            addCriterion("build_years in", values, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsNotIn(List<String> values) {
            addCriterion("build_years not in", values, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsBetween(String value1, String value2) {
            addCriterion("build_years between", value1, value2, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsNotBetween(String value1, String value2) {
            addCriterion("build_years not between", value1, value2, "buildYears");
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

        public Criteria andManagerNameIsNull() {
            addCriterion("manager_name is null");
            return (Criteria) this;
        }

        public Criteria andManagerNameIsNotNull() {
            addCriterion("manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andManagerNameEqualTo(String value) {
            addCriterion("manager_name =", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotEqualTo(String value) {
            addCriterion("manager_name <>", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThan(String value) {
            addCriterion("manager_name >", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("manager_name >=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThan(String value) {
            addCriterion("manager_name <", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThanOrEqualTo(String value) {
            addCriterion("manager_name <=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLike(String value) {
            addCriterion("manager_name like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotLike(String value) {
            addCriterion("manager_name not like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameIn(List<String> values) {
            addCriterion("manager_name in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotIn(List<String> values) {
            addCriterion("manager_name not in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameBetween(String value1, String value2) {
            addCriterion("manager_name between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotBetween(String value1, String value2) {
            addCriterion("manager_name not between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneIsNull() {
            addCriterion("manager_phone is null");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneIsNotNull() {
            addCriterion("manager_phone is not null");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneEqualTo(String value) {
            addCriterion("manager_phone =", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotEqualTo(String value) {
            addCriterion("manager_phone <>", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneGreaterThan(String value) {
            addCriterion("manager_phone >", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("manager_phone >=", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneLessThan(String value) {
            addCriterion("manager_phone <", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneLessThanOrEqualTo(String value) {
            addCriterion("manager_phone <=", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneLike(String value) {
            addCriterion("manager_phone like", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotLike(String value) {
            addCriterion("manager_phone not like", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneIn(List<String> values) {
            addCriterion("manager_phone in", values, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotIn(List<String> values) {
            addCriterion("manager_phone not in", values, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneBetween(String value1, String value2) {
            addCriterion("manager_phone between", value1, value2, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotBetween(String value1, String value2) {
            addCriterion("manager_phone not between", value1, value2, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andReportYearIsNull() {
            addCriterion("report_year is null");
            return (Criteria) this;
        }

        public Criteria andReportYearIsNotNull() {
            addCriterion("report_year is not null");
            return (Criteria) this;
        }

        public Criteria andReportYearEqualTo(String value) {
            addCriterion("report_year =", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearNotEqualTo(String value) {
            addCriterion("report_year <>", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearGreaterThan(String value) {
            addCriterion("report_year >", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearGreaterThanOrEqualTo(String value) {
            addCriterion("report_year >=", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearLessThan(String value) {
            addCriterion("report_year <", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearLessThanOrEqualTo(String value) {
            addCriterion("report_year <=", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearLike(String value) {
            addCriterion("report_year like", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearNotLike(String value) {
            addCriterion("report_year not like", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearIn(List<String> values) {
            addCriterion("report_year in", values, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearNotIn(List<String> values) {
            addCriterion("report_year not in", values, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearBetween(String value1, String value2) {
            addCriterion("report_year between", value1, value2, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearNotBetween(String value1, String value2) {
            addCriterion("report_year not between", value1, value2, "reportYear");
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

        public Criteria andOuterCompanyNameIsNull() {
            addCriterion("outer_company_name is null");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameIsNotNull() {
            addCriterion("outer_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameEqualTo(String value) {
            addCriterion("outer_company_name =", value, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameNotEqualTo(String value) {
            addCriterion("outer_company_name <>", value, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameGreaterThan(String value) {
            addCriterion("outer_company_name >", value, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("outer_company_name >=", value, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameLessThan(String value) {
            addCriterion("outer_company_name <", value, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("outer_company_name <=", value, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameLike(String value) {
            addCriterion("outer_company_name like", value, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameNotLike(String value) {
            addCriterion("outer_company_name not like", value, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameIn(List<String> values) {
            addCriterion("outer_company_name in", values, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameNotIn(List<String> values) {
            addCriterion("outer_company_name not in", values, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameBetween(String value1, String value2) {
            addCriterion("outer_company_name between", value1, value2, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterCompanyNameNotBetween(String value1, String value2) {
            addCriterion("outer_company_name not between", value1, value2, "outerCompanyName");
            return (Criteria) this;
        }

        public Criteria andOuterContactsIsNull() {
            addCriterion("outer_contacts is null");
            return (Criteria) this;
        }

        public Criteria andOuterContactsIsNotNull() {
            addCriterion("outer_contacts is not null");
            return (Criteria) this;
        }

        public Criteria andOuterContactsEqualTo(String value) {
            addCriterion("outer_contacts =", value, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsNotEqualTo(String value) {
            addCriterion("outer_contacts <>", value, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsGreaterThan(String value) {
            addCriterion("outer_contacts >", value, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsGreaterThanOrEqualTo(String value) {
            addCriterion("outer_contacts >=", value, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsLessThan(String value) {
            addCriterion("outer_contacts <", value, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsLessThanOrEqualTo(String value) {
            addCriterion("outer_contacts <=", value, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsLike(String value) {
            addCriterion("outer_contacts like", value, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsNotLike(String value) {
            addCriterion("outer_contacts not like", value, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsIn(List<String> values) {
            addCriterion("outer_contacts in", values, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsNotIn(List<String> values) {
            addCriterion("outer_contacts not in", values, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsBetween(String value1, String value2) {
            addCriterion("outer_contacts between", value1, value2, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsNotBetween(String value1, String value2) {
            addCriterion("outer_contacts not between", value1, value2, "outerContacts");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneIsNull() {
            addCriterion("outer_contacts_phone is null");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneIsNotNull() {
            addCriterion("outer_contacts_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneEqualTo(String value) {
            addCriterion("outer_contacts_phone =", value, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneNotEqualTo(String value) {
            addCriterion("outer_contacts_phone <>", value, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneGreaterThan(String value) {
            addCriterion("outer_contacts_phone >", value, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("outer_contacts_phone >=", value, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneLessThan(String value) {
            addCriterion("outer_contacts_phone <", value, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneLessThanOrEqualTo(String value) {
            addCriterion("outer_contacts_phone <=", value, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneLike(String value) {
            addCriterion("outer_contacts_phone like", value, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneNotLike(String value) {
            addCriterion("outer_contacts_phone not like", value, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneIn(List<String> values) {
            addCriterion("outer_contacts_phone in", values, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneNotIn(List<String> values) {
            addCriterion("outer_contacts_phone not in", values, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneBetween(String value1, String value2) {
            addCriterion("outer_contacts_phone between", value1, value2, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andOuterContactsPhoneNotBetween(String value1, String value2) {
            addCriterion("outer_contacts_phone not between", value1, value2, "outerContactsPhone");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageIsNull() {
            addCriterion("project_advantage is null");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageIsNotNull() {
            addCriterion("project_advantage is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageEqualTo(String value) {
            addCriterion("project_advantage =", value, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageNotEqualTo(String value) {
            addCriterion("project_advantage <>", value, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageGreaterThan(String value) {
            addCriterion("project_advantage >", value, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageGreaterThanOrEqualTo(String value) {
            addCriterion("project_advantage >=", value, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageLessThan(String value) {
            addCriterion("project_advantage <", value, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageLessThanOrEqualTo(String value) {
            addCriterion("project_advantage <=", value, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageLike(String value) {
            addCriterion("project_advantage like", value, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageNotLike(String value) {
            addCriterion("project_advantage not like", value, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageIn(List<String> values) {
            addCriterion("project_advantage in", values, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageNotIn(List<String> values) {
            addCriterion("project_advantage not in", values, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageBetween(String value1, String value2) {
            addCriterion("project_advantage between", value1, value2, "projectAdvantage");
            return (Criteria) this;
        }

        public Criteria andProjectAdvantageNotBetween(String value1, String value2) {
            addCriterion("project_advantage not between", value1, value2, "projectAdvantage");
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

        public Criteria andProjectResearchContentIsNull() {
            addCriterion("project_research_content is null");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentIsNotNull() {
            addCriterion("project_research_content is not null");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentEqualTo(String value) {
            addCriterion("project_research_content =", value, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentNotEqualTo(String value) {
            addCriterion("project_research_content <>", value, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentGreaterThan(String value) {
            addCriterion("project_research_content >", value, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentGreaterThanOrEqualTo(String value) {
            addCriterion("project_research_content >=", value, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentLessThan(String value) {
            addCriterion("project_research_content <", value, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentLessThanOrEqualTo(String value) {
            addCriterion("project_research_content <=", value, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentLike(String value) {
            addCriterion("project_research_content like", value, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentNotLike(String value) {
            addCriterion("project_research_content not like", value, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentIn(List<String> values) {
            addCriterion("project_research_content in", values, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentNotIn(List<String> values) {
            addCriterion("project_research_content not in", values, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentBetween(String value1, String value2) {
            addCriterion("project_research_content between", value1, value2, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResearchContentNotBetween(String value1, String value2) {
            addCriterion("project_research_content not between", value1, value2, "projectResearchContent");
            return (Criteria) this;
        }

        public Criteria andProjectResultIsNull() {
            addCriterion("project_result is null");
            return (Criteria) this;
        }

        public Criteria andProjectResultIsNotNull() {
            addCriterion("project_result is not null");
            return (Criteria) this;
        }

        public Criteria andProjectResultEqualTo(String value) {
            addCriterion("project_result =", value, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultNotEqualTo(String value) {
            addCriterion("project_result <>", value, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultGreaterThan(String value) {
            addCriterion("project_result >", value, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultGreaterThanOrEqualTo(String value) {
            addCriterion("project_result >=", value, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultLessThan(String value) {
            addCriterion("project_result <", value, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultLessThanOrEqualTo(String value) {
            addCriterion("project_result <=", value, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultLike(String value) {
            addCriterion("project_result like", value, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultNotLike(String value) {
            addCriterion("project_result not like", value, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultIn(List<String> values) {
            addCriterion("project_result in", values, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultNotIn(List<String> values) {
            addCriterion("project_result not in", values, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultBetween(String value1, String value2) {
            addCriterion("project_result between", value1, value2, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectResultNotBetween(String value1, String value2) {
            addCriterion("project_result not between", value1, value2, "projectResult");
            return (Criteria) this;
        }

        public Criteria andProjectRightIsNull() {
            addCriterion("project_right is null");
            return (Criteria) this;
        }

        public Criteria andProjectRightIsNotNull() {
            addCriterion("project_right is not null");
            return (Criteria) this;
        }

        public Criteria andProjectRightEqualTo(String value) {
            addCriterion("project_right =", value, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightNotEqualTo(String value) {
            addCriterion("project_right <>", value, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightGreaterThan(String value) {
            addCriterion("project_right >", value, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightGreaterThanOrEqualTo(String value) {
            addCriterion("project_right >=", value, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightLessThan(String value) {
            addCriterion("project_right <", value, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightLessThanOrEqualTo(String value) {
            addCriterion("project_right <=", value, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightLike(String value) {
            addCriterion("project_right like", value, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightNotLike(String value) {
            addCriterion("project_right not like", value, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightIn(List<String> values) {
            addCriterion("project_right in", values, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightNotIn(List<String> values) {
            addCriterion("project_right not in", values, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightBetween(String value1, String value2) {
            addCriterion("project_right between", value1, value2, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectRightNotBetween(String value1, String value2) {
            addCriterion("project_right not between", value1, value2, "projectRight");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusIsNull() {
            addCriterion("project_final_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusIsNotNull() {
            addCriterion("project_final_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusEqualTo(Integer value) {
            addCriterion("project_final_status =", value, "projectFinalStatus");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusNotEqualTo(Integer value) {
            addCriterion("project_final_status <>", value, "projectFinalStatus");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusGreaterThan(Integer value) {
            addCriterion("project_final_status >", value, "projectFinalStatus");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_final_status >=", value, "projectFinalStatus");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusLessThan(Integer value) {
            addCriterion("project_final_status <", value, "projectFinalStatus");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusLessThanOrEqualTo(Integer value) {
            addCriterion("project_final_status <=", value, "projectFinalStatus");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusIn(List<Integer> values) {
            addCriterion("project_final_status in", values, "projectFinalStatus");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusNotIn(List<Integer> values) {
            addCriterion("project_final_status not in", values, "projectFinalStatus");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusBetween(Integer value1, Integer value2) {
            addCriterion("project_final_status between", value1, value2, "projectFinalStatus");
            return (Criteria) this;
        }

        public Criteria andProjectFinalStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("project_final_status not between", value1, value2, "projectFinalStatus");
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