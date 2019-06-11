package com.pcitc.base.stp.IntlProject;

import java.util.ArrayList;
import java.util.List;

public class IntlProjectPlantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntlProjectPlantExample() {
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

        public Criteria andPlantTitleIsNull() {
            addCriterion("plant_title is null");
            return (Criteria) this;
        }

        public Criteria andPlantTitleIsNotNull() {
            addCriterion("plant_title is not null");
            return (Criteria) this;
        }

        public Criteria andPlantTitleEqualTo(String value) {
            addCriterion("plant_title =", value, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleNotEqualTo(String value) {
            addCriterion("plant_title <>", value, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleGreaterThan(String value) {
            addCriterion("plant_title >", value, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleGreaterThanOrEqualTo(String value) {
            addCriterion("plant_title >=", value, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleLessThan(String value) {
            addCriterion("plant_title <", value, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleLessThanOrEqualTo(String value) {
            addCriterion("plant_title <=", value, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleLike(String value) {
            addCriterion("plant_title like", value, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleNotLike(String value) {
            addCriterion("plant_title not like", value, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleIn(List<String> values) {
            addCriterion("plant_title in", values, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleNotIn(List<String> values) {
            addCriterion("plant_title not in", values, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleBetween(String value1, String value2) {
            addCriterion("plant_title between", value1, value2, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantTitleNotBetween(String value1, String value2) {
            addCriterion("plant_title not between", value1, value2, "plantTitle");
            return (Criteria) this;
        }

        public Criteria andPlantContentIsNull() {
            addCriterion("plant_content is null");
            return (Criteria) this;
        }

        public Criteria andPlantContentIsNotNull() {
            addCriterion("plant_content is not null");
            return (Criteria) this;
        }

        public Criteria andPlantContentEqualTo(String value) {
            addCriterion("plant_content =", value, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentNotEqualTo(String value) {
            addCriterion("plant_content <>", value, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentGreaterThan(String value) {
            addCriterion("plant_content >", value, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentGreaterThanOrEqualTo(String value) {
            addCriterion("plant_content >=", value, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentLessThan(String value) {
            addCriterion("plant_content <", value, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentLessThanOrEqualTo(String value) {
            addCriterion("plant_content <=", value, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentLike(String value) {
            addCriterion("plant_content like", value, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentNotLike(String value) {
            addCriterion("plant_content not like", value, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentIn(List<String> values) {
            addCriterion("plant_content in", values, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentNotIn(List<String> values) {
            addCriterion("plant_content not in", values, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentBetween(String value1, String value2) {
            addCriterion("plant_content between", value1, value2, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantContentNotBetween(String value1, String value2) {
            addCriterion("plant_content not between", value1, value2, "plantContent");
            return (Criteria) this;
        }

        public Criteria andPlantNameIsNull() {
            addCriterion("plant_name is null");
            return (Criteria) this;
        }

        public Criteria andPlantNameIsNotNull() {
            addCriterion("plant_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlantNameEqualTo(String value) {
            addCriterion("plant_name =", value, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameNotEqualTo(String value) {
            addCriterion("plant_name <>", value, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameGreaterThan(String value) {
            addCriterion("plant_name >", value, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameGreaterThanOrEqualTo(String value) {
            addCriterion("plant_name >=", value, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameLessThan(String value) {
            addCriterion("plant_name <", value, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameLessThanOrEqualTo(String value) {
            addCriterion("plant_name <=", value, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameLike(String value) {
            addCriterion("plant_name like", value, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameNotLike(String value) {
            addCriterion("plant_name not like", value, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameIn(List<String> values) {
            addCriterion("plant_name in", values, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameNotIn(List<String> values) {
            addCriterion("plant_name not in", values, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameBetween(String value1, String value2) {
            addCriterion("plant_name between", value1, value2, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantNameNotBetween(String value1, String value2) {
            addCriterion("plant_name not between", value1, value2, "plantName");
            return (Criteria) this;
        }

        public Criteria andPlantCodeIsNull() {
            addCriterion("plant_code is null");
            return (Criteria) this;
        }

        public Criteria andPlantCodeIsNotNull() {
            addCriterion("plant_code is not null");
            return (Criteria) this;
        }

        public Criteria andPlantCodeEqualTo(String value) {
            addCriterion("plant_code =", value, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeNotEqualTo(String value) {
            addCriterion("plant_code <>", value, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeGreaterThan(String value) {
            addCriterion("plant_code >", value, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("plant_code >=", value, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeLessThan(String value) {
            addCriterion("plant_code <", value, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeLessThanOrEqualTo(String value) {
            addCriterion("plant_code <=", value, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeLike(String value) {
            addCriterion("plant_code like", value, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeNotLike(String value) {
            addCriterion("plant_code not like", value, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeIn(List<String> values) {
            addCriterion("plant_code in", values, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeNotIn(List<String> values) {
            addCriterion("plant_code not in", values, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeBetween(String value1, String value2) {
            addCriterion("plant_code between", value1, value2, "plantCode");
            return (Criteria) this;
        }

        public Criteria andPlantCodeNotBetween(String value1, String value2) {
            addCriterion("plant_code not between", value1, value2, "plantCode");
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

        public Criteria andPlantMoneyIsNull() {
            addCriterion("plant_money is null");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyIsNotNull() {
            addCriterion("plant_money is not null");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyEqualTo(Integer value) {
            addCriterion("plant_money =", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyNotEqualTo(Integer value) {
            addCriterion("plant_money <>", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyGreaterThan(Integer value) {
            addCriterion("plant_money >", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("plant_money >=", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyLessThan(Integer value) {
            addCriterion("plant_money <", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("plant_money <=", value, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyIn(List<Integer> values) {
            addCriterion("plant_money in", values, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyNotIn(List<Integer> values) {
            addCriterion("plant_money not in", values, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyBetween(Integer value1, Integer value2) {
            addCriterion("plant_money between", value1, value2, "plantMoney");
            return (Criteria) this;
        }

        public Criteria andPlantMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("plant_money not between", value1, value2, "plantMoney");
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
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