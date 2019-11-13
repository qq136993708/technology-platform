package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysCronRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SysCronRecordExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDataIdIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(Integer value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(Integer value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(Integer value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(Integer value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(Integer value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<Integer> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<Integer> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(Integer value1, Integer value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(Integer value1, Integer value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
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

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobClassIsNull() {
            addCriterion("job_class is null");
            return (Criteria) this;
        }

        public Criteria andJobClassIsNotNull() {
            addCriterion("job_class is not null");
            return (Criteria) this;
        }

        public Criteria andJobClassEqualTo(String value) {
            addCriterion("job_class =", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassNotEqualTo(String value) {
            addCriterion("job_class <>", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassGreaterThan(String value) {
            addCriterion("job_class >", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassGreaterThanOrEqualTo(String value) {
            addCriterion("job_class >=", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassLessThan(String value) {
            addCriterion("job_class <", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassLessThanOrEqualTo(String value) {
            addCriterion("job_class <=", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassLike(String value) {
            addCriterion("job_class like", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassNotLike(String value) {
            addCriterion("job_class not like", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassIn(List<String> values) {
            addCriterion("job_class in", values, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassNotIn(List<String> values) {
            addCriterion("job_class not in", values, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassBetween(String value1, String value2) {
            addCriterion("job_class between", value1, value2, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassNotBetween(String value1, String value2) {
            addCriterion("job_class not between", value1, value2, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNull() {
            addCriterion("job_type is null");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNotNull() {
            addCriterion("job_type is not null");
            return (Criteria) this;
        }

        public Criteria andJobTypeEqualTo(String value) {
            addCriterion("job_type =", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotEqualTo(String value) {
            addCriterion("job_type <>", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThan(String value) {
            addCriterion("job_type >", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThanOrEqualTo(String value) {
            addCriterion("job_type >=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThan(String value) {
            addCriterion("job_type <", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThanOrEqualTo(String value) {
            addCriterion("job_type <=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLike(String value) {
            addCriterion("job_type like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotLike(String value) {
            addCriterion("job_type not like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeIn(List<String> values) {
            addCriterion("job_type in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotIn(List<String> values) {
            addCriterion("job_type not in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeBetween(String value1, String value2) {
            addCriterion("job_type between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotBetween(String value1, String value2) {
            addCriterion("job_type not between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNull() {
            addCriterion("job_group is null");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNotNull() {
            addCriterion("job_group is not null");
            return (Criteria) this;
        }

        public Criteria andJobGroupEqualTo(String value) {
            addCriterion("job_group =", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotEqualTo(String value) {
            addCriterion("job_group <>", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThan(String value) {
            addCriterion("job_group >", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThanOrEqualTo(String value) {
            addCriterion("job_group >=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThan(String value) {
            addCriterion("job_group <", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThanOrEqualTo(String value) {
            addCriterion("job_group <=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLike(String value) {
            addCriterion("job_group like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotLike(String value) {
            addCriterion("job_group not like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupIn(List<String> values) {
            addCriterion("job_group in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotIn(List<String> values) {
            addCriterion("job_group not in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupBetween(String value1, String value2) {
            addCriterion("job_group between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotBetween(String value1, String value2) {
            addCriterion("job_group not between", value1, value2, "jobGroup");
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

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeIsNull() {
            addCriterion("excep_record_time is null");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeIsNotNull() {
            addCriterion("excep_record_time is not null");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeEqualTo(Date value) {
            addCriterionForJDBCDate("excep_record_time =", value, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("excep_record_time <>", value, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("excep_record_time >", value, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("excep_record_time >=", value, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeLessThan(Date value) {
            addCriterionForJDBCDate("excep_record_time <", value, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("excep_record_time <=", value, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeIn(List<Date> values) {
            addCriterionForJDBCDate("excep_record_time in", values, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("excep_record_time not in", values, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("excep_record_time between", value1, value2, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("excep_record_time not between", value1, value2, "excepRecordTime");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonIsNull() {
            addCriterion("excep_record_reason is null");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonIsNotNull() {
            addCriterion("excep_record_reason is not null");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonEqualTo(String value) {
            addCriterion("excep_record_reason =", value, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonNotEqualTo(String value) {
            addCriterion("excep_record_reason <>", value, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonGreaterThan(String value) {
            addCriterion("excep_record_reason >", value, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonGreaterThanOrEqualTo(String value) {
            addCriterion("excep_record_reason >=", value, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonLessThan(String value) {
            addCriterion("excep_record_reason <", value, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonLessThanOrEqualTo(String value) {
            addCriterion("excep_record_reason <=", value, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonLike(String value) {
            addCriterion("excep_record_reason like", value, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonNotLike(String value) {
            addCriterion("excep_record_reason not like", value, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonIn(List<String> values) {
            addCriterion("excep_record_reason in", values, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonNotIn(List<String> values) {
            addCriterion("excep_record_reason not in", values, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonBetween(String value1, String value2) {
            addCriterion("excep_record_reason between", value1, value2, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andExcepRecordReasonNotBetween(String value1, String value2) {
            addCriterion("excep_record_reason not between", value1, value2, "excepRecordReason");
            return (Criteria) this;
        }

        public Criteria andMark1IsNull() {
            addCriterion("mark1 is null");
            return (Criteria) this;
        }

        public Criteria andMark1IsNotNull() {
            addCriterion("mark1 is not null");
            return (Criteria) this;
        }

        public Criteria andMark1EqualTo(String value) {
            addCriterion("mark1 =", value, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1NotEqualTo(String value) {
            addCriterion("mark1 <>", value, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1GreaterThan(String value) {
            addCriterion("mark1 >", value, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1GreaterThanOrEqualTo(String value) {
            addCriterion("mark1 >=", value, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1LessThan(String value) {
            addCriterion("mark1 <", value, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1LessThanOrEqualTo(String value) {
            addCriterion("mark1 <=", value, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1Like(String value) {
            addCriterion("mark1 like", value, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1NotLike(String value) {
            addCriterion("mark1 not like", value, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1In(List<String> values) {
            addCriterion("mark1 in", values, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1NotIn(List<String> values) {
            addCriterion("mark1 not in", values, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1Between(String value1, String value2) {
            addCriterion("mark1 between", value1, value2, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark1NotBetween(String value1, String value2) {
            addCriterion("mark1 not between", value1, value2, "mark1");
            return (Criteria) this;
        }

        public Criteria andMark2IsNull() {
            addCriterion("mark2 is null");
            return (Criteria) this;
        }

        public Criteria andMark2IsNotNull() {
            addCriterion("mark2 is not null");
            return (Criteria) this;
        }

        public Criteria andMark2EqualTo(String value) {
            addCriterion("mark2 =", value, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2NotEqualTo(String value) {
            addCriterion("mark2 <>", value, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2GreaterThan(String value) {
            addCriterion("mark2 >", value, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2GreaterThanOrEqualTo(String value) {
            addCriterion("mark2 >=", value, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2LessThan(String value) {
            addCriterion("mark2 <", value, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2LessThanOrEqualTo(String value) {
            addCriterion("mark2 <=", value, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2Like(String value) {
            addCriterion("mark2 like", value, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2NotLike(String value) {
            addCriterion("mark2 not like", value, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2In(List<String> values) {
            addCriterion("mark2 in", values, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2NotIn(List<String> values) {
            addCriterion("mark2 not in", values, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2Between(String value1, String value2) {
            addCriterion("mark2 between", value1, value2, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark2NotBetween(String value1, String value2) {
            addCriterion("mark2 not between", value1, value2, "mark2");
            return (Criteria) this;
        }

        public Criteria andMark3IsNull() {
            addCriterion("mark3 is null");
            return (Criteria) this;
        }

        public Criteria andMark3IsNotNull() {
            addCriterion("mark3 is not null");
            return (Criteria) this;
        }

        public Criteria andMark3EqualTo(String value) {
            addCriterion("mark3 =", value, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3NotEqualTo(String value) {
            addCriterion("mark3 <>", value, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3GreaterThan(String value) {
            addCriterion("mark3 >", value, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3GreaterThanOrEqualTo(String value) {
            addCriterion("mark3 >=", value, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3LessThan(String value) {
            addCriterion("mark3 <", value, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3LessThanOrEqualTo(String value) {
            addCriterion("mark3 <=", value, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3Like(String value) {
            addCriterion("mark3 like", value, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3NotLike(String value) {
            addCriterion("mark3 not like", value, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3In(List<String> values) {
            addCriterion("mark3 in", values, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3NotIn(List<String> values) {
            addCriterion("mark3 not in", values, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3Between(String value1, String value2) {
            addCriterion("mark3 between", value1, value2, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark3NotBetween(String value1, String value2) {
            addCriterion("mark3 not between", value1, value2, "mark3");
            return (Criteria) this;
        }

        public Criteria andMark4IsNull() {
            addCriterion("mark4 is null");
            return (Criteria) this;
        }

        public Criteria andMark4IsNotNull() {
            addCriterion("mark4 is not null");
            return (Criteria) this;
        }

        public Criteria andMark4EqualTo(String value) {
            addCriterion("mark4 =", value, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4NotEqualTo(String value) {
            addCriterion("mark4 <>", value, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4GreaterThan(String value) {
            addCriterion("mark4 >", value, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4GreaterThanOrEqualTo(String value) {
            addCriterion("mark4 >=", value, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4LessThan(String value) {
            addCriterion("mark4 <", value, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4LessThanOrEqualTo(String value) {
            addCriterion("mark4 <=", value, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4Like(String value) {
            addCriterion("mark4 like", value, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4NotLike(String value) {
            addCriterion("mark4 not like", value, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4In(List<String> values) {
            addCriterion("mark4 in", values, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4NotIn(List<String> values) {
            addCriterion("mark4 not in", values, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4Between(String value1, String value2) {
            addCriterion("mark4 between", value1, value2, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark4NotBetween(String value1, String value2) {
            addCriterion("mark4 not between", value1, value2, "mark4");
            return (Criteria) this;
        }

        public Criteria andMark5IsNull() {
            addCriterion("mark5 is null");
            return (Criteria) this;
        }

        public Criteria andMark5IsNotNull() {
            addCriterion("mark5 is not null");
            return (Criteria) this;
        }

        public Criteria andMark5EqualTo(String value) {
            addCriterion("mark5 =", value, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5NotEqualTo(String value) {
            addCriterion("mark5 <>", value, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5GreaterThan(String value) {
            addCriterion("mark5 >", value, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5GreaterThanOrEqualTo(String value) {
            addCriterion("mark5 >=", value, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5LessThan(String value) {
            addCriterion("mark5 <", value, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5LessThanOrEqualTo(String value) {
            addCriterion("mark5 <=", value, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5Like(String value) {
            addCriterion("mark5 like", value, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5NotLike(String value) {
            addCriterion("mark5 not like", value, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5In(List<String> values) {
            addCriterion("mark5 in", values, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5NotIn(List<String> values) {
            addCriterion("mark5 not in", values, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5Between(String value1, String value2) {
            addCriterion("mark5 between", value1, value2, "mark5");
            return (Criteria) this;
        }

        public Criteria andMark5NotBetween(String value1, String value2) {
            addCriterion("mark5 not between", value1, value2, "mark5");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
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
            addCriterionForJDBCDate("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date not between", value1, value2, "updateDate");
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