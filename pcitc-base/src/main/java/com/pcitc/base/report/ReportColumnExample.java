package com.pcitc.base.report;


import java.util.ArrayList;
import java.util.List;

public class ReportColumnExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ReportColumnExample() {
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

        public Criteria andReportConfigIdIsNull() {
            addCriterion("report_config_id is null");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdIsNotNull() {
            addCriterion("report_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdEqualTo(String value) {
            addCriterion("report_config_id =", value, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdNotEqualTo(String value) {
            addCriterion("report_config_id <>", value, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdGreaterThan(String value) {
            addCriterion("report_config_id >", value, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdGreaterThanOrEqualTo(String value) {
            addCriterion("report_config_id >=", value, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdLessThan(String value) {
            addCriterion("report_config_id <", value, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdLessThanOrEqualTo(String value) {
            addCriterion("report_config_id <=", value, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdLike(String value) {
            addCriterion("report_config_id like", value, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdNotLike(String value) {
            addCriterion("report_config_id not like", value, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdIn(List<String> values) {
            addCriterion("report_config_id in", values, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdNotIn(List<String> values) {
            addCriterion("report_config_id not in", values, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdBetween(String value1, String value2) {
            addCriterion("report_config_id between", value1, value2, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andReportConfigIdNotBetween(String value1, String value2) {
            addCriterion("report_config_id not between", value1, value2, "reportConfigId");
            return (Criteria) this;
        }

        public Criteria andFieldIsNull() {
            addCriterion("field is null");
            return (Criteria) this;
        }

        public Criteria andFieldIsNotNull() {
            addCriterion("field is not null");
            return (Criteria) this;
        }

        public Criteria andFieldEqualTo(String value) {
            addCriterion("field =", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotEqualTo(String value) {
            addCriterion("field <>", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThan(String value) {
            addCriterion("field >", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThanOrEqualTo(String value) {
            addCriterion("field >=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThan(String value) {
            addCriterion("field <", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThanOrEqualTo(String value) {
            addCriterion("field <=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLike(String value) {
            addCriterion("field like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotLike(String value) {
            addCriterion("field not like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldIn(List<String> values) {
            addCriterion("field in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotIn(List<String> values) {
            addCriterion("field not in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldBetween(String value1, String value2) {
            addCriterion("field between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotBetween(String value1, String value2) {
            addCriterion("field not between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(String value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(String value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(String value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(String value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(String value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(String value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLike(String value) {
            addCriterion("width like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotLike(String value) {
            addCriterion("width not like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<String> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<String> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(String value1, String value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(String value1, String value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andMinwidthIsNull() {
            addCriterion("minWidth is null");
            return (Criteria) this;
        }

        public Criteria andMinwidthIsNotNull() {
            addCriterion("minWidth is not null");
            return (Criteria) this;
        }

        public Criteria andMinwidthEqualTo(String value) {
            addCriterion("minWidth =", value, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthNotEqualTo(String value) {
            addCriterion("minWidth <>", value, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthGreaterThan(String value) {
            addCriterion("minWidth >", value, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthGreaterThanOrEqualTo(String value) {
            addCriterion("minWidth >=", value, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthLessThan(String value) {
            addCriterion("minWidth <", value, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthLessThanOrEqualTo(String value) {
            addCriterion("minWidth <=", value, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthLike(String value) {
            addCriterion("minWidth like", value, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthNotLike(String value) {
            addCriterion("minWidth not like", value, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthIn(List<String> values) {
            addCriterion("minWidth in", values, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthNotIn(List<String> values) {
            addCriterion("minWidth not in", values, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthBetween(String value1, String value2) {
            addCriterion("minWidth between", value1, value2, "minwidth");
            return (Criteria) this;
        }

        public Criteria andMinwidthNotBetween(String value1, String value2) {
            addCriterion("minWidth not between", value1, value2, "minwidth");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(String value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(String value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(String value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(String value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(String value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(String value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLike(String value) {
            addCriterion("sort like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotLike(String value) {
            addCriterion("sort not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<String> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<String> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(String value1, String value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(String value1, String value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andUnresizeIsNull() {
            addCriterion("unresize is null");
            return (Criteria) this;
        }

        public Criteria andUnresizeIsNotNull() {
            addCriterion("unresize is not null");
            return (Criteria) this;
        }

        public Criteria andUnresizeEqualTo(String value) {
            addCriterion("unresize =", value, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeNotEqualTo(String value) {
            addCriterion("unresize <>", value, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeGreaterThan(String value) {
            addCriterion("unresize >", value, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeGreaterThanOrEqualTo(String value) {
            addCriterion("unresize >=", value, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeLessThan(String value) {
            addCriterion("unresize <", value, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeLessThanOrEqualTo(String value) {
            addCriterion("unresize <=", value, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeLike(String value) {
            addCriterion("unresize like", value, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeNotLike(String value) {
            addCriterion("unresize not like", value, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeIn(List<String> values) {
            addCriterion("unresize in", values, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeNotIn(List<String> values) {
            addCriterion("unresize not in", values, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeBetween(String value1, String value2) {
            addCriterion("unresize between", value1, value2, "unresize");
            return (Criteria) this;
        }

        public Criteria andUnresizeNotBetween(String value1, String value2) {
            addCriterion("unresize not between", value1, value2, "unresize");
            return (Criteria) this;
        }

        public Criteria andEditIsNull() {
            addCriterion("edit is null");
            return (Criteria) this;
        }

        public Criteria andEditIsNotNull() {
            addCriterion("edit is not null");
            return (Criteria) this;
        }

        public Criteria andEditEqualTo(String value) {
            addCriterion("edit =", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotEqualTo(String value) {
            addCriterion("edit <>", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditGreaterThan(String value) {
            addCriterion("edit >", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditGreaterThanOrEqualTo(String value) {
            addCriterion("edit >=", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditLessThan(String value) {
            addCriterion("edit <", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditLessThanOrEqualTo(String value) {
            addCriterion("edit <=", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditLike(String value) {
            addCriterion("edit like", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotLike(String value) {
            addCriterion("edit not like", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditIn(List<String> values) {
            addCriterion("edit in", values, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotIn(List<String> values) {
            addCriterion("edit not in", values, "edit");
            return (Criteria) this;
        }

        public Criteria andEditBetween(String value1, String value2) {
            addCriterion("edit between", value1, value2, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotBetween(String value1, String value2) {
            addCriterion("edit not between", value1, value2, "edit");
            return (Criteria) this;
        }

        public Criteria andEventIsNull() {
            addCriterion("event is null");
            return (Criteria) this;
        }

        public Criteria andEventIsNotNull() {
            addCriterion("event is not null");
            return (Criteria) this;
        }

        public Criteria andEventEqualTo(String value) {
            addCriterion("event =", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotEqualTo(String value) {
            addCriterion("event <>", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventGreaterThan(String value) {
            addCriterion("event >", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventGreaterThanOrEqualTo(String value) {
            addCriterion("event >=", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLessThan(String value) {
            addCriterion("event <", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLessThanOrEqualTo(String value) {
            addCriterion("event <=", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLike(String value) {
            addCriterion("event like", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotLike(String value) {
            addCriterion("event not like", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventIn(List<String> values) {
            addCriterion("event in", values, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotIn(List<String> values) {
            addCriterion("event not in", values, "event");
            return (Criteria) this;
        }

        public Criteria andEventBetween(String value1, String value2) {
            addCriterion("event between", value1, value2, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotBetween(String value1, String value2) {
            addCriterion("event not between", value1, value2, "event");
            return (Criteria) this;
        }

        public Criteria andStyleIsNull() {
            addCriterion("style is null");
            return (Criteria) this;
        }

        public Criteria andStyleIsNotNull() {
            addCriterion("style is not null");
            return (Criteria) this;
        }

        public Criteria andStyleEqualTo(String value) {
            addCriterion("style =", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotEqualTo(String value) {
            addCriterion("style <>", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThan(String value) {
            addCriterion("style >", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThanOrEqualTo(String value) {
            addCriterion("style >=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThan(String value) {
            addCriterion("style <", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThanOrEqualTo(String value) {
            addCriterion("style <=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLike(String value) {
            addCriterion("style like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotLike(String value) {
            addCriterion("style not like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleIn(List<String> values) {
            addCriterion("style in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotIn(List<String> values) {
            addCriterion("style not in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleBetween(String value1, String value2) {
            addCriterion("style between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotBetween(String value1, String value2) {
            addCriterion("style not between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andAlignIsNull() {
            addCriterion("align is null");
            return (Criteria) this;
        }

        public Criteria andAlignIsNotNull() {
            addCriterion("align is not null");
            return (Criteria) this;
        }

        public Criteria andAlignEqualTo(String value) {
            addCriterion("align =", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotEqualTo(String value) {
            addCriterion("align <>", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignGreaterThan(String value) {
            addCriterion("align >", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignGreaterThanOrEqualTo(String value) {
            addCriterion("align >=", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLessThan(String value) {
            addCriterion("align <", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLessThanOrEqualTo(String value) {
            addCriterion("align <=", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLike(String value) {
            addCriterion("align like", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotLike(String value) {
            addCriterion("align not like", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignIn(List<String> values) {
            addCriterion("align in", values, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotIn(List<String> values) {
            addCriterion("align not in", values, "align");
            return (Criteria) this;
        }

        public Criteria andAlignBetween(String value1, String value2) {
            addCriterion("align between", value1, value2, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotBetween(String value1, String value2) {
            addCriterion("align not between", value1, value2, "align");
            return (Criteria) this;
        }

        public Criteria andColspanIsNull() {
            addCriterion("colspan is null");
            return (Criteria) this;
        }

        public Criteria andColspanIsNotNull() {
            addCriterion("colspan is not null");
            return (Criteria) this;
        }

        public Criteria andColspanEqualTo(String value) {
            addCriterion("colspan =", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotEqualTo(String value) {
            addCriterion("colspan <>", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanGreaterThan(String value) {
            addCriterion("colspan >", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanGreaterThanOrEqualTo(String value) {
            addCriterion("colspan >=", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLessThan(String value) {
            addCriterion("colspan <", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLessThanOrEqualTo(String value) {
            addCriterion("colspan <=", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLike(String value) {
            addCriterion("colspan like", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotLike(String value) {
            addCriterion("colspan not like", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanIn(List<String> values) {
            addCriterion("colspan in", values, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotIn(List<String> values) {
            addCriterion("colspan not in", values, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanBetween(String value1, String value2) {
            addCriterion("colspan between", value1, value2, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotBetween(String value1, String value2) {
            addCriterion("colspan not between", value1, value2, "colspan");
            return (Criteria) this;
        }

        public Criteria andRowspanIsNull() {
            addCriterion("rowspan is null");
            return (Criteria) this;
        }

        public Criteria andRowspanIsNotNull() {
            addCriterion("rowspan is not null");
            return (Criteria) this;
        }

        public Criteria andRowspanEqualTo(String value) {
            addCriterion("rowspan =", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanNotEqualTo(String value) {
            addCriterion("rowspan <>", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanGreaterThan(String value) {
            addCriterion("rowspan >", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanGreaterThanOrEqualTo(String value) {
            addCriterion("rowspan >=", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanLessThan(String value) {
            addCriterion("rowspan <", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanLessThanOrEqualTo(String value) {
            addCriterion("rowspan <=", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanLike(String value) {
            addCriterion("rowspan like", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanNotLike(String value) {
            addCriterion("rowspan not like", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanIn(List<String> values) {
            addCriterion("rowspan in", values, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanNotIn(List<String> values) {
            addCriterion("rowspan not in", values, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanBetween(String value1, String value2) {
            addCriterion("rowspan between", value1, value2, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanNotBetween(String value1, String value2) {
            addCriterion("rowspan not between", value1, value2, "rowspan");
            return (Criteria) this;
        }

        public Criteria andTempletIsNull() {
            addCriterion("templet is null");
            return (Criteria) this;
        }

        public Criteria andTempletIsNotNull() {
            addCriterion("templet is not null");
            return (Criteria) this;
        }

        public Criteria andTempletEqualTo(String value) {
            addCriterion("templet =", value, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletNotEqualTo(String value) {
            addCriterion("templet <>", value, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletGreaterThan(String value) {
            addCriterion("templet >", value, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletGreaterThanOrEqualTo(String value) {
            addCriterion("templet >=", value, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletLessThan(String value) {
            addCriterion("templet <", value, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletLessThanOrEqualTo(String value) {
            addCriterion("templet <=", value, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletLike(String value) {
            addCriterion("templet like", value, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletNotLike(String value) {
            addCriterion("templet not like", value, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletIn(List<String> values) {
            addCriterion("templet in", values, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletNotIn(List<String> values) {
            addCriterion("templet not in", values, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletBetween(String value1, String value2) {
            addCriterion("templet between", value1, value2, "templet");
            return (Criteria) this;
        }

        public Criteria andTempletNotBetween(String value1, String value2) {
            addCriterion("templet not between", value1, value2, "templet");
            return (Criteria) this;
        }

        public Criteria andToolbarIsNull() {
            addCriterion("toolbar is null");
            return (Criteria) this;
        }

        public Criteria andToolbarIsNotNull() {
            addCriterion("toolbar is not null");
            return (Criteria) this;
        }

        public Criteria andToolbarEqualTo(String value) {
            addCriterion("toolbar =", value, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarNotEqualTo(String value) {
            addCriterion("toolbar <>", value, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarGreaterThan(String value) {
            addCriterion("toolbar >", value, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarGreaterThanOrEqualTo(String value) {
            addCriterion("toolbar >=", value, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarLessThan(String value) {
            addCriterion("toolbar <", value, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarLessThanOrEqualTo(String value) {
            addCriterion("toolbar <=", value, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarLike(String value) {
            addCriterion("toolbar like", value, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarNotLike(String value) {
            addCriterion("toolbar not like", value, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarIn(List<String> values) {
            addCriterion("toolbar in", values, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarNotIn(List<String> values) {
            addCriterion("toolbar not in", values, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarBetween(String value1, String value2) {
            addCriterion("toolbar between", value1, value2, "toolbar");
            return (Criteria) this;
        }

        public Criteria andToolbarNotBetween(String value1, String value2) {
            addCriterion("toolbar not between", value1, value2, "toolbar");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("role like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("role not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andSfShowlistIsNull() {
            addCriterion("sf_showlist is null");
            return (Criteria) this;
        }

        public Criteria andSfShowlistIsNotNull() {
            addCriterion("sf_showlist is not null");
            return (Criteria) this;
        }

        public Criteria andSfShowlistEqualTo(String value) {
            addCriterion("sf_showlist =", value, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistNotEqualTo(String value) {
            addCriterion("sf_showlist <>", value, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistGreaterThan(String value) {
            addCriterion("sf_showlist >", value, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistGreaterThanOrEqualTo(String value) {
            addCriterion("sf_showlist >=", value, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistLessThan(String value) {
            addCriterion("sf_showlist <", value, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistLessThanOrEqualTo(String value) {
            addCriterion("sf_showlist <=", value, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistLike(String value) {
            addCriterion("sf_showlist like", value, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistNotLike(String value) {
            addCriterion("sf_showlist not like", value, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistIn(List<String> values) {
            addCriterion("sf_showlist in", values, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistNotIn(List<String> values) {
            addCriterion("sf_showlist not in", values, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistBetween(String value1, String value2) {
            addCriterion("sf_showlist between", value1, value2, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfShowlistNotBetween(String value1, String value2) {
            addCriterion("sf_showlist not between", value1, value2, "sfShowlist");
            return (Criteria) this;
        }

        public Criteria andSfXIsNull() {
            addCriterion("sf_x is null");
            return (Criteria) this;
        }

        public Criteria andSfXIsNotNull() {
            addCriterion("sf_x is not null");
            return (Criteria) this;
        }

        public Criteria andSfXEqualTo(String value) {
            addCriterion("sf_x =", value, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXNotEqualTo(String value) {
            addCriterion("sf_x <>", value, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXGreaterThan(String value) {
            addCriterion("sf_x >", value, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXGreaterThanOrEqualTo(String value) {
            addCriterion("sf_x >=", value, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXLessThan(String value) {
            addCriterion("sf_x <", value, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXLessThanOrEqualTo(String value) {
            addCriterion("sf_x <=", value, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXLike(String value) {
            addCriterion("sf_x like", value, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXNotLike(String value) {
            addCriterion("sf_x not like", value, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXIn(List<String> values) {
            addCriterion("sf_x in", values, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXNotIn(List<String> values) {
            addCriterion("sf_x not in", values, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXBetween(String value1, String value2) {
            addCriterion("sf_x between", value1, value2, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfXNotBetween(String value1, String value2) {
            addCriterion("sf_x not between", value1, value2, "sfX");
            return (Criteria) this;
        }

        public Criteria andSfYIsNull() {
            addCriterion("sf_y is null");
            return (Criteria) this;
        }

        public Criteria andSfYIsNotNull() {
            addCriterion("sf_y is not null");
            return (Criteria) this;
        }

        public Criteria andSfYEqualTo(String value) {
            addCriterion("sf_y =", value, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYNotEqualTo(String value) {
            addCriterion("sf_y <>", value, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYGreaterThan(String value) {
            addCriterion("sf_y >", value, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYGreaterThanOrEqualTo(String value) {
            addCriterion("sf_y >=", value, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYLessThan(String value) {
            addCriterion("sf_y <", value, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYLessThanOrEqualTo(String value) {
            addCriterion("sf_y <=", value, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYLike(String value) {
            addCriterion("sf_y like", value, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYNotLike(String value) {
            addCriterion("sf_y not like", value, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYIn(List<String> values) {
            addCriterion("sf_y in", values, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYNotIn(List<String> values) {
            addCriterion("sf_y not in", values, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYBetween(String value1, String value2) {
            addCriterion("sf_y between", value1, value2, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfYNotBetween(String value1, String value2) {
            addCriterion("sf_y not between", value1, value2, "sfY");
            return (Criteria) this;
        }

        public Criteria andSfAjaxIsNull() {
            addCriterion("sf_ajax is null");
            return (Criteria) this;
        }

        public Criteria andSfAjaxIsNotNull() {
            addCriterion("sf_ajax is not null");
            return (Criteria) this;
        }

        public Criteria andSfAjaxEqualTo(String value) {
            addCriterion("sf_ajax =", value, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxNotEqualTo(String value) {
            addCriterion("sf_ajax <>", value, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxGreaterThan(String value) {
            addCriterion("sf_ajax >", value, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxGreaterThanOrEqualTo(String value) {
            addCriterion("sf_ajax >=", value, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxLessThan(String value) {
            addCriterion("sf_ajax <", value, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxLessThanOrEqualTo(String value) {
            addCriterion("sf_ajax <=", value, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxLike(String value) {
            addCriterion("sf_ajax like", value, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxNotLike(String value) {
            addCriterion("sf_ajax not like", value, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxIn(List<String> values) {
            addCriterion("sf_ajax in", values, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxNotIn(List<String> values) {
            addCriterion("sf_ajax not in", values, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxBetween(String value1, String value2) {
            addCriterion("sf_ajax between", value1, value2, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andSfAjaxNotBetween(String value1, String value2) {
            addCriterion("sf_ajax not between", value1, value2, "sfAjax");
            return (Criteria) this;
        }

        public Criteria andStypeIsNull() {
            addCriterion("stype is null");
            return (Criteria) this;
        }

        public Criteria andStypeIsNotNull() {
            addCriterion("stype is not null");
            return (Criteria) this;
        }

        public Criteria andStypeEqualTo(String value) {
            addCriterion("stype =", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotEqualTo(String value) {
            addCriterion("stype <>", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeGreaterThan(String value) {
            addCriterion("stype >", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeGreaterThanOrEqualTo(String value) {
            addCriterion("stype >=", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLessThan(String value) {
            addCriterion("stype <", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLessThanOrEqualTo(String value) {
            addCriterion("stype <=", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLike(String value) {
            addCriterion("stype like", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotLike(String value) {
            addCriterion("stype not like", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeIn(List<String> values) {
            addCriterion("stype in", values, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotIn(List<String> values) {
            addCriterion("stype not in", values, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeBetween(String value1, String value2) {
            addCriterion("stype between", value1, value2, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotBetween(String value1, String value2) {
            addCriterion("stype not between", value1, value2, "stype");
            return (Criteria) this;
        }

        public Criteria andSsortIsNull() {
            addCriterion("ssort is null");
            return (Criteria) this;
        }

        public Criteria andSsortIsNotNull() {
            addCriterion("ssort is not null");
            return (Criteria) this;
        }

        public Criteria andSsortEqualTo(String value) {
            addCriterion("ssort =", value, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortNotEqualTo(String value) {
            addCriterion("ssort <>", value, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortGreaterThan(String value) {
            addCriterion("ssort >", value, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortGreaterThanOrEqualTo(String value) {
            addCriterion("ssort >=", value, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortLessThan(String value) {
            addCriterion("ssort <", value, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortLessThanOrEqualTo(String value) {
            addCriterion("ssort <=", value, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortLike(String value) {
            addCriterion("ssort like", value, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortNotLike(String value) {
            addCriterion("ssort not like", value, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortIn(List<String> values) {
            addCriterion("ssort in", values, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortNotIn(List<String> values) {
            addCriterion("ssort not in", values, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortBetween(String value1, String value2) {
            addCriterion("ssort between", value1, value2, "ssort");
            return (Criteria) this;
        }

        public Criteria andSsortNotBetween(String value1, String value2) {
            addCriterion("ssort not between", value1, value2, "ssort");
            return (Criteria) this;
        }

        public Criteria andSfShowIsNull() {
            addCriterion("sf_show is null");
            return (Criteria) this;
        }

        public Criteria andSfShowIsNotNull() {
            addCriterion("sf_show is not null");
            return (Criteria) this;
        }

        public Criteria andSfShowEqualTo(String value) {
            addCriterion("sf_show =", value, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowNotEqualTo(String value) {
            addCriterion("sf_show <>", value, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowGreaterThan(String value) {
            addCriterion("sf_show >", value, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowGreaterThanOrEqualTo(String value) {
            addCriterion("sf_show >=", value, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowLessThan(String value) {
            addCriterion("sf_show <", value, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowLessThanOrEqualTo(String value) {
            addCriterion("sf_show <=", value, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowLike(String value) {
            addCriterion("sf_show like", value, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowNotLike(String value) {
            addCriterion("sf_show not like", value, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowIn(List<String> values) {
            addCriterion("sf_show in", values, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowNotIn(List<String> values) {
            addCriterion("sf_show not in", values, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowBetween(String value1, String value2) {
            addCriterion("sf_show between", value1, value2, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfShowNotBetween(String value1, String value2) {
            addCriterion("sf_show not between", value1, value2, "sfShow");
            return (Criteria) this;
        }

        public Criteria andSfDelIsNull() {
            addCriterion("sf_del is null");
            return (Criteria) this;
        }

        public Criteria andSfDelIsNotNull() {
            addCriterion("sf_del is not null");
            return (Criteria) this;
        }

        public Criteria andSfDelEqualTo(String value) {
            addCriterion("sf_del =", value, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelNotEqualTo(String value) {
            addCriterion("sf_del <>", value, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelGreaterThan(String value) {
            addCriterion("sf_del >", value, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelGreaterThanOrEqualTo(String value) {
            addCriterion("sf_del >=", value, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelLessThan(String value) {
            addCriterion("sf_del <", value, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelLessThanOrEqualTo(String value) {
            addCriterion("sf_del <=", value, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelLike(String value) {
            addCriterion("sf_del like", value, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelNotLike(String value) {
            addCriterion("sf_del not like", value, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelIn(List<String> values) {
            addCriterion("sf_del in", values, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelNotIn(List<String> values) {
            addCriterion("sf_del not in", values, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelBetween(String value1, String value2) {
            addCriterion("sf_del between", value1, value2, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfDelNotBetween(String value1, String value2) {
            addCriterion("sf_del not between", value1, value2, "sfDel");
            return (Criteria) this;
        }

        public Criteria andSfUseIsNull() {
            addCriterion("sf_use is null");
            return (Criteria) this;
        }

        public Criteria andSfUseIsNotNull() {
            addCriterion("sf_use is not null");
            return (Criteria) this;
        }

        public Criteria andSfUseEqualTo(String value) {
            addCriterion("sf_use =", value, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseNotEqualTo(String value) {
            addCriterion("sf_use <>", value, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseGreaterThan(String value) {
            addCriterion("sf_use >", value, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseGreaterThanOrEqualTo(String value) {
            addCriterion("sf_use >=", value, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseLessThan(String value) {
            addCriterion("sf_use <", value, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseLessThanOrEqualTo(String value) {
            addCriterion("sf_use <=", value, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseLike(String value) {
            addCriterion("sf_use like", value, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseNotLike(String value) {
            addCriterion("sf_use not like", value, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseIn(List<String> values) {
            addCriterion("sf_use in", values, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseNotIn(List<String> values) {
            addCriterion("sf_use not in", values, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseBetween(String value1, String value2) {
            addCriterion("sf_use between", value1, value2, "sfUse");
            return (Criteria) this;
        }

        public Criteria andSfUseNotBetween(String value1, String value2) {
            addCriterion("sf_use not between", value1, value2, "sfUse");
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

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andFileidIsNull() {
            addCriterion("fileId is null");
            return (Criteria) this;
        }

        public Criteria andFileidIsNotNull() {
            addCriterion("fileId is not null");
            return (Criteria) this;
        }

        public Criteria andFileidEqualTo(String value) {
            addCriterion("fileId =", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotEqualTo(String value) {
            addCriterion("fileId <>", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThan(String value) {
            addCriterion("fileId >", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThanOrEqualTo(String value) {
            addCriterion("fileId >=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThan(String value) {
            addCriterion("fileId <", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThanOrEqualTo(String value) {
            addCriterion("fileId <=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLike(String value) {
            addCriterion("fileId like", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotLike(String value) {
            addCriterion("fileId not like", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidIn(List<String> values) {
            addCriterion("fileId in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotIn(List<String> values) {
            addCriterion("fileId not in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidBetween(String value1, String value2) {
            addCriterion("fileId between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotBetween(String value1, String value2) {
            addCriterion("fileId not between", value1, value2, "fileid");
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