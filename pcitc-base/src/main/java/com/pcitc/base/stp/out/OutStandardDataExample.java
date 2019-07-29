package com.pcitc.base.stp.out;

import java.util.ArrayList;
import java.util.List;

public class OutStandardDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public OutStandardDataExample() {
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

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
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

        public Criteria andNdIsNull() {
            addCriterion("nd is null");
            return (Criteria) this;
        }

        public Criteria andNdIsNotNull() {
            addCriterion("nd is not null");
            return (Criteria) this;
        }

        public Criteria andNdEqualTo(String value) {
            addCriterion("nd =", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotEqualTo(String value) {
            addCriterion("nd <>", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThan(String value) {
            addCriterion("nd >", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThanOrEqualTo(String value) {
            addCriterion("nd >=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThan(String value) {
            addCriterion("nd <", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThanOrEqualTo(String value) {
            addCriterion("nd <=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLike(String value) {
            addCriterion("nd like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotLike(String value) {
            addCriterion("nd not like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdIn(List<String> values) {
            addCriterion("nd in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotIn(List<String> values) {
            addCriterion("nd not in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdBetween(String value1, String value2) {
            addCriterion("nd between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotBetween(String value1, String value2) {
            addCriterion("nd not between", value1, value2, "nd");
            return (Criteria) this;
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

        public Criteria andCriterionchnameIsNull() {
            addCriterion("criterionchname is null");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameIsNotNull() {
            addCriterion("criterionchname is not null");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameEqualTo(String value) {
            addCriterion("criterionchname =", value, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameNotEqualTo(String value) {
            addCriterion("criterionchname <>", value, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameGreaterThan(String value) {
            addCriterion("criterionchname >", value, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameGreaterThanOrEqualTo(String value) {
            addCriterion("criterionchname >=", value, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameLessThan(String value) {
            addCriterion("criterionchname <", value, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameLessThanOrEqualTo(String value) {
            addCriterion("criterionchname <=", value, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameLike(String value) {
            addCriterion("criterionchname like", value, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameNotLike(String value) {
            addCriterion("criterionchname not like", value, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameIn(List<String> values) {
            addCriterion("criterionchname in", values, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameNotIn(List<String> values) {
            addCriterion("criterionchname not in", values, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameBetween(String value1, String value2) {
            addCriterion("criterionchname between", value1, value2, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionchnameNotBetween(String value1, String value2) {
            addCriterion("criterionchname not between", value1, value2, "criterionchname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameIsNull() {
            addCriterion("criterionegname is null");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameIsNotNull() {
            addCriterion("criterionegname is not null");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameEqualTo(String value) {
            addCriterion("criterionegname =", value, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameNotEqualTo(String value) {
            addCriterion("criterionegname <>", value, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameGreaterThan(String value) {
            addCriterion("criterionegname >", value, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameGreaterThanOrEqualTo(String value) {
            addCriterion("criterionegname >=", value, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameLessThan(String value) {
            addCriterion("criterionegname <", value, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameLessThanOrEqualTo(String value) {
            addCriterion("criterionegname <=", value, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameLike(String value) {
            addCriterion("criterionegname like", value, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameNotLike(String value) {
            addCriterion("criterionegname not like", value, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameIn(List<String> values) {
            addCriterion("criterionegname in", values, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameNotIn(List<String> values) {
            addCriterion("criterionegname not in", values, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameBetween(String value1, String value2) {
            addCriterion("criterionegname between", value1, value2, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionegnameNotBetween(String value1, String value2) {
            addCriterion("criterionegname not between", value1, value2, "criterionegname");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberIsNull() {
            addCriterion("criterionnumber is null");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberIsNotNull() {
            addCriterion("criterionnumber is not null");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberEqualTo(String value) {
            addCriterion("criterionnumber =", value, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberNotEqualTo(String value) {
            addCriterion("criterionnumber <>", value, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberGreaterThan(String value) {
            addCriterion("criterionnumber >", value, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberGreaterThanOrEqualTo(String value) {
            addCriterion("criterionnumber >=", value, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberLessThan(String value) {
            addCriterion("criterionnumber <", value, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberLessThanOrEqualTo(String value) {
            addCriterion("criterionnumber <=", value, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberLike(String value) {
            addCriterion("criterionnumber like", value, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberNotLike(String value) {
            addCriterion("criterionnumber not like", value, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberIn(List<String> values) {
            addCriterion("criterionnumber in", values, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberNotIn(List<String> values) {
            addCriterion("criterionnumber not in", values, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberBetween(String value1, String value2) {
            addCriterion("criterionnumber between", value1, value2, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andCriterionnumberNotBetween(String value1, String value2) {
            addCriterion("criterionnumber not between", value1, value2, "criterionnumber");
            return (Criteria) this;
        }

        public Criteria andPubdateIsNull() {
            addCriterion("pubdate is null");
            return (Criteria) this;
        }

        public Criteria andPubdateIsNotNull() {
            addCriterion("pubdate is not null");
            return (Criteria) this;
        }

        public Criteria andPubdateEqualTo(String value) {
            addCriterion("pubdate =", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotEqualTo(String value) {
            addCriterion("pubdate <>", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateGreaterThan(String value) {
            addCriterion("pubdate >", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateGreaterThanOrEqualTo(String value) {
            addCriterion("pubdate >=", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateLessThan(String value) {
            addCriterion("pubdate <", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateLessThanOrEqualTo(String value) {
            addCriterion("pubdate <=", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateLike(String value) {
            addCriterion("pubdate like", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotLike(String value) {
            addCriterion("pubdate not like", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateIn(List<String> values) {
            addCriterion("pubdate in", values, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotIn(List<String> values) {
            addCriterion("pubdate not in", values, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateBetween(String value1, String value2) {
            addCriterion("pubdate between", value1, value2, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotBetween(String value1, String value2) {
            addCriterion("pubdate not between", value1, value2, "pubdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateIsNull() {
            addCriterion("implementdate is null");
            return (Criteria) this;
        }

        public Criteria andImplementdateIsNotNull() {
            addCriterion("implementdate is not null");
            return (Criteria) this;
        }

        public Criteria andImplementdateEqualTo(String value) {
            addCriterion("implementdate =", value, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateNotEqualTo(String value) {
            addCriterion("implementdate <>", value, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateGreaterThan(String value) {
            addCriterion("implementdate >", value, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateGreaterThanOrEqualTo(String value) {
            addCriterion("implementdate >=", value, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateLessThan(String value) {
            addCriterion("implementdate <", value, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateLessThanOrEqualTo(String value) {
            addCriterion("implementdate <=", value, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateLike(String value) {
            addCriterion("implementdate like", value, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateNotLike(String value) {
            addCriterion("implementdate not like", value, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateIn(List<String> values) {
            addCriterion("implementdate in", values, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateNotIn(List<String> values) {
            addCriterion("implementdate not in", values, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateBetween(String value1, String value2) {
            addCriterion("implementdate between", value1, value2, "implementdate");
            return (Criteria) this;
        }

        public Criteria andImplementdateNotBetween(String value1, String value2) {
            addCriterion("implementdate not between", value1, value2, "implementdate");
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

        public Criteria andDataSourceIsNull() {
            addCriterion("data_source is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("data_source is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(String value) {
            addCriterion("data_source =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(String value) {
            addCriterion("data_source <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(String value) {
            addCriterion("data_source >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(String value) {
            addCriterion("data_source >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(String value) {
            addCriterion("data_source <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(String value) {
            addCriterion("data_source <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLike(String value) {
            addCriterion("data_source like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotLike(String value) {
            addCriterion("data_source not like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<String> values) {
            addCriterion("data_source in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<String> values) {
            addCriterion("data_source not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(String value1, String value2) {
            addCriterion("data_source between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(String value1, String value2) {
            addCriterion("data_source not between", value1, value2, "dataSource");
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