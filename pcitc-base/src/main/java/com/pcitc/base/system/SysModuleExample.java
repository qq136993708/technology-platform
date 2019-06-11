package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.List;

public class SysModuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysModuleExample() {
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

        public Criteria andModuleNameIsNull() {
            addCriterion("module_name is null");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNotNull() {
            addCriterion("module_name is not null");
            return (Criteria) this;
        }

        public Criteria andModuleNameEqualTo(String value) {
            addCriterion("module_name =", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotEqualTo(String value) {
            addCriterion("module_name <>", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThan(String value) {
            addCriterion("module_name >", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("module_name >=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThan(String value) {
            addCriterion("module_name <", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThanOrEqualTo(String value) {
            addCriterion("module_name <=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLike(String value) {
            addCriterion("module_name like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotLike(String value) {
            addCriterion("module_name not like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameIn(List<String> values) {
            addCriterion("module_name in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotIn(List<String> values) {
            addCriterion("module_name not in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameBetween(String value1, String value2) {
            addCriterion("module_name between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotBetween(String value1, String value2) {
            addCriterion("module_name not between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIsNull() {
            addCriterion("module_code is null");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIsNotNull() {
            addCriterion("module_code is not null");
            return (Criteria) this;
        }

        public Criteria andModuleCodeEqualTo(String value) {
            addCriterion("module_code =", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotEqualTo(String value) {
            addCriterion("module_code <>", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeGreaterThan(String value) {
            addCriterion("module_code >", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("module_code >=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLessThan(String value) {
            addCriterion("module_code <", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLessThanOrEqualTo(String value) {
            addCriterion("module_code <=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLike(String value) {
            addCriterion("module_code like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotLike(String value) {
            addCriterion("module_code not like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIn(List<String> values) {
            addCriterion("module_code in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotIn(List<String> values) {
            addCriterion("module_code not in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeBetween(String value1, String value2) {
            addCriterion("module_code between", value1, value2, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotBetween(String value1, String value2) {
            addCriterion("module_code not between", value1, value2, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleWidthIsNull() {
            addCriterion("module_width is null");
            return (Criteria) this;
        }

        public Criteria andModuleWidthIsNotNull() {
            addCriterion("module_width is not null");
            return (Criteria) this;
        }

        public Criteria andModuleWidthEqualTo(String value) {
            addCriterion("module_width =", value, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthNotEqualTo(String value) {
            addCriterion("module_width <>", value, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthGreaterThan(String value) {
            addCriterion("module_width >", value, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthGreaterThanOrEqualTo(String value) {
            addCriterion("module_width >=", value, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthLessThan(String value) {
            addCriterion("module_width <", value, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthLessThanOrEqualTo(String value) {
            addCriterion("module_width <=", value, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthLike(String value) {
            addCriterion("module_width like", value, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthNotLike(String value) {
            addCriterion("module_width not like", value, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthIn(List<String> values) {
            addCriterion("module_width in", values, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthNotIn(List<String> values) {
            addCriterion("module_width not in", values, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthBetween(String value1, String value2) {
            addCriterion("module_width between", value1, value2, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleWidthNotBetween(String value1, String value2) {
            addCriterion("module_width not between", value1, value2, "moduleWidth");
            return (Criteria) this;
        }

        public Criteria andModuleHeightIsNull() {
            addCriterion("module_height is null");
            return (Criteria) this;
        }

        public Criteria andModuleHeightIsNotNull() {
            addCriterion("module_height is not null");
            return (Criteria) this;
        }

        public Criteria andModuleHeightEqualTo(String value) {
            addCriterion("module_height =", value, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightNotEqualTo(String value) {
            addCriterion("module_height <>", value, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightGreaterThan(String value) {
            addCriterion("module_height >", value, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightGreaterThanOrEqualTo(String value) {
            addCriterion("module_height >=", value, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightLessThan(String value) {
            addCriterion("module_height <", value, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightLessThanOrEqualTo(String value) {
            addCriterion("module_height <=", value, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightLike(String value) {
            addCriterion("module_height like", value, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightNotLike(String value) {
            addCriterion("module_height not like", value, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightIn(List<String> values) {
            addCriterion("module_height in", values, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightNotIn(List<String> values) {
            addCriterion("module_height not in", values, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightBetween(String value1, String value2) {
            addCriterion("module_height between", value1, value2, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleHeightNotBetween(String value1, String value2) {
            addCriterion("module_height not between", value1, value2, "moduleHeight");
            return (Criteria) this;
        }

        public Criteria andModuleColorIsNull() {
            addCriterion("module_color is null");
            return (Criteria) this;
        }

        public Criteria andModuleColorIsNotNull() {
            addCriterion("module_color is not null");
            return (Criteria) this;
        }

        public Criteria andModuleColorEqualTo(String value) {
            addCriterion("module_color =", value, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorNotEqualTo(String value) {
            addCriterion("module_color <>", value, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorGreaterThan(String value) {
            addCriterion("module_color >", value, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorGreaterThanOrEqualTo(String value) {
            addCriterion("module_color >=", value, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorLessThan(String value) {
            addCriterion("module_color <", value, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorLessThanOrEqualTo(String value) {
            addCriterion("module_color <=", value, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorLike(String value) {
            addCriterion("module_color like", value, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorNotLike(String value) {
            addCriterion("module_color not like", value, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorIn(List<String> values) {
            addCriterion("module_color in", values, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorNotIn(List<String> values) {
            addCriterion("module_color not in", values, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorBetween(String value1, String value2) {
            addCriterion("module_color between", value1, value2, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleColorNotBetween(String value1, String value2) {
            addCriterion("module_color not between", value1, value2, "moduleColor");
            return (Criteria) this;
        }

        public Criteria andModuleImageIsNull() {
            addCriterion("module_image is null");
            return (Criteria) this;
        }

        public Criteria andModuleImageIsNotNull() {
            addCriterion("module_image is not null");
            return (Criteria) this;
        }

        public Criteria andModuleImageEqualTo(String value) {
            addCriterion("module_image =", value, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageNotEqualTo(String value) {
            addCriterion("module_image <>", value, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageGreaterThan(String value) {
            addCriterion("module_image >", value, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageGreaterThanOrEqualTo(String value) {
            addCriterion("module_image >=", value, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageLessThan(String value) {
            addCriterion("module_image <", value, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageLessThanOrEqualTo(String value) {
            addCriterion("module_image <=", value, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageLike(String value) {
            addCriterion("module_image like", value, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageNotLike(String value) {
            addCriterion("module_image not like", value, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageIn(List<String> values) {
            addCriterion("module_image in", values, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageNotIn(List<String> values) {
            addCriterion("module_image not in", values, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageBetween(String value1, String value2) {
            addCriterion("module_image between", value1, value2, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleImageNotBetween(String value1, String value2) {
            addCriterion("module_image not between", value1, value2, "moduleImage");
            return (Criteria) this;
        }

        public Criteria andModuleUrlIsNull() {
            addCriterion("module_url is null");
            return (Criteria) this;
        }

        public Criteria andModuleUrlIsNotNull() {
            addCriterion("module_url is not null");
            return (Criteria) this;
        }

        public Criteria andModuleUrlEqualTo(String value) {
            addCriterion("module_url =", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotEqualTo(String value) {
            addCriterion("module_url <>", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlGreaterThan(String value) {
            addCriterion("module_url >", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlGreaterThanOrEqualTo(String value) {
            addCriterion("module_url >=", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlLessThan(String value) {
            addCriterion("module_url <", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlLessThanOrEqualTo(String value) {
            addCriterion("module_url <=", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlLike(String value) {
            addCriterion("module_url like", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotLike(String value) {
            addCriterion("module_url not like", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlIn(List<String> values) {
            addCriterion("module_url in", values, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotIn(List<String> values) {
            addCriterion("module_url not in", values, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlBetween(String value1, String value2) {
            addCriterion("module_url between", value1, value2, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotBetween(String value1, String value2) {
            addCriterion("module_url not between", value1, value2, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleSortIsNull() {
            addCriterion("module_sort is null");
            return (Criteria) this;
        }

        public Criteria andModuleSortIsNotNull() {
            addCriterion("module_sort is not null");
            return (Criteria) this;
        }

        public Criteria andModuleSortEqualTo(String value) {
            addCriterion("module_sort =", value, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortNotEqualTo(String value) {
            addCriterion("module_sort <>", value, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortGreaterThan(String value) {
            addCriterion("module_sort >", value, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortGreaterThanOrEqualTo(String value) {
            addCriterion("module_sort >=", value, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortLessThan(String value) {
            addCriterion("module_sort <", value, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortLessThanOrEqualTo(String value) {
            addCriterion("module_sort <=", value, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortLike(String value) {
            addCriterion("module_sort like", value, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortNotLike(String value) {
            addCriterion("module_sort not like", value, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortIn(List<String> values) {
            addCriterion("module_sort in", values, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortNotIn(List<String> values) {
            addCriterion("module_sort not in", values, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortBetween(String value1, String value2) {
            addCriterion("module_sort between", value1, value2, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andModuleSortNotBetween(String value1, String value2) {
            addCriterion("module_sort not between", value1, value2, "moduleSort");
            return (Criteria) this;
        }

        public Criteria andIsVariableIsNull() {
            addCriterion("is_variable is null");
            return (Criteria) this;
        }

        public Criteria andIsVariableIsNotNull() {
            addCriterion("is_variable is not null");
            return (Criteria) this;
        }

        public Criteria andIsVariableEqualTo(Integer value) {
            addCriterion("is_variable =", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableNotEqualTo(Integer value) {
            addCriterion("is_variable <>", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableGreaterThan(Integer value) {
            addCriterion("is_variable >", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_variable >=", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableLessThan(Integer value) {
            addCriterion("is_variable <", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableLessThanOrEqualTo(Integer value) {
            addCriterion("is_variable <=", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableIn(List<Integer> values) {
            addCriterion("is_variable in", values, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableNotIn(List<Integer> values) {
            addCriterion("is_variable not in", values, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableBetween(Integer value1, Integer value2) {
            addCriterion("is_variable between", value1, value2, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableNotBetween(Integer value1, Integer value2) {
            addCriterion("is_variable not between", value1, value2, "isVariable");
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