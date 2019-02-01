package com.pcitc.base.expert;

import java.util.ArrayList;
import java.util.List;

public class ZjkExtractConfigExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ZjkExtractConfigExample() {
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

        public Criteria andOrColumn(String value, String[] columns, String opt) {
            String sql = "";
            String cal = "";
            if ("like".equals(opt)) {
                cal = "%";
            }
            int l = columns.length;
            for (int i = 0; i < l; i++) {
                if (i == 0) {
                    sql = sql + columns[i] + " " + opt + " '" + cal + value + cal + "'";
                } else {
                    sql = sql + " or " + columns[i] + " " + opt + " '" + cal + value + cal + "'";
                }
            }
            addCriterion("(" + sql + ")");
            return (Criteria) this;
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

        public Criteria andSysFlagIsNull() {
            addCriterion("sys_flag is null");
            return (Criteria) this;
        }

        public Criteria andSysFlagIsNotNull() {
            addCriterion("sys_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSysFlagEqualTo(String value) {
            addCriterion("sys_flag =", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotEqualTo(String value) {
            addCriterion("sys_flag <>", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThan(String value) {
            addCriterion("sys_flag >", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThanOrEqualTo(String value) {
            addCriterion("sys_flag >=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThan(String value) {
            addCriterion("sys_flag <", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThanOrEqualTo(String value) {
            addCriterion("sys_flag <=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLike(String value) {
            addCriterion("sys_flag like", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotLike(String value) {
            addCriterion("sys_flag not like", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagIn(List<String> values) {
            addCriterion("sys_flag in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotIn(List<String> values) {
            addCriterion("sys_flag not in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagBetween(String value1, String value2) {
            addCriterion("sys_flag between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotBetween(String value1, String value2) {
            addCriterion("sys_flag not between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andDataOrderIsNull() {
            addCriterion("data_order is null");
            return (Criteria) this;
        }

        public Criteria andDataOrderIsNotNull() {
            addCriterion("data_order is not null");
            return (Criteria) this;
        }

        public Criteria andDataOrderEqualTo(String value) {
            addCriterion("data_order =", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotEqualTo(String value) {
            addCriterion("data_order <>", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderGreaterThan(String value) {
            addCriterion("data_order >", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderGreaterThanOrEqualTo(String value) {
            addCriterion("data_order >=", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderLessThan(String value) {
            addCriterion("data_order <", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderLessThanOrEqualTo(String value) {
            addCriterion("data_order <=", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderLike(String value) {
            addCriterion("data_order like", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotLike(String value) {
            addCriterion("data_order not like", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderIn(List<String> values) {
            addCriterion("data_order in", values, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotIn(List<String> values) {
            addCriterion("data_order not in", values, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderBetween(String value1, String value2) {
            addCriterion("data_order between", value1, value2, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotBetween(String value1, String value2) {
            addCriterion("data_order not between", value1, value2, "dataOrder");
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

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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

        public Criteria andCreateUserDispIsNull() {
            addCriterion("create_user_disp is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispIsNotNull() {
            addCriterion("create_user_disp is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispEqualTo(String value) {
            addCriterion("create_user_disp =", value, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispNotEqualTo(String value) {
            addCriterion("create_user_disp <>", value, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispGreaterThan(String value) {
            addCriterion("create_user_disp >", value, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_disp >=", value, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispLessThan(String value) {
            addCriterion("create_user_disp <", value, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispLessThanOrEqualTo(String value) {
            addCriterion("create_user_disp <=", value, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispLike(String value) {
            addCriterion("create_user_disp like", value, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispNotLike(String value) {
            addCriterion("create_user_disp not like", value, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispIn(List<String> values) {
            addCriterion("create_user_disp in", values, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispNotIn(List<String> values) {
            addCriterion("create_user_disp not in", values, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispBetween(String value1, String value2) {
            addCriterion("create_user_disp between", value1, value2, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andCreateUserDispNotBetween(String value1, String value2) {
            addCriterion("create_user_disp not between", value1, value2, "createUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(String value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(String value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(String value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(String value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(String value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(String value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLike(String value) {
            addCriterion("modify_date like", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotLike(String value) {
            addCriterion("modify_date not like", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<String> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<String> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(String value1, String value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(String value1, String value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNull() {
            addCriterion("modify_user is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNotNull() {
            addCriterion("modify_user is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserEqualTo(String value) {
            addCriterion("modify_user =", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotEqualTo(String value) {
            addCriterion("modify_user <>", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThan(String value) {
            addCriterion("modify_user >", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThanOrEqualTo(String value) {
            addCriterion("modify_user >=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThan(String value) {
            addCriterion("modify_user <", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThanOrEqualTo(String value) {
            addCriterion("modify_user <=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLike(String value) {
            addCriterion("modify_user like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLike(String value) {
            addCriterion("modify_user not like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserIn(List<String> values) {
            addCriterion("modify_user in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotIn(List<String> values) {
            addCriterion("modify_user not in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserBetween(String value1, String value2) {
            addCriterion("modify_user between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotBetween(String value1, String value2) {
            addCriterion("modify_user not between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispIsNull() {
            addCriterion("modify_user_disp is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispIsNotNull() {
            addCriterion("modify_user_disp is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispEqualTo(String value) {
            addCriterion("modify_user_disp =", value, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispNotEqualTo(String value) {
            addCriterion("modify_user_disp <>", value, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispGreaterThan(String value) {
            addCriterion("modify_user_disp >", value, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispGreaterThanOrEqualTo(String value) {
            addCriterion("modify_user_disp >=", value, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispLessThan(String value) {
            addCriterion("modify_user_disp <", value, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispLessThanOrEqualTo(String value) {
            addCriterion("modify_user_disp <=", value, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispLike(String value) {
            addCriterion("modify_user_disp like", value, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispNotLike(String value) {
            addCriterion("modify_user_disp not like", value, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispIn(List<String> values) {
            addCriterion("modify_user_disp in", values, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispNotIn(List<String> values) {
            addCriterion("modify_user_disp not in", values, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispBetween(String value1, String value2) {
            addCriterion("modify_user_disp between", value1, value2, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andModifyUserDispNotBetween(String value1, String value2) {
            addCriterion("modify_user_disp not between", value1, value2, "modifyUserDisp");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdIsNull() {
            addCriterion("project_stage_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdIsNotNull() {
            addCriterion("project_stage_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdEqualTo(String value) {
            addCriterion("project_stage_id =", value, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdNotEqualTo(String value) {
            addCriterion("project_stage_id <>", value, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdGreaterThan(String value) {
            addCriterion("project_stage_id >", value, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_stage_id >=", value, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdLessThan(String value) {
            addCriterion("project_stage_id <", value, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdLessThanOrEqualTo(String value) {
            addCriterion("project_stage_id <=", value, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdLike(String value) {
            addCriterion("project_stage_id like", value, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdNotLike(String value) {
            addCriterion("project_stage_id not like", value, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdIn(List<String> values) {
            addCriterion("project_stage_id in", values, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdNotIn(List<String> values) {
            addCriterion("project_stage_id not in", values, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdBetween(String value1, String value2) {
            addCriterion("project_stage_id between", value1, value2, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageIdNotBetween(String value1, String value2) {
            addCriterion("project_stage_id not between", value1, value2, "projectStageId");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameIsNull() {
            addCriterion("project_stage_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameIsNotNull() {
            addCriterion("project_stage_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameEqualTo(String value) {
            addCriterion("project_stage_name =", value, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameNotEqualTo(String value) {
            addCriterion("project_stage_name <>", value, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameGreaterThan(String value) {
            addCriterion("project_stage_name >", value, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_stage_name >=", value, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameLessThan(String value) {
            addCriterion("project_stage_name <", value, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameLessThanOrEqualTo(String value) {
            addCriterion("project_stage_name <=", value, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameLike(String value) {
            addCriterion("project_stage_name like", value, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameNotLike(String value) {
            addCriterion("project_stage_name not like", value, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameIn(List<String> values) {
            addCriterion("project_stage_name in", values, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameNotIn(List<String> values) {
            addCriterion("project_stage_name not in", values, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameBetween(String value1, String value2) {
            addCriterion("project_stage_name between", value1, value2, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andProjectStageNameNotBetween(String value1, String value2) {
            addCriterion("project_stage_name not between", value1, value2, "projectStageName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalIsNull() {
            addCriterion("expert_professional is null");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalIsNotNull() {
            addCriterion("expert_professional is not null");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalEqualTo(String value) {
            addCriterion("expert_professional =", value, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalNotEqualTo(String value) {
            addCriterion("expert_professional <>", value, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalGreaterThan(String value) {
            addCriterion("expert_professional >", value, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalGreaterThanOrEqualTo(String value) {
            addCriterion("expert_professional >=", value, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalLessThan(String value) {
            addCriterion("expert_professional <", value, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalLessThanOrEqualTo(String value) {
            addCriterion("expert_professional <=", value, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalLike(String value) {
            addCriterion("expert_professional like", value, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalNotLike(String value) {
            addCriterion("expert_professional not like", value, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalIn(List<String> values) {
            addCriterion("expert_professional in", values, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalNotIn(List<String> values) {
            addCriterion("expert_professional not in", values, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalBetween(String value1, String value2) {
            addCriterion("expert_professional between", value1, value2, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalNotBetween(String value1, String value2) {
            addCriterion("expert_professional not between", value1, value2, "expertProfessional");
            return (Criteria) this;
        }

        public Criteria andExpertCountIsNull() {
            addCriterion("expert_count is null");
            return (Criteria) this;
        }

        public Criteria andExpertCountIsNotNull() {
            addCriterion("expert_count is not null");
            return (Criteria) this;
        }

        public Criteria andExpertCountEqualTo(String value) {
            addCriterion("expert_count =", value, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountNotEqualTo(String value) {
            addCriterion("expert_count <>", value, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountGreaterThan(String value) {
            addCriterion("expert_count >", value, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountGreaterThanOrEqualTo(String value) {
            addCriterion("expert_count >=", value, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountLessThan(String value) {
            addCriterion("expert_count <", value, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountLessThanOrEqualTo(String value) {
            addCriterion("expert_count <=", value, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountLike(String value) {
            addCriterion("expert_count like", value, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountNotLike(String value) {
            addCriterion("expert_count not like", value, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountIn(List<String> values) {
            addCriterion("expert_count in", values, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountNotIn(List<String> values) {
            addCriterion("expert_count not in", values, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountBetween(String value1, String value2) {
            addCriterion("expert_count between", value1, value2, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertCountNotBetween(String value1, String value2) {
            addCriterion("expert_count not between", value1, value2, "expertCount");
            return (Criteria) this;
        }

        public Criteria andExpertAreaIsNull() {
            addCriterion("expert_area is null");
            return (Criteria) this;
        }

        public Criteria andExpertAreaIsNotNull() {
            addCriterion("expert_area is not null");
            return (Criteria) this;
        }

        public Criteria andExpertAreaEqualTo(String value) {
            addCriterion("expert_area =", value, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaNotEqualTo(String value) {
            addCriterion("expert_area <>", value, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaGreaterThan(String value) {
            addCriterion("expert_area >", value, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaGreaterThanOrEqualTo(String value) {
            addCriterion("expert_area >=", value, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaLessThan(String value) {
            addCriterion("expert_area <", value, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaLessThanOrEqualTo(String value) {
            addCriterion("expert_area <=", value, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaLike(String value) {
            addCriterion("expert_area like", value, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaNotLike(String value) {
            addCriterion("expert_area not like", value, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaIn(List<String> values) {
            addCriterion("expert_area in", values, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaNotIn(List<String> values) {
            addCriterion("expert_area not in", values, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaBetween(String value1, String value2) {
            addCriterion("expert_area between", value1, value2, "expertArea");
            return (Criteria) this;
        }

        public Criteria andExpertAreaNotBetween(String value1, String value2) {
            addCriterion("expert_area not between", value1, value2, "expertArea");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeIsNull() {
            addCriterion("interval_time is null");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeIsNotNull() {
            addCriterion("interval_time is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeEqualTo(String value) {
            addCriterion("interval_time =", value, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeNotEqualTo(String value) {
            addCriterion("interval_time <>", value, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeGreaterThan(String value) {
            addCriterion("interval_time >", value, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeGreaterThanOrEqualTo(String value) {
            addCriterion("interval_time >=", value, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeLessThan(String value) {
            addCriterion("interval_time <", value, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeLessThanOrEqualTo(String value) {
            addCriterion("interval_time <=", value, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeLike(String value) {
            addCriterion("interval_time like", value, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeNotLike(String value) {
            addCriterion("interval_time not like", value, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeIn(List<String> values) {
            addCriterion("interval_time in", values, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeNotIn(List<String> values) {
            addCriterion("interval_time not in", values, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeBetween(String value1, String value2) {
            addCriterion("interval_time between", value1, value2, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andIntervalTimeNotBetween(String value1, String value2) {
            addCriterion("interval_time not between", value1, value2, "intervalTime");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInIsNull() {
            addCriterion("extract_weight_in is null");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInIsNotNull() {
            addCriterion("extract_weight_in is not null");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInEqualTo(String value) {
            addCriterion("extract_weight_in =", value, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInNotEqualTo(String value) {
            addCriterion("extract_weight_in <>", value, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInGreaterThan(String value) {
            addCriterion("extract_weight_in >", value, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInGreaterThanOrEqualTo(String value) {
            addCriterion("extract_weight_in >=", value, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInLessThan(String value) {
            addCriterion("extract_weight_in <", value, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInLessThanOrEqualTo(String value) {
            addCriterion("extract_weight_in <=", value, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInLike(String value) {
            addCriterion("extract_weight_in like", value, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInNotLike(String value) {
            addCriterion("extract_weight_in not like", value, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInIn(List<String> values) {
            addCriterion("extract_weight_in in", values, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInNotIn(List<String> values) {
            addCriterion("extract_weight_in not in", values, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInBetween(String value1, String value2) {
            addCriterion("extract_weight_in between", value1, value2, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightInNotBetween(String value1, String value2) {
            addCriterion("extract_weight_in not between", value1, value2, "extractWeightIn");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutIsNull() {
            addCriterion("extract_weight_out is null");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutIsNotNull() {
            addCriterion("extract_weight_out is not null");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutEqualTo(String value) {
            addCriterion("extract_weight_out =", value, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutNotEqualTo(String value) {
            addCriterion("extract_weight_out <>", value, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutGreaterThan(String value) {
            addCriterion("extract_weight_out >", value, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutGreaterThanOrEqualTo(String value) {
            addCriterion("extract_weight_out >=", value, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutLessThan(String value) {
            addCriterion("extract_weight_out <", value, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutLessThanOrEqualTo(String value) {
            addCriterion("extract_weight_out <=", value, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutLike(String value) {
            addCriterion("extract_weight_out like", value, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutNotLike(String value) {
            addCriterion("extract_weight_out not like", value, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutIn(List<String> values) {
            addCriterion("extract_weight_out in", values, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutNotIn(List<String> values) {
            addCriterion("extract_weight_out not in", values, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutBetween(String value1, String value2) {
            addCriterion("extract_weight_out between", value1, value2, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andExtractWeightOutNotBetween(String value1, String value2) {
            addCriterion("extract_weight_out not between", value1, value2, "extractWeightOut");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidIsNull() {
            addCriterion("company_avoid is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidIsNotNull() {
            addCriterion("company_avoid is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidEqualTo(String value) {
            addCriterion("company_avoid =", value, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidNotEqualTo(String value) {
            addCriterion("company_avoid <>", value, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidGreaterThan(String value) {
            addCriterion("company_avoid >", value, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidGreaterThanOrEqualTo(String value) {
            addCriterion("company_avoid >=", value, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidLessThan(String value) {
            addCriterion("company_avoid <", value, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidLessThanOrEqualTo(String value) {
            addCriterion("company_avoid <=", value, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidLike(String value) {
            addCriterion("company_avoid like", value, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidNotLike(String value) {
            addCriterion("company_avoid not like", value, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidIn(List<String> values) {
            addCriterion("company_avoid in", values, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidNotIn(List<String> values) {
            addCriterion("company_avoid not in", values, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidBetween(String value1, String value2) {
            addCriterion("company_avoid between", value1, value2, "companyAvoid");
            return (Criteria) this;
        }

        public Criteria andCompanyAvoidNotBetween(String value1, String value2) {
            addCriterion("company_avoid not between", value1, value2, "companyAvoid");
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