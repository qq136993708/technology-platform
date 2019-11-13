package com.pcitc.base.stp.IntlProject;

import java.util.ArrayList;
import java.util.List;

public class IntlProjectRemarkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntlProjectRemarkExample() {
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

        public Criteria andRemarkIdIsNull() {
            addCriterion("remark_id is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIdIsNotNull() {
            addCriterion("remark_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkIdEqualTo(String value) {
            addCriterion("remark_id =", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdNotEqualTo(String value) {
            addCriterion("remark_id <>", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdGreaterThan(String value) {
            addCriterion("remark_id >", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdGreaterThanOrEqualTo(String value) {
            addCriterion("remark_id >=", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdLessThan(String value) {
            addCriterion("remark_id <", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdLessThanOrEqualTo(String value) {
            addCriterion("remark_id <=", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdLike(String value) {
            addCriterion("remark_id like", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdNotLike(String value) {
            addCriterion("remark_id not like", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdIn(List<String> values) {
            addCriterion("remark_id in", values, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdNotIn(List<String> values) {
            addCriterion("remark_id not in", values, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdBetween(String value1, String value2) {
            addCriterion("remark_id between", value1, value2, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdNotBetween(String value1, String value2) {
            addCriterion("remark_id not between", value1, value2, "remarkId");
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

        public Criteria andRemarkPeopleIsNull() {
            addCriterion("remark_people is null");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleIsNotNull() {
            addCriterion("remark_people is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleEqualTo(String value) {
            addCriterion("remark_people =", value, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleNotEqualTo(String value) {
            addCriterion("remark_people <>", value, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleGreaterThan(String value) {
            addCriterion("remark_people >", value, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("remark_people >=", value, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleLessThan(String value) {
            addCriterion("remark_people <", value, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleLessThanOrEqualTo(String value) {
            addCriterion("remark_people <=", value, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleLike(String value) {
            addCriterion("remark_people like", value, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleNotLike(String value) {
            addCriterion("remark_people not like", value, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleIn(List<String> values) {
            addCriterion("remark_people in", values, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleNotIn(List<String> values) {
            addCriterion("remark_people not in", values, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleBetween(String value1, String value2) {
            addCriterion("remark_people between", value1, value2, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkPeopleNotBetween(String value1, String value2) {
            addCriterion("remark_people not between", value1, value2, "remarkPeople");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleIsNull() {
            addCriterion("remark_title is null");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleIsNotNull() {
            addCriterion("remark_title is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleEqualTo(String value) {
            addCriterion("remark_title =", value, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleNotEqualTo(String value) {
            addCriterion("remark_title <>", value, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleGreaterThan(String value) {
            addCriterion("remark_title >", value, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleGreaterThanOrEqualTo(String value) {
            addCriterion("remark_title >=", value, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleLessThan(String value) {
            addCriterion("remark_title <", value, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleLessThanOrEqualTo(String value) {
            addCriterion("remark_title <=", value, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleLike(String value) {
            addCriterion("remark_title like", value, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleNotLike(String value) {
            addCriterion("remark_title not like", value, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleIn(List<String> values) {
            addCriterion("remark_title in", values, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleNotIn(List<String> values) {
            addCriterion("remark_title not in", values, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleBetween(String value1, String value2) {
            addCriterion("remark_title between", value1, value2, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkTitleNotBetween(String value1, String value2) {
            addCriterion("remark_title not between", value1, value2, "remarkTitle");
            return (Criteria) this;
        }

        public Criteria andRemarkContentIsNull() {
            addCriterion("remark_content is null");
            return (Criteria) this;
        }

        public Criteria andRemarkContentIsNotNull() {
            addCriterion("remark_content is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkContentEqualTo(String value) {
            addCriterion("remark_content =", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentNotEqualTo(String value) {
            addCriterion("remark_content <>", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentGreaterThan(String value) {
            addCriterion("remark_content >", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentGreaterThanOrEqualTo(String value) {
            addCriterion("remark_content >=", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentLessThan(String value) {
            addCriterion("remark_content <", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentLessThanOrEqualTo(String value) {
            addCriterion("remark_content <=", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentLike(String value) {
            addCriterion("remark_content like", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentNotLike(String value) {
            addCriterion("remark_content not like", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentIn(List<String> values) {
            addCriterion("remark_content in", values, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentNotIn(List<String> values) {
            addCriterion("remark_content not in", values, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentBetween(String value1, String value2) {
            addCriterion("remark_content between", value1, value2, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentNotBetween(String value1, String value2) {
            addCriterion("remark_content not between", value1, value2, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeIsNull() {
            addCriterion("remark_type is null");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeIsNotNull() {
            addCriterion("remark_type is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeEqualTo(String value) {
            addCriterion("remark_type =", value, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeNotEqualTo(String value) {
            addCriterion("remark_type <>", value, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeGreaterThan(String value) {
            addCriterion("remark_type >", value, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("remark_type >=", value, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeLessThan(String value) {
            addCriterion("remark_type <", value, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeLessThanOrEqualTo(String value) {
            addCriterion("remark_type <=", value, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeLike(String value) {
            addCriterion("remark_type like", value, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeNotLike(String value) {
            addCriterion("remark_type not like", value, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeIn(List<String> values) {
            addCriterion("remark_type in", values, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeNotIn(List<String> values) {
            addCriterion("remark_type not in", values, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeBetween(String value1, String value2) {
            addCriterion("remark_type between", value1, value2, "remarkType");
            return (Criteria) this;
        }

        public Criteria andRemarkTypeNotBetween(String value1, String value2) {
            addCriterion("remark_type not between", value1, value2, "remarkType");
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

        public Criteria andRemarkAuthorIsNull() {
            addCriterion("remark_author is null");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorIsNotNull() {
            addCriterion("remark_author is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorEqualTo(String value) {
            addCriterion("remark_author =", value, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorNotEqualTo(String value) {
            addCriterion("remark_author <>", value, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorGreaterThan(String value) {
            addCriterion("remark_author >", value, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("remark_author >=", value, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorLessThan(String value) {
            addCriterion("remark_author <", value, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorLessThanOrEqualTo(String value) {
            addCriterion("remark_author <=", value, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorLike(String value) {
            addCriterion("remark_author like", value, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorNotLike(String value) {
            addCriterion("remark_author not like", value, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorIn(List<String> values) {
            addCriterion("remark_author in", values, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorNotIn(List<String> values) {
            addCriterion("remark_author not in", values, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorBetween(String value1, String value2) {
            addCriterion("remark_author between", value1, value2, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andRemarkAuthorNotBetween(String value1, String value2) {
            addCriterion("remark_author not between", value1, value2, "remarkAuthor");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneIsNull() {
            addCriterion("author_phone is null");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneIsNotNull() {
            addCriterion("author_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneEqualTo(String value) {
            addCriterion("author_phone =", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneNotEqualTo(String value) {
            addCriterion("author_phone <>", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneGreaterThan(String value) {
            addCriterion("author_phone >", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("author_phone >=", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneLessThan(String value) {
            addCriterion("author_phone <", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneLessThanOrEqualTo(String value) {
            addCriterion("author_phone <=", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneLike(String value) {
            addCriterion("author_phone like", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneNotLike(String value) {
            addCriterion("author_phone not like", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneIn(List<String> values) {
            addCriterion("author_phone in", values, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneNotIn(List<String> values) {
            addCriterion("author_phone not in", values, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneBetween(String value1, String value2) {
            addCriterion("author_phone between", value1, value2, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneNotBetween(String value1, String value2) {
            addCriterion("author_phone not between", value1, value2, "authorPhone");
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