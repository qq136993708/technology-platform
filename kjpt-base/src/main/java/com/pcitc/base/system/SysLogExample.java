package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysLogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(String value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(String value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(String value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(String value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(String value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLike(String value) {
            addCriterion("log_id like", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotLike(String value) {
            addCriterion("log_id not like", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<String> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<String> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(String value1, String value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(String value1, String value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogActionNameIsNull() {
            addCriterion("log_action_name is null");
            return (Criteria) this;
        }

        public Criteria andLogActionNameIsNotNull() {
            addCriterion("log_action_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogActionNameEqualTo(String value) {
            addCriterion("log_action_name =", value, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameNotEqualTo(String value) {
            addCriterion("log_action_name <>", value, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameGreaterThan(String value) {
            addCriterion("log_action_name >", value, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_action_name >=", value, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameLessThan(String value) {
            addCriterion("log_action_name <", value, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameLessThanOrEqualTo(String value) {
            addCriterion("log_action_name <=", value, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameLike(String value) {
            addCriterion("log_action_name like", value, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameNotLike(String value) {
            addCriterion("log_action_name not like", value, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameIn(List<String> values) {
            addCriterion("log_action_name in", values, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameNotIn(List<String> values) {
            addCriterion("log_action_name not in", values, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameBetween(String value1, String value2) {
            addCriterion("log_action_name between", value1, value2, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionNameNotBetween(String value1, String value2) {
            addCriterion("log_action_name not between", value1, value2, "logActionName");
            return (Criteria) this;
        }

        public Criteria andLogActionIsNull() {
            addCriterion("log_action is null");
            return (Criteria) this;
        }

        public Criteria andLogActionIsNotNull() {
            addCriterion("log_action is not null");
            return (Criteria) this;
        }

        public Criteria andLogActionEqualTo(String value) {
            addCriterion("log_action =", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionNotEqualTo(String value) {
            addCriterion("log_action <>", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionGreaterThan(String value) {
            addCriterion("log_action >", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionGreaterThanOrEqualTo(String value) {
            addCriterion("log_action >=", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionLessThan(String value) {
            addCriterion("log_action <", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionLessThanOrEqualTo(String value) {
            addCriterion("log_action <=", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionLike(String value) {
            addCriterion("log_action like", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionNotLike(String value) {
            addCriterion("log_action not like", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionIn(List<String> values) {
            addCriterion("log_action in", values, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionNotIn(List<String> values) {
            addCriterion("log_action not in", values, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionBetween(String value1, String value2) {
            addCriterion("log_action between", value1, value2, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionNotBetween(String value1, String value2) {
            addCriterion("log_action not between", value1, value2, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("log_type like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<String> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<String> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdIsNull() {
            addCriterion("log_person_id is null");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdIsNotNull() {
            addCriterion("log_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdEqualTo(String value) {
            addCriterion("log_person_id =", value, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdNotEqualTo(String value) {
            addCriterion("log_person_id <>", value, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdGreaterThan(String value) {
            addCriterion("log_person_id >", value, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("log_person_id >=", value, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdLessThan(String value) {
            addCriterion("log_person_id <", value, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdLessThanOrEqualTo(String value) {
            addCriterion("log_person_id <=", value, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdLike(String value) {
            addCriterion("log_person_id like", value, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdNotLike(String value) {
            addCriterion("log_person_id not like", value, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdIn(List<String> values) {
            addCriterion("log_person_id in", values, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdNotIn(List<String> values) {
            addCriterion("log_person_id not in", values, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdBetween(String value1, String value2) {
            addCriterion("log_person_id between", value1, value2, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIdNotBetween(String value1, String value2) {
            addCriterion("log_person_id not between", value1, value2, "logPersonId");
            return (Criteria) this;
        }

        public Criteria andLogPersonIsNull() {
            addCriterion("log_person is null");
            return (Criteria) this;
        }

        public Criteria andLogPersonIsNotNull() {
            addCriterion("log_person is not null");
            return (Criteria) this;
        }

        public Criteria andLogPersonEqualTo(String value) {
            addCriterion("log_person =", value, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonNotEqualTo(String value) {
            addCriterion("log_person <>", value, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonGreaterThan(String value) {
            addCriterion("log_person >", value, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonGreaterThanOrEqualTo(String value) {
            addCriterion("log_person >=", value, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonLessThan(String value) {
            addCriterion("log_person <", value, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonLessThanOrEqualTo(String value) {
            addCriterion("log_person <=", value, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonLike(String value) {
            addCriterion("log_person like", value, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonNotLike(String value) {
            addCriterion("log_person not like", value, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonIn(List<String> values) {
            addCriterion("log_person in", values, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonNotIn(List<String> values) {
            addCriterion("log_person not in", values, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonBetween(String value1, String value2) {
            addCriterion("log_person between", value1, value2, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogPersonNotBetween(String value1, String value2) {
            addCriterion("log_person not between", value1, value2, "logPerson");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeLike(String value) {
            addCriterion("log_time like", value, "logTime");
            return (Criteria) this;
        }
        
        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogStatusIsNull() {
            addCriterion("log_status is null");
            return (Criteria) this;
        }

        public Criteria andLogStatusIsNotNull() {
            addCriterion("log_status is not null");
            return (Criteria) this;
        }

        public Criteria andLogStatusEqualTo(String value) {
            addCriterion("log_status =", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotEqualTo(String value) {
            addCriterion("log_status <>", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusGreaterThan(String value) {
            addCriterion("log_status >", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusGreaterThanOrEqualTo(String value) {
            addCriterion("log_status >=", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLessThan(String value) {
            addCriterion("log_status <", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLessThanOrEqualTo(String value) {
            addCriterion("log_status <=", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLike(String value) {
            addCriterion("log_status like", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotLike(String value) {
            addCriterion("log_status not like", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusIn(List<String> values) {
            addCriterion("log_status in", values, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotIn(List<String> values) {
            addCriterion("log_status not in", values, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusBetween(String value1, String value2) {
            addCriterion("log_status between", value1, value2, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotBetween(String value1, String value2) {
            addCriterion("log_status not between", value1, value2, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogIpIsNull() {
            addCriterion("log_ip is null");
            return (Criteria) this;
        }

        public Criteria andLogIpIsNotNull() {
            addCriterion("log_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLogIpEqualTo(String value) {
            addCriterion("log_ip =", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotEqualTo(String value) {
            addCriterion("log_ip <>", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpGreaterThan(String value) {
            addCriterion("log_ip >", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpGreaterThanOrEqualTo(String value) {
            addCriterion("log_ip >=", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpLessThan(String value) {
            addCriterion("log_ip <", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpLessThanOrEqualTo(String value) {
            addCriterion("log_ip <=", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpLike(String value) {
            addCriterion("log_ip like", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotLike(String value) {
            addCriterion("log_ip not like", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpIn(List<String> values) {
            addCriterion("log_ip in", values, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotIn(List<String> values) {
            addCriterion("log_ip not in", values, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpBetween(String value1, String value2) {
            addCriterion("log_ip between", value1, value2, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotBetween(String value1, String value2) {
            addCriterion("log_ip not between", value1, value2, "logIp");
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

        public Criteria andLogRemarksIsNull() {
            addCriterion("log_remarks is null");
            return (Criteria) this;
        }

        public Criteria andLogRemarksIsNotNull() {
            addCriterion("log_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andLogRemarksEqualTo(String value) {
            addCriterion("log_remarks =", value, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksNotEqualTo(String value) {
            addCriterion("log_remarks <>", value, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksGreaterThan(String value) {
            addCriterion("log_remarks >", value, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("log_remarks >=", value, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksLessThan(String value) {
            addCriterion("log_remarks <", value, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksLessThanOrEqualTo(String value) {
            addCriterion("log_remarks <=", value, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksLike(String value) {
            addCriterion("log_remarks like", value, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksNotLike(String value) {
            addCriterion("log_remarks not like", value, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksIn(List<String> values) {
            addCriterion("log_remarks in", values, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksNotIn(List<String> values) {
            addCriterion("log_remarks not in", values, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksBetween(String value1, String value2) {
            addCriterion("log_remarks between", value1, value2, "logRemarks");
            return (Criteria) this;
        }

        public Criteria andLogRemarksNotBetween(String value1, String value2) {
            addCriterion("log_remarks not between", value1, value2, "logRemarks");
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