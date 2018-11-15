package com.pcitc.base.stp.IntlProject;

import java.util.ArrayList;
import java.util.List;

public class IntlProjectAcceptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntlProjectAcceptExample() {
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

        public Criteria andAcceptIdIsNull() {
            addCriterion("accept_id is null");
            return (Criteria) this;
        }

        public Criteria andAcceptIdIsNotNull() {
            addCriterion("accept_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptIdEqualTo(String value) {
            addCriterion("accept_id =", value, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdNotEqualTo(String value) {
            addCriterion("accept_id <>", value, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdGreaterThan(String value) {
            addCriterion("accept_id >", value, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdGreaterThanOrEqualTo(String value) {
            addCriterion("accept_id >=", value, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdLessThan(String value) {
            addCriterion("accept_id <", value, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdLessThanOrEqualTo(String value) {
            addCriterion("accept_id <=", value, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdLike(String value) {
            addCriterion("accept_id like", value, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdNotLike(String value) {
            addCriterion("accept_id not like", value, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdIn(List<String> values) {
            addCriterion("accept_id in", values, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdNotIn(List<String> values) {
            addCriterion("accept_id not in", values, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdBetween(String value1, String value2) {
            addCriterion("accept_id between", value1, value2, "acceptId");
            return (Criteria) this;
        }

        public Criteria andAcceptIdNotBetween(String value1, String value2) {
            addCriterion("accept_id not between", value1, value2, "acceptId");
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

        public Criteria andAcceptNoIsNull() {
            addCriterion("accept_no is null");
            return (Criteria) this;
        }

        public Criteria andAcceptNoIsNotNull() {
            addCriterion("accept_no is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptNoEqualTo(String value) {
            addCriterion("accept_no =", value, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoNotEqualTo(String value) {
            addCriterion("accept_no <>", value, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoGreaterThan(String value) {
            addCriterion("accept_no >", value, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoGreaterThanOrEqualTo(String value) {
            addCriterion("accept_no >=", value, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoLessThan(String value) {
            addCriterion("accept_no <", value, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoLessThanOrEqualTo(String value) {
            addCriterion("accept_no <=", value, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoLike(String value) {
            addCriterion("accept_no like", value, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoNotLike(String value) {
            addCriterion("accept_no not like", value, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoIn(List<String> values) {
            addCriterion("accept_no in", values, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoNotIn(List<String> values) {
            addCriterion("accept_no not in", values, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoBetween(String value1, String value2) {
            addCriterion("accept_no between", value1, value2, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptNoNotBetween(String value1, String value2) {
            addCriterion("accept_no not between", value1, value2, "acceptNo");
            return (Criteria) this;
        }

        public Criteria andAcceptDateIsNull() {
            addCriterion("accept_date is null");
            return (Criteria) this;
        }

        public Criteria andAcceptDateIsNotNull() {
            addCriterion("accept_date is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptDateEqualTo(String value) {
            addCriterion("accept_date =", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotEqualTo(String value) {
            addCriterion("accept_date <>", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateGreaterThan(String value) {
            addCriterion("accept_date >", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateGreaterThanOrEqualTo(String value) {
            addCriterion("accept_date >=", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateLessThan(String value) {
            addCriterion("accept_date <", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateLessThanOrEqualTo(String value) {
            addCriterion("accept_date <=", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateLike(String value) {
            addCriterion("accept_date like", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotLike(String value) {
            addCriterion("accept_date not like", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateIn(List<String> values) {
            addCriterion("accept_date in", values, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotIn(List<String> values) {
            addCriterion("accept_date not in", values, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateBetween(String value1, String value2) {
            addCriterion("accept_date between", value1, value2, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotBetween(String value1, String value2) {
            addCriterion("accept_date not between", value1, value2, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleIsNull() {
            addCriterion("accept_people is null");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleIsNotNull() {
            addCriterion("accept_people is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleEqualTo(String value) {
            addCriterion("accept_people =", value, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleNotEqualTo(String value) {
            addCriterion("accept_people <>", value, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleGreaterThan(String value) {
            addCriterion("accept_people >", value, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("accept_people >=", value, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleLessThan(String value) {
            addCriterion("accept_people <", value, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleLessThanOrEqualTo(String value) {
            addCriterion("accept_people <=", value, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleLike(String value) {
            addCriterion("accept_people like", value, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleNotLike(String value) {
            addCriterion("accept_people not like", value, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleIn(List<String> values) {
            addCriterion("accept_people in", values, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleNotIn(List<String> values) {
            addCriterion("accept_people not in", values, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleBetween(String value1, String value2) {
            addCriterion("accept_people between", value1, value2, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptPeopleNotBetween(String value1, String value2) {
            addCriterion("accept_people not between", value1, value2, "acceptPeople");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkIsNull() {
            addCriterion("accept_remark is null");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkIsNotNull() {
            addCriterion("accept_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkEqualTo(String value) {
            addCriterion("accept_remark =", value, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkNotEqualTo(String value) {
            addCriterion("accept_remark <>", value, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkGreaterThan(String value) {
            addCriterion("accept_remark >", value, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("accept_remark >=", value, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkLessThan(String value) {
            addCriterion("accept_remark <", value, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkLessThanOrEqualTo(String value) {
            addCriterion("accept_remark <=", value, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkLike(String value) {
            addCriterion("accept_remark like", value, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkNotLike(String value) {
            addCriterion("accept_remark not like", value, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkIn(List<String> values) {
            addCriterion("accept_remark in", values, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkNotIn(List<String> values) {
            addCriterion("accept_remark not in", values, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkBetween(String value1, String value2) {
            addCriterion("accept_remark between", value1, value2, "acceptRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptRemarkNotBetween(String value1, String value2) {
            addCriterion("accept_remark not between", value1, value2, "acceptRemark");
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

        public Criteria andAcceptContentIsNull() {
            addCriterion("accept_content is null");
            return (Criteria) this;
        }

        public Criteria andAcceptContentIsNotNull() {
            addCriterion("accept_content is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptContentEqualTo(String value) {
            addCriterion("accept_content =", value, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentNotEqualTo(String value) {
            addCriterion("accept_content <>", value, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentGreaterThan(String value) {
            addCriterion("accept_content >", value, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentGreaterThanOrEqualTo(String value) {
            addCriterion("accept_content >=", value, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentLessThan(String value) {
            addCriterion("accept_content <", value, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentLessThanOrEqualTo(String value) {
            addCriterion("accept_content <=", value, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentLike(String value) {
            addCriterion("accept_content like", value, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentNotLike(String value) {
            addCriterion("accept_content not like", value, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentIn(List<String> values) {
            addCriterion("accept_content in", values, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentNotIn(List<String> values) {
            addCriterion("accept_content not in", values, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentBetween(String value1, String value2) {
            addCriterion("accept_content between", value1, value2, "acceptContent");
            return (Criteria) this;
        }

        public Criteria andAcceptContentNotBetween(String value1, String value2) {
            addCriterion("accept_content not between", value1, value2, "acceptContent");
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