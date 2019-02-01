package com.pcitc.base.expert;

import java.util.ArrayList;
import java.util.List;

public class ZjkTreeExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ZjkTreeExample() {
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

        public Criteria andSqlTextIsNull() {
            addCriterion("sql_text is null");
            return (Criteria) this;
        }

        public Criteria andSqlTextIsNotNull() {
            addCriterion("sql_text is not null");
            return (Criteria) this;
        }

        public Criteria andSqlTextEqualTo(String value) {
            addCriterion("sql_text =", value, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextNotEqualTo(String value) {
            addCriterion("sql_text <>", value, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextGreaterThan(String value) {
            addCriterion("sql_text >", value, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextGreaterThanOrEqualTo(String value) {
            addCriterion("sql_text >=", value, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextLessThan(String value) {
            addCriterion("sql_text <", value, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextLessThanOrEqualTo(String value) {
            addCriterion("sql_text <=", value, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextLike(String value) {
            addCriterion("sql_text like", value, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextNotLike(String value) {
            addCriterion("sql_text not like", value, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextIn(List<String> values) {
            addCriterion("sql_text in", values, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextNotIn(List<String> values) {
            addCriterion("sql_text not in", values, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextBetween(String value1, String value2) {
            addCriterion("sql_text between", value1, value2, "sqlText");
            return (Criteria) this;
        }

        public Criteria andSqlTextNotBetween(String value1, String value2) {
            addCriterion("sql_text not between", value1, value2, "sqlText");
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

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andLevelOpenIsNull() {
            addCriterion("level_open is null");
            return (Criteria) this;
        }

        public Criteria andLevelOpenIsNotNull() {
            addCriterion("level_open is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOpenEqualTo(String value) {
            addCriterion("level_open =", value, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenNotEqualTo(String value) {
            addCriterion("level_open <>", value, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenGreaterThan(String value) {
            addCriterion("level_open >", value, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenGreaterThanOrEqualTo(String value) {
            addCriterion("level_open >=", value, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenLessThan(String value) {
            addCriterion("level_open <", value, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenLessThanOrEqualTo(String value) {
            addCriterion("level_open <=", value, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenLike(String value) {
            addCriterion("level_open like", value, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenNotLike(String value) {
            addCriterion("level_open not like", value, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenIn(List<String> values) {
            addCriterion("level_open in", values, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenNotIn(List<String> values) {
            addCriterion("level_open not in", values, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenBetween(String value1, String value2) {
            addCriterion("level_open between", value1, value2, "levelOpen");
            return (Criteria) this;
        }

        public Criteria andLevelOpenNotBetween(String value1, String value2) {
            addCriterion("level_open not between", value1, value2, "levelOpen");
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