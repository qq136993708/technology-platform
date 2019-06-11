package com.pcitc.base.stp.IntlProject;

import java.util.ArrayList;
import java.util.List;

public class IntlProjectInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntlProjectInfoExample() {
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

        public Criteria andPlantIdIsNull() {
            addCriterion("plant_id is null");
            return (Criteria) this;
        }

        public Criteria andPlantIdIsNotNull() {
            addCriterion("plant_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlantIdEqualTo(String value) {
            addCriterion("plant_id =", value, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdNotEqualTo(String value) {
            addCriterion("plant_id <>", value, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdGreaterThan(String value) {
            addCriterion("plant_id >", value, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdGreaterThanOrEqualTo(String value) {
            addCriterion("plant_id >=", value, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdLessThan(String value) {
            addCriterion("plant_id <", value, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdLessThanOrEqualTo(String value) {
            addCriterion("plant_id <=", value, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdLike(String value) {
            addCriterion("plant_id like", value, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdNotLike(String value) {
            addCriterion("plant_id not like", value, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdIn(List<String> values) {
            addCriterion("plant_id in", values, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdNotIn(List<String> values) {
            addCriterion("plant_id not in", values, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdBetween(String value1, String value2) {
            addCriterion("plant_id between", value1, value2, "plantId");
            return (Criteria) this;
        }

        public Criteria andPlantIdNotBetween(String value1, String value2) {
            addCriterion("plant_id not between", value1, value2, "plantId");
            return (Criteria) this;
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNull() {
            addCriterion("project_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("project_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("project_code =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("project_code <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("project_code >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_code >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("project_code <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("project_code <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("project_code like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("project_code not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("project_code in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("project_code not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("project_code between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("project_code not between", value1, value2, "projectCode");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andProjectStepIsNull() {
            addCriterion("project_step is null");
            return (Criteria) this;
        }

        public Criteria andProjectStepIsNotNull() {
            addCriterion("project_step is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStepEqualTo(Integer value) {
            addCriterion("project_step =", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotEqualTo(Integer value) {
            addCriterion("project_step <>", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepGreaterThan(Integer value) {
            addCriterion("project_step >", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_step >=", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepLessThan(Integer value) {
            addCriterion("project_step <", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepLessThanOrEqualTo(Integer value) {
            addCriterion("project_step <=", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepIn(List<Integer> values) {
            addCriterion("project_step in", values, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotIn(List<Integer> values) {
            addCriterion("project_step not in", values, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepBetween(Integer value1, Integer value2) {
            addCriterion("project_step between", value1, value2, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotBetween(Integer value1, Integer value2) {
            addCriterion("project_step not between", value1, value2, "projectStep");
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

        public Criteria andCreaterNameIsNull() {
            addCriterion("creater_name is null");
            return (Criteria) this;
        }

        public Criteria andCreaterNameIsNotNull() {
            addCriterion("creater_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterNameEqualTo(String value) {
            addCriterion("creater_name =", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotEqualTo(String value) {
            addCriterion("creater_name <>", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameGreaterThan(String value) {
            addCriterion("creater_name >", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameGreaterThanOrEqualTo(String value) {
            addCriterion("creater_name >=", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameLessThan(String value) {
            addCriterion("creater_name <", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameLessThanOrEqualTo(String value) {
            addCriterion("creater_name <=", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameLike(String value) {
            addCriterion("creater_name like", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotLike(String value) {
            addCriterion("creater_name not like", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameIn(List<String> values) {
            addCriterion("creater_name in", values, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotIn(List<String> values) {
            addCriterion("creater_name not in", values, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameBetween(String value1, String value2) {
            addCriterion("creater_name between", value1, value2, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotBetween(String value1, String value2) {
            addCriterion("creater_name not between", value1, value2, "createrName");
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

        public Criteria andOldProjectIdIsNull() {
            addCriterion("old_project_id is null");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdIsNotNull() {
            addCriterion("old_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdEqualTo(String value) {
            addCriterion("old_project_id =", value, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdNotEqualTo(String value) {
            addCriterion("old_project_id <>", value, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdGreaterThan(String value) {
            addCriterion("old_project_id >", value, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("old_project_id >=", value, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdLessThan(String value) {
            addCriterion("old_project_id <", value, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdLessThanOrEqualTo(String value) {
            addCriterion("old_project_id <=", value, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdLike(String value) {
            addCriterion("old_project_id like", value, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdNotLike(String value) {
            addCriterion("old_project_id not like", value, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdIn(List<String> values) {
            addCriterion("old_project_id in", values, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdNotIn(List<String> values) {
            addCriterion("old_project_id not in", values, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdBetween(String value1, String value2) {
            addCriterion("old_project_id between", value1, value2, "oldProjectId");
            return (Criteria) this;
        }

        public Criteria andOldProjectIdNotBetween(String value1, String value2) {
            addCriterion("old_project_id not between", value1, value2, "oldProjectId");
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

        public Criteria andFlowAgreementReviewStatusIsNull() {
            addCriterion("flow_agreement_review_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusIsNotNull() {
            addCriterion("flow_agreement_review_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusEqualTo(Integer value) {
            addCriterion("flow_agreement_review_status =", value, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusNotEqualTo(Integer value) {
            addCriterion("flow_agreement_review_status <>", value, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusGreaterThan(Integer value) {
            addCriterion("flow_agreement_review_status >", value, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_agreement_review_status >=", value, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusLessThan(Integer value) {
            addCriterion("flow_agreement_review_status <", value, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusLessThanOrEqualTo(Integer value) {
            addCriterion("flow_agreement_review_status <=", value, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusIn(List<Integer> values) {
            addCriterion("flow_agreement_review_status in", values, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusNotIn(List<Integer> values) {
            addCriterion("flow_agreement_review_status not in", values, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusBetween(Integer value1, Integer value2) {
            addCriterion("flow_agreement_review_status between", value1, value2, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_agreement_review_status not between", value1, value2, "flowAgreementReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusIsNull() {
            addCriterion("flow_technology_review_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusIsNotNull() {
            addCriterion("flow_technology_review_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusEqualTo(Integer value) {
            addCriterion("flow_technology_review_status =", value, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusNotEqualTo(Integer value) {
            addCriterion("flow_technology_review_status <>", value, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusGreaterThan(Integer value) {
            addCriterion("flow_technology_review_status >", value, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_technology_review_status >=", value, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusLessThan(Integer value) {
            addCriterion("flow_technology_review_status <", value, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusLessThanOrEqualTo(Integer value) {
            addCriterion("flow_technology_review_status <=", value, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusIn(List<Integer> values) {
            addCriterion("flow_technology_review_status in", values, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusNotIn(List<Integer> values) {
            addCriterion("flow_technology_review_status not in", values, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusBetween(Integer value1, Integer value2) {
            addCriterion("flow_technology_review_status between", value1, value2, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_technology_review_status not between", value1, value2, "flowTechnologyReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusIsNull() {
            addCriterion("flow_knowledge_review_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusIsNotNull() {
            addCriterion("flow_knowledge_review_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusEqualTo(Integer value) {
            addCriterion("flow_knowledge_review_status =", value, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusNotEqualTo(Integer value) {
            addCriterion("flow_knowledge_review_status <>", value, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusGreaterThan(Integer value) {
            addCriterion("flow_knowledge_review_status >", value, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_knowledge_review_status >=", value, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusLessThan(Integer value) {
            addCriterion("flow_knowledge_review_status <", value, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusLessThanOrEqualTo(Integer value) {
            addCriterion("flow_knowledge_review_status <=", value, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusIn(List<Integer> values) {
            addCriterion("flow_knowledge_review_status in", values, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusNotIn(List<Integer> values) {
            addCriterion("flow_knowledge_review_status not in", values, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusBetween(Integer value1, Integer value2) {
            addCriterion("flow_knowledge_review_status between", value1, value2, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_knowledge_review_status not between", value1, value2, "flowKnowledgeReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusIsNull() {
            addCriterion("flow_comprehensive_review_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusIsNotNull() {
            addCriterion("flow_comprehensive_review_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusEqualTo(Integer value) {
            addCriterion("flow_comprehensive_review_status =", value, "flowComprehensiveReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusNotEqualTo(Integer value) {
            addCriterion("flow_comprehensive_review_status <>", value, "flowComprehensiveReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusGreaterThan(Integer value) {
            addCriterion("flow_comprehensive_review_status >", value, "flowComprehensiveReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_comprehensive_review_status >=", value, "flowComprehensiveReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusLessThan(Integer value) {
            addCriterion("flow_comprehensive_review_status <", value, "flowComprehensiveReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusLessThanOrEqualTo(Integer value) {
            addCriterion("flow_comprehensive_review_status <=", value, "flowComprehensiveReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusIn(List<Integer> values) {
            addCriterion("flow_comprehensive_review_status in", values, "flowComprehensiveReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusNotIn(List<Integer> values) {
            addCriterion("flow_comprehensive_review_status not in", values, "flowComprehensiveReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusBetween(Integer value1, Integer value2) {
            addCriterion("flow_comprehensive_review_status between", value1, value2, "flowComprehensiveReviewStatus");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_comprehensive_review_status not between", value1, value2, "flowComprehensiveReviewStatus");
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

        public Criteria andFlowAgreementReviewEqualTo(String value) {
            addCriterion("flow_agreement_review =", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewNotEqualTo(String value) {
            addCriterion("flow_agreement_review <>", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewGreaterThan(String value) {
            addCriterion("flow_agreement_review >", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewGreaterThanOrEqualTo(String value) {
            addCriterion("flow_agreement_review >=", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewLessThan(String value) {
            addCriterion("flow_agreement_review <", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewLessThanOrEqualTo(String value) {
            addCriterion("flow_agreement_review <=", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewLike(String value) {
            addCriterion("flow_agreement_review like", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewNotLike(String value) {
            addCriterion("flow_agreement_review not like", value, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewIn(List<String> values) {
            addCriterion("flow_agreement_review in", values, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewNotIn(List<String> values) {
            addCriterion("flow_agreement_review not in", values, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewBetween(String value1, String value2) {
            addCriterion("flow_agreement_review between", value1, value2, "flowAgreementReview");
            return (Criteria) this;
        }

        public Criteria andFlowAgreementReviewNotBetween(String value1, String value2) {
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

        public Criteria andFlowTechnologyReviewEqualTo(String value) {
            addCriterion("flow_technology_review =", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewNotEqualTo(String value) {
            addCriterion("flow_technology_review <>", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewGreaterThan(String value) {
            addCriterion("flow_technology_review >", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewGreaterThanOrEqualTo(String value) {
            addCriterion("flow_technology_review >=", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewLessThan(String value) {
            addCriterion("flow_technology_review <", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewLessThanOrEqualTo(String value) {
            addCriterion("flow_technology_review <=", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewLike(String value) {
            addCriterion("flow_technology_review like", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewNotLike(String value) {
            addCriterion("flow_technology_review not like", value, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewIn(List<String> values) {
            addCriterion("flow_technology_review in", values, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewNotIn(List<String> values) {
            addCriterion("flow_technology_review not in", values, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewBetween(String value1, String value2) {
            addCriterion("flow_technology_review between", value1, value2, "flowTechnologyReview");
            return (Criteria) this;
        }

        public Criteria andFlowTechnologyReviewNotBetween(String value1, String value2) {
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

        public Criteria andFlowKnowledgeReviewEqualTo(String value) {
            addCriterion("flow_knowledge_review =", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewNotEqualTo(String value) {
            addCriterion("flow_knowledge_review <>", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewGreaterThan(String value) {
            addCriterion("flow_knowledge_review >", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewGreaterThanOrEqualTo(String value) {
            addCriterion("flow_knowledge_review >=", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewLessThan(String value) {
            addCriterion("flow_knowledge_review <", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewLessThanOrEqualTo(String value) {
            addCriterion("flow_knowledge_review <=", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewLike(String value) {
            addCriterion("flow_knowledge_review like", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewNotLike(String value) {
            addCriterion("flow_knowledge_review not like", value, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewIn(List<String> values) {
            addCriterion("flow_knowledge_review in", values, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewNotIn(List<String> values) {
            addCriterion("flow_knowledge_review not in", values, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewBetween(String value1, String value2) {
            addCriterion("flow_knowledge_review between", value1, value2, "flowKnowledgeReview");
            return (Criteria) this;
        }

        public Criteria andFlowKnowledgeReviewNotBetween(String value1, String value2) {
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

        public Criteria andFlowComprehensiveReviewEqualTo(String value) {
            addCriterion("flow_comprehensive_review =", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewNotEqualTo(String value) {
            addCriterion("flow_comprehensive_review <>", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewGreaterThan(String value) {
            addCriterion("flow_comprehensive_review >", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewGreaterThanOrEqualTo(String value) {
            addCriterion("flow_comprehensive_review >=", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewLessThan(String value) {
            addCriterion("flow_comprehensive_review <", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewLessThanOrEqualTo(String value) {
            addCriterion("flow_comprehensive_review <=", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewLike(String value) {
            addCriterion("flow_comprehensive_review like", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewNotLike(String value) {
            addCriterion("flow_comprehensive_review not like", value, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewIn(List<String> values) {
            addCriterion("flow_comprehensive_review in", values, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewNotIn(List<String> values) {
            addCriterion("flow_comprehensive_review not in", values, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewBetween(String value1, String value2) {
            addCriterion("flow_comprehensive_review between", value1, value2, "flowComprehensiveReview");
            return (Criteria) this;
        }

        public Criteria andFlowComprehensiveReviewNotBetween(String value1, String value2) {
            addCriterion("flow_comprehensive_review not between", value1, value2, "flowComprehensiveReview");
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