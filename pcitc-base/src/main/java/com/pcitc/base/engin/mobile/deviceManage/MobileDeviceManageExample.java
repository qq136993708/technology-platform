package com.pcitc.base.engin.mobile.deviceManage;

import java.util.ArrayList;
import java.util.List;

public class MobileDeviceManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MobileDeviceManageExample() {
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

        public Criteria andDeviceUseridIsNull() {
            addCriterion("device_userId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridIsNotNull() {
            addCriterion("device_userId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridEqualTo(String value) {
            addCriterion("device_userId =", value, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridNotEqualTo(String value) {
            addCriterion("device_userId <>", value, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridGreaterThan(String value) {
            addCriterion("device_userId >", value, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridGreaterThanOrEqualTo(String value) {
            addCriterion("device_userId >=", value, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridLessThan(String value) {
            addCriterion("device_userId <", value, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridLessThanOrEqualTo(String value) {
            addCriterion("device_userId <=", value, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridLike(String value) {
            addCriterion("device_userId like", value, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridNotLike(String value) {
            addCriterion("device_userId not like", value, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridIn(List<String> values) {
            addCriterion("device_userId in", values, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridNotIn(List<String> values) {
            addCriterion("device_userId not in", values, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridBetween(String value1, String value2) {
            addCriterion("device_userId between", value1, value2, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUseridNotBetween(String value1, String value2) {
            addCriterion("device_userId not between", value1, value2, "deviceUserid");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIsNull() {
            addCriterion("device_user is null");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIsNotNull() {
            addCriterion("device_user is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceUserEqualTo(String value) {
            addCriterion("device_user =", value, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNotEqualTo(String value) {
            addCriterion("device_user <>", value, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserGreaterThan(String value) {
            addCriterion("device_user >", value, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserGreaterThanOrEqualTo(String value) {
            addCriterion("device_user >=", value, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserLessThan(String value) {
            addCriterion("device_user <", value, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserLessThanOrEqualTo(String value) {
            addCriterion("device_user <=", value, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserLike(String value) {
            addCriterion("device_user like", value, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNotLike(String value) {
            addCriterion("device_user not like", value, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIn(List<String> values) {
            addCriterion("device_user in", values, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNotIn(List<String> values) {
            addCriterion("device_user not in", values, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserBetween(String value1, String value2) {
            addCriterion("device_user between", value1, value2, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNotBetween(String value1, String value2) {
            addCriterion("device_user not between", value1, value2, "deviceUser");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameIsNull() {
            addCriterion("device_user_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameIsNotNull() {
            addCriterion("device_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameEqualTo(String value) {
            addCriterion("device_user_name =", value, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameNotEqualTo(String value) {
            addCriterion("device_user_name <>", value, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameGreaterThan(String value) {
            addCriterion("device_user_name >", value, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_user_name >=", value, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameLessThan(String value) {
            addCriterion("device_user_name <", value, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameLessThanOrEqualTo(String value) {
            addCriterion("device_user_name <=", value, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameLike(String value) {
            addCriterion("device_user_name like", value, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameNotLike(String value) {
            addCriterion("device_user_name not like", value, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameIn(List<String> values) {
            addCriterion("device_user_name in", values, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameNotIn(List<String> values) {
            addCriterion("device_user_name not in", values, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameBetween(String value1, String value2) {
            addCriterion("device_user_name between", value1, value2, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceUserNameNotBetween(String value1, String value2) {
            addCriterion("device_user_name not between", value1, value2, "deviceUserName");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentIsNull() {
            addCriterion("device_department is null");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentIsNotNull() {
            addCriterion("device_department is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentEqualTo(String value) {
            addCriterion("device_department =", value, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentNotEqualTo(String value) {
            addCriterion("device_department <>", value, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentGreaterThan(String value) {
            addCriterion("device_department >", value, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("device_department >=", value, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentLessThan(String value) {
            addCriterion("device_department <", value, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentLessThanOrEqualTo(String value) {
            addCriterion("device_department <=", value, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentLike(String value) {
            addCriterion("device_department like", value, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentNotLike(String value) {
            addCriterion("device_department not like", value, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentIn(List<String> values) {
            addCriterion("device_department in", values, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentNotIn(List<String> values) {
            addCriterion("device_department not in", values, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentBetween(String value1, String value2) {
            addCriterion("device_department between", value1, value2, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceDepartmentNotBetween(String value1, String value2) {
            addCriterion("device_department not between", value1, value2, "deviceDepartment");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIsNull() {
            addCriterion("device_code is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIsNotNull() {
            addCriterion("device_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeEqualTo(String value) {
            addCriterion("device_code =", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotEqualTo(String value) {
            addCriterion("device_code <>", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThan(String value) {
            addCriterion("device_code >", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("device_code >=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThan(String value) {
            addCriterion("device_code <", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThanOrEqualTo(String value) {
            addCriterion("device_code <=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLike(String value) {
            addCriterion("device_code like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotLike(String value) {
            addCriterion("device_code not like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIn(List<String> values) {
            addCriterion("device_code in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotIn(List<String> values) {
            addCriterion("device_code not in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeBetween(String value1, String value2) {
            addCriterion("device_code between", value1, value2, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotBetween(String value1, String value2) {
            addCriterion("device_code not between", value1, value2, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeIsNull() {
            addCriterion("device_only_code is null");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeIsNotNull() {
            addCriterion("device_only_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeEqualTo(String value) {
            addCriterion("device_only_code =", value, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeNotEqualTo(String value) {
            addCriterion("device_only_code <>", value, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeGreaterThan(String value) {
            addCriterion("device_only_code >", value, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("device_only_code >=", value, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeLessThan(String value) {
            addCriterion("device_only_code <", value, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeLessThanOrEqualTo(String value) {
            addCriterion("device_only_code <=", value, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeLike(String value) {
            addCriterion("device_only_code like", value, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeNotLike(String value) {
            addCriterion("device_only_code not like", value, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeIn(List<String> values) {
            addCriterion("device_only_code in", values, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeNotIn(List<String> values) {
            addCriterion("device_only_code not in", values, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeBetween(String value1, String value2) {
            addCriterion("device_only_code between", value1, value2, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlyCodeNotBetween(String value1, String value2) {
            addCriterion("device_only_code not between", value1, value2, "deviceOnlyCode");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("device_type like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type not like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIsNull() {
            addCriterion("device_model is null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIsNotNull() {
            addCriterion("device_model is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelEqualTo(String value) {
            addCriterion("device_model =", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotEqualTo(String value) {
            addCriterion("device_model <>", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelGreaterThan(String value) {
            addCriterion("device_model >", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelGreaterThanOrEqualTo(String value) {
            addCriterion("device_model >=", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelLessThan(String value) {
            addCriterion("device_model <", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelLessThanOrEqualTo(String value) {
            addCriterion("device_model <=", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelLike(String value) {
            addCriterion("device_model like", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotLike(String value) {
            addCriterion("device_model not like", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIn(List<String> values) {
            addCriterion("device_model in", values, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotIn(List<String> values) {
            addCriterion("device_model not in", values, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelBetween(String value1, String value2) {
            addCriterion("device_model between", value1, value2, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotBetween(String value1, String value2) {
            addCriterion("device_model not between", value1, value2, "deviceModel");
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