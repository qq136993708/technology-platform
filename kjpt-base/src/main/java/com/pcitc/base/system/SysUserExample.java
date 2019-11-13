package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserDispIsNull() {
            addCriterion("user_disp is null");
            return (Criteria) this;
        }

        public Criteria andUserDispIsNotNull() {
            addCriterion("user_disp is not null");
            return (Criteria) this;
        }

        public Criteria andUserDispEqualTo(String value) {
            addCriterion("user_disp =", value, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispNotEqualTo(String value) {
            addCriterion("user_disp <>", value, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispGreaterThan(String value) {
            addCriterion("user_disp >", value, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispGreaterThanOrEqualTo(String value) {
            addCriterion("user_disp >=", value, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispLessThan(String value) {
            addCriterion("user_disp <", value, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispLessThanOrEqualTo(String value) {
            addCriterion("user_disp <=", value, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispLike(String value) {
            addCriterion("user_disp like", value, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispNotLike(String value) {
            addCriterion("user_disp not like", value, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispIn(List<String> values) {
            addCriterion("user_disp in", values, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispNotIn(List<String> values) {
            addCriterion("user_disp not in", values, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispBetween(String value1, String value2) {
            addCriterion("user_disp between", value1, value2, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserDispNotBetween(String value1, String value2) {
            addCriterion("user_disp not between", value1, value2, "userDisp");
            return (Criteria) this;
        }

        public Criteria andUserKindIsNull() {
            addCriterion("user_kind is null");
            return (Criteria) this;
        }

        public Criteria andUserKindIsNotNull() {
            addCriterion("user_kind is not null");
            return (Criteria) this;
        }

        public Criteria andUserKindEqualTo(String value) {
            addCriterion("user_kind =", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindNotEqualTo(String value) {
            addCriterion("user_kind <>", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindGreaterThan(String value) {
            addCriterion("user_kind >", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindGreaterThanOrEqualTo(String value) {
            addCriterion("user_kind >=", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindLessThan(String value) {
            addCriterion("user_kind <", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindLessThanOrEqualTo(String value) {
            addCriterion("user_kind <=", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindLike(String value) {
            addCriterion("user_kind like", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindNotLike(String value) {
            addCriterion("user_kind not like", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindIn(List<String> values) {
            addCriterion("user_kind in", values, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindNotIn(List<String> values) {
            addCriterion("user_kind not in", values, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindBetween(String value1, String value2) {
            addCriterion("user_kind between", value1, value2, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindNotBetween(String value1, String value2) {
            addCriterion("user_kind not between", value1, value2, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserFlagIsNull() {
            addCriterion("user_flag is null");
            return (Criteria) this;
        }

        public Criteria andUserFlagIsNotNull() {
            addCriterion("user_flag is not null");
            return (Criteria) this;
        }

        public Criteria andUserFlagEqualTo(String value) {
            addCriterion("user_flag =", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotEqualTo(String value) {
            addCriterion("user_flag <>", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagGreaterThan(String value) {
            addCriterion("user_flag >", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagGreaterThanOrEqualTo(String value) {
            addCriterion("user_flag >=", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLessThan(String value) {
            addCriterion("user_flag <", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLessThanOrEqualTo(String value) {
            addCriterion("user_flag <=", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLike(String value) {
            addCriterion("user_flag like", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotLike(String value) {
            addCriterion("user_flag not like", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagIn(List<String> values) {
            addCriterion("user_flag in", values, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotIn(List<String> values) {
            addCriterion("user_flag not in", values, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagBetween(String value1, String value2) {
            addCriterion("user_flag between", value1, value2, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotBetween(String value1, String value2) {
            addCriterion("user_flag not between", value1, value2, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserUnitIsNull() {
            addCriterion("user_unit is null");
            return (Criteria) this;
        }

        public Criteria andUserUnitIsNotNull() {
            addCriterion("user_unit is not null");
            return (Criteria) this;
        }

        public Criteria andUserUnitEqualTo(String value) {
            addCriterion("user_unit =", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitNotEqualTo(String value) {
            addCriterion("user_unit <>", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitGreaterThan(String value) {
            addCriterion("user_unit >", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitGreaterThanOrEqualTo(String value) {
            addCriterion("user_unit >=", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitLessThan(String value) {
            addCriterion("user_unit <", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitLessThanOrEqualTo(String value) {
            addCriterion("user_unit <=", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitLike(String value) {
            addCriterion("user_unit like", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitNotLike(String value) {
            addCriterion("user_unit not like", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitIn(List<String> values) {
            addCriterion("user_unit in", values, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitNotIn(List<String> values) {
            addCriterion("user_unit not in", values, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitBetween(String value1, String value2) {
            addCriterion("user_unit between", value1, value2, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitNotBetween(String value1, String value2) {
            addCriterion("user_unit not between", value1, value2, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserPostIsNull() {
            addCriterion("user_post is null");
            return (Criteria) this;
        }

        public Criteria andUserPostIsNotNull() {
            addCriterion("user_post is not null");
            return (Criteria) this;
        }

        public Criteria andUserPostEqualTo(String value) {
            addCriterion("user_post =", value, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostNotEqualTo(String value) {
            addCriterion("user_post <>", value, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostGreaterThan(String value) {
            addCriterion("user_post >", value, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostGreaterThanOrEqualTo(String value) {
            addCriterion("user_post >=", value, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostLessThan(String value) {
            addCriterion("user_post <", value, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostLessThanOrEqualTo(String value) {
            addCriterion("user_post <=", value, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostLike(String value) {
            addCriterion("user_post like", value, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostNotLike(String value) {
            addCriterion("user_post not like", value, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostIn(List<String> values) {
            addCriterion("user_post in", values, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostNotIn(List<String> values) {
            addCriterion("user_post not in", values, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostBetween(String value1, String value2) {
            addCriterion("user_post between", value1, value2, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserPostNotBetween(String value1, String value2) {
            addCriterion("user_post not between", value1, value2, "userPost");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNull() {
            addCriterion("user_role is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNotNull() {
            addCriterion("user_role is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleEqualTo(String value) {
            addCriterion("user_role =", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotEqualTo(String value) {
            addCriterion("user_role <>", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThan(String value) {
            addCriterion("user_role >", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThanOrEqualTo(String value) {
            addCriterion("user_role >=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThan(String value) {
            addCriterion("user_role <", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThanOrEqualTo(String value) {
            addCriterion("user_role <=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLike(String value) {
            addCriterion("user_role like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotLike(String value) {
            addCriterion("user_role not like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleIn(List<String> values) {
            addCriterion("user_role in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotIn(List<String> values) {
            addCriterion("user_role not in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleBetween(String value1, String value2) {
            addCriterion("user_role between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotBetween(String value1, String value2) {
            addCriterion("user_role not between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserOrderIsNull() {
            addCriterion("user_order is null");
            return (Criteria) this;
        }

        public Criteria andUserOrderIsNotNull() {
            addCriterion("user_order is not null");
            return (Criteria) this;
        }

        public Criteria andUserOrderEqualTo(Integer value) {
            addCriterion("user_order =", value, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserOrderNotEqualTo(Integer value) {
            addCriterion("user_order <>", value, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserOrderGreaterThan(Integer value) {
            addCriterion("user_order >", value, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_order >=", value, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserOrderLessThan(Integer value) {
            addCriterion("user_order <", value, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserOrderLessThanOrEqualTo(Integer value) {
            addCriterion("user_order <=", value, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserOrderIn(List<Integer> values) {
            addCriterion("user_order in", values, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserOrderNotIn(List<Integer> values) {
            addCriterion("user_order not in", values, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserOrderBetween(Integer value1, Integer value2) {
            addCriterion("user_order between", value1, value2, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("user_order not between", value1, value2, "userOrder");
            return (Criteria) this;
        }

        public Criteria andUserMailIsNull() {
            addCriterion("user_mail is null");
            return (Criteria) this;
        }

        public Criteria andUserMailIsNotNull() {
            addCriterion("user_mail is not null");
            return (Criteria) this;
        }

        public Criteria andUserMailEqualTo(String value) {
            addCriterion("user_mail =", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotEqualTo(String value) {
            addCriterion("user_mail <>", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailGreaterThan(String value) {
            addCriterion("user_mail >", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailGreaterThanOrEqualTo(String value) {
            addCriterion("user_mail >=", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLessThan(String value) {
            addCriterion("user_mail <", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLessThanOrEqualTo(String value) {
            addCriterion("user_mail <=", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLike(String value) {
            addCriterion("user_mail like", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotLike(String value) {
            addCriterion("user_mail not like", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailIn(List<String> values) {
            addCriterion("user_mail in", values, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotIn(List<String> values) {
            addCriterion("user_mail not in", values, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailBetween(String value1, String value2) {
            addCriterion("user_mail between", value1, value2, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotBetween(String value1, String value2) {
            addCriterion("user_mail not between", value1, value2, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("user_mobile is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("user_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("user_mobile =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("user_mobile <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("user_mobile >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("user_mobile >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("user_mobile <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("user_mobile <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("user_mobile like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("user_mobile not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("user_mobile in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("user_mobile not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("user_mobile between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("user_mobile not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserSignIsNull() {
            addCriterion("user_sign is null");
            return (Criteria) this;
        }

        public Criteria andUserSignIsNotNull() {
            addCriterion("user_sign is not null");
            return (Criteria) this;
        }

        public Criteria andUserSignEqualTo(String value) {
            addCriterion("user_sign =", value, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignNotEqualTo(String value) {
            addCriterion("user_sign <>", value, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignGreaterThan(String value) {
            addCriterion("user_sign >", value, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignGreaterThanOrEqualTo(String value) {
            addCriterion("user_sign >=", value, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignLessThan(String value) {
            addCriterion("user_sign <", value, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignLessThanOrEqualTo(String value) {
            addCriterion("user_sign <=", value, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignLike(String value) {
            addCriterion("user_sign like", value, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignNotLike(String value) {
            addCriterion("user_sign not like", value, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignIn(List<String> values) {
            addCriterion("user_sign in", values, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignNotIn(List<String> values) {
            addCriterion("user_sign not in", values, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignBetween(String value1, String value2) {
            addCriterion("user_sign between", value1, value2, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserSignNotBetween(String value1, String value2) {
            addCriterion("user_sign not between", value1, value2, "userSign");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIsNull() {
            addCriterion("user_create_time is null");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIsNotNull() {
            addCriterion("user_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeEqualTo(String value) {
            addCriterion("user_create_time =", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotEqualTo(String value) {
            addCriterion("user_create_time <>", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeGreaterThan(String value) {
            addCriterion("user_create_time >", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("user_create_time >=", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeLessThan(String value) {
            addCriterion("user_create_time <", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("user_create_time <=", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeLike(String value) {
            addCriterion("user_create_time like", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotLike(String value) {
            addCriterion("user_create_time not like", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIn(List<String> values) {
            addCriterion("user_create_time in", values, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotIn(List<String> values) {
            addCriterion("user_create_time not in", values, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeBetween(String value1, String value2) {
            addCriterion("user_create_time between", value1, value2, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotBetween(String value1, String value2) {
            addCriterion("user_create_time not between", value1, value2, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserLevelIsNull() {
            addCriterion("user_level is null");
            return (Criteria) this;
        }

        public Criteria andUserLevelIsNotNull() {
            addCriterion("user_level is not null");
            return (Criteria) this;
        }

        public Criteria andUserLevelEqualTo(Integer value) {
            addCriterion("user_level =", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotEqualTo(Integer value) {
            addCriterion("user_level <>", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelGreaterThan(Integer value) {
            addCriterion("user_level >", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_level >=", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelLessThan(Integer value) {
            addCriterion("user_level <", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelLessThanOrEqualTo(Integer value) {
            addCriterion("user_level <=", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelIn(List<Integer> values) {
            addCriterion("user_level in", values, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotIn(List<Integer> values) {
            addCriterion("user_level not in", values, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelBetween(Integer value1, Integer value2) {
            addCriterion("user_level between", value1, value2, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("user_level not between", value1, value2, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserDelflagIsNull() {
            addCriterion("user_delflag is null");
            return (Criteria) this;
        }

        public Criteria andUserDelflagIsNotNull() {
            addCriterion("user_delflag is not null");
            return (Criteria) this;
        }

        public Criteria andUserDelflagEqualTo(Integer value) {
            addCriterion("user_delflag =", value, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserDelflagNotEqualTo(Integer value) {
            addCriterion("user_delflag <>", value, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserDelflagGreaterThan(Integer value) {
            addCriterion("user_delflag >", value, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserDelflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_delflag >=", value, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserDelflagLessThan(Integer value) {
            addCriterion("user_delflag <", value, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserDelflagLessThanOrEqualTo(Integer value) {
            addCriterion("user_delflag <=", value, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserDelflagIn(List<Integer> values) {
            addCriterion("user_delflag in", values, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserDelflagNotIn(List<Integer> values) {
            addCriterion("user_delflag not in", values, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserDelflagBetween(Integer value1, Integer value2) {
            addCriterion("user_delflag between", value1, value2, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserDelflagNotBetween(Integer value1, Integer value2) {
            addCriterion("user_delflag not between", value1, value2, "userDelflag");
            return (Criteria) this;
        }

        public Criteria andUserRelationIsNull() {
            addCriterion("user_relation is null");
            return (Criteria) this;
        }

        public Criteria andUserRelationIsNotNull() {
            addCriterion("user_relation is not null");
            return (Criteria) this;
        }

        public Criteria andUserRelationEqualTo(String value) {
            addCriterion("user_relation =", value, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationNotEqualTo(String value) {
            addCriterion("user_relation <>", value, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationGreaterThan(String value) {
            addCriterion("user_relation >", value, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationGreaterThanOrEqualTo(String value) {
            addCriterion("user_relation >=", value, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationLessThan(String value) {
            addCriterion("user_relation <", value, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationLessThanOrEqualTo(String value) {
            addCriterion("user_relation <=", value, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationLike(String value) {
            addCriterion("user_relation like", value, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationNotLike(String value) {
            addCriterion("user_relation not like", value, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationIn(List<String> values) {
            addCriterion("user_relation in", values, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationNotIn(List<String> values) {
            addCriterion("user_relation not in", values, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationBetween(String value1, String value2) {
            addCriterion("user_relation between", value1, value2, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserRelationNotBetween(String value1, String value2) {
            addCriterion("user_relation not between", value1, value2, "userRelation");
            return (Criteria) this;
        }

        public Criteria andUserExtendIsNull() {
            addCriterion("user_extend is null");
            return (Criteria) this;
        }

        public Criteria andUserExtendIsNotNull() {
            addCriterion("user_extend is not null");
            return (Criteria) this;
        }

        public Criteria andUserExtendEqualTo(String value) {
            addCriterion("user_extend =", value, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendNotEqualTo(String value) {
            addCriterion("user_extend <>", value, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendGreaterThan(String value) {
            addCriterion("user_extend >", value, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendGreaterThanOrEqualTo(String value) {
            addCriterion("user_extend >=", value, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendLessThan(String value) {
            addCriterion("user_extend <", value, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendLessThanOrEqualTo(String value) {
            addCriterion("user_extend <=", value, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendLike(String value) {
            addCriterion("user_extend like", value, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendNotLike(String value) {
            addCriterion("user_extend not like", value, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendIn(List<String> values) {
            addCriterion("user_extend in", values, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendNotIn(List<String> values) {
            addCriterion("user_extend not in", values, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendBetween(String value1, String value2) {
            addCriterion("user_extend between", value1, value2, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserExtendNotBetween(String value1, String value2) {
            addCriterion("user_extend not between", value1, value2, "userExtend");
            return (Criteria) this;
        }

        public Criteria andUserCommentIsNull() {
            addCriterion("user_comment is null");
            return (Criteria) this;
        }

        public Criteria andUserCommentIsNotNull() {
            addCriterion("user_comment is not null");
            return (Criteria) this;
        }

        public Criteria andUserCommentEqualTo(String value) {
            addCriterion("user_comment =", value, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentNotEqualTo(String value) {
            addCriterion("user_comment <>", value, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentGreaterThan(String value) {
            addCriterion("user_comment >", value, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentGreaterThanOrEqualTo(String value) {
            addCriterion("user_comment >=", value, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentLessThan(String value) {
            addCriterion("user_comment <", value, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentLessThanOrEqualTo(String value) {
            addCriterion("user_comment <=", value, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentLike(String value) {
            addCriterion("user_comment like", value, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentNotLike(String value) {
            addCriterion("user_comment not like", value, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentIn(List<String> values) {
            addCriterion("user_comment in", values, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentNotIn(List<String> values) {
            addCriterion("user_comment not in", values, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentBetween(String value1, String value2) {
            addCriterion("user_comment between", value1, value2, "userComment");
            return (Criteria) this;
        }

        public Criteria andUserCommentNotBetween(String value1, String value2) {
            addCriterion("user_comment not between", value1, value2, "userComment");
            return (Criteria) this;
        }

        public Criteria andIsDomainIsNull() {
            addCriterion("is_domain is null");
            return (Criteria) this;
        }

        public Criteria andIsDomainIsNotNull() {
            addCriterion("is_domain is not null");
            return (Criteria) this;
        }

        public Criteria andIsDomainEqualTo(Integer value) {
            addCriterion("is_domain =", value, "isDomain");
            return (Criteria) this;
        }

        public Criteria andIsDomainNotEqualTo(Integer value) {
            addCriterion("is_domain <>", value, "isDomain");
            return (Criteria) this;
        }

        public Criteria andIsDomainGreaterThan(Integer value) {
            addCriterion("is_domain >", value, "isDomain");
            return (Criteria) this;
        }

        public Criteria andIsDomainGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_domain >=", value, "isDomain");
            return (Criteria) this;
        }

        public Criteria andIsDomainLessThan(Integer value) {
            addCriterion("is_domain <", value, "isDomain");
            return (Criteria) this;
        }

        public Criteria andIsDomainLessThanOrEqualTo(Integer value) {
            addCriterion("is_domain <=", value, "isDomain");
            return (Criteria) this;
        }

        public Criteria andIsDomainIn(List<Integer> values) {
            addCriterion("is_domain in", values, "isDomain");
            return (Criteria) this;
        }

        public Criteria andIsDomainNotIn(List<Integer> values) {
            addCriterion("is_domain not in", values, "isDomain");
            return (Criteria) this;
        }

        public Criteria andIsDomainBetween(Integer value1, Integer value2) {
            addCriterion("is_domain between", value1, value2, "isDomain");
            return (Criteria) this;
        }

        public Criteria andIsDomainNotBetween(Integer value1, Integer value2) {
            addCriterion("is_domain not between", value1, value2, "isDomain");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberIsNull() {
            addCriterion("login_error_number is null");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberIsNotNull() {
            addCriterion("login_error_number is not null");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberEqualTo(Integer value) {
            addCriterion("login_error_number =", value, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberNotEqualTo(Integer value) {
            addCriterion("login_error_number <>", value, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberGreaterThan(Integer value) {
            addCriterion("login_error_number >", value, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_error_number >=", value, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberLessThan(Integer value) {
            addCriterion("login_error_number <", value, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberLessThanOrEqualTo(Integer value) {
            addCriterion("login_error_number <=", value, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberIn(List<Integer> values) {
            addCriterion("login_error_number in", values, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberNotIn(List<Integer> values) {
            addCriterion("login_error_number not in", values, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberBetween(Integer value1, Integer value2) {
            addCriterion("login_error_number between", value1, value2, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("login_error_number not between", value1, value2, "loginErrorNumber");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeIsNull() {
            addCriterion("login_check_code is null");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeIsNotNull() {
            addCriterion("login_check_code is not null");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeEqualTo(String value) {
            addCriterion("login_check_code =", value, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeNotEqualTo(String value) {
            addCriterion("login_check_code <>", value, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeGreaterThan(String value) {
            addCriterion("login_check_code >", value, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeGreaterThanOrEqualTo(String value) {
            addCriterion("login_check_code >=", value, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeLessThan(String value) {
            addCriterion("login_check_code <", value, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeLessThanOrEqualTo(String value) {
            addCriterion("login_check_code <=", value, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeLike(String value) {
            addCriterion("login_check_code like", value, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeNotLike(String value) {
            addCriterion("login_check_code not like", value, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeIn(List<String> values) {
            addCriterion("login_check_code in", values, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeNotIn(List<String> values) {
            addCriterion("login_check_code not in", values, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeBetween(String value1, String value2) {
            addCriterion("login_check_code between", value1, value2, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andLoginCheckCodeNotBetween(String value1, String value2) {
            addCriterion("login_check_code not between", value1, value2, "loginCheckCode");
            return (Criteria) this;
        }

        public Criteria andUserConfig1IsNull() {
            addCriterion("user_config1 is null");
            return (Criteria) this;
        }

        public Criteria andUserConfig1IsNotNull() {
            addCriterion("user_config1 is not null");
            return (Criteria) this;
        }

        public Criteria andUserConfig1EqualTo(String value) {
            addCriterion("user_config1 =", value, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1NotEqualTo(String value) {
            addCriterion("user_config1 <>", value, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1GreaterThan(String value) {
            addCriterion("user_config1 >", value, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1GreaterThanOrEqualTo(String value) {
            addCriterion("user_config1 >=", value, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1LessThan(String value) {
            addCriterion("user_config1 <", value, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1LessThanOrEqualTo(String value) {
            addCriterion("user_config1 <=", value, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1Like(String value) {
            addCriterion("user_config1 like", value, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1NotLike(String value) {
            addCriterion("user_config1 not like", value, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1In(List<String> values) {
            addCriterion("user_config1 in", values, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1NotIn(List<String> values) {
            addCriterion("user_config1 not in", values, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1Between(String value1, String value2) {
            addCriterion("user_config1 between", value1, value2, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig1NotBetween(String value1, String value2) {
            addCriterion("user_config1 not between", value1, value2, "userConfig1");
            return (Criteria) this;
        }

        public Criteria andUserConfig2IsNull() {
            addCriterion("user_config2 is null");
            return (Criteria) this;
        }

        public Criteria andUserConfig2IsNotNull() {
            addCriterion("user_config2 is not null");
            return (Criteria) this;
        }

        public Criteria andUserConfig2EqualTo(String value) {
            addCriterion("user_config2 =", value, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2NotEqualTo(String value) {
            addCriterion("user_config2 <>", value, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2GreaterThan(String value) {
            addCriterion("user_config2 >", value, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2GreaterThanOrEqualTo(String value) {
            addCriterion("user_config2 >=", value, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2LessThan(String value) {
            addCriterion("user_config2 <", value, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2LessThanOrEqualTo(String value) {
            addCriterion("user_config2 <=", value, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2Like(String value) {
            addCriterion("user_config2 like", value, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2NotLike(String value) {
            addCriterion("user_config2 not like", value, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2In(List<String> values) {
            addCriterion("user_config2 in", values, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2NotIn(List<String> values) {
            addCriterion("user_config2 not in", values, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2Between(String value1, String value2) {
            addCriterion("user_config2 between", value1, value2, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig2NotBetween(String value1, String value2) {
            addCriterion("user_config2 not between", value1, value2, "userConfig2");
            return (Criteria) this;
        }

        public Criteria andUserConfig3IsNull() {
            addCriterion("user_config3 is null");
            return (Criteria) this;
        }

        public Criteria andUserConfig3IsNotNull() {
            addCriterion("user_config3 is not null");
            return (Criteria) this;
        }

        public Criteria andUserConfig3EqualTo(String value) {
            addCriterion("user_config3 =", value, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3NotEqualTo(String value) {
            addCriterion("user_config3 <>", value, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3GreaterThan(String value) {
            addCriterion("user_config3 >", value, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3GreaterThanOrEqualTo(String value) {
            addCriterion("user_config3 >=", value, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3LessThan(String value) {
            addCriterion("user_config3 <", value, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3LessThanOrEqualTo(String value) {
            addCriterion("user_config3 <=", value, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3Like(String value) {
            addCriterion("user_config3 like", value, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3NotLike(String value) {
            addCriterion("user_config3 not like", value, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3In(List<String> values) {
            addCriterion("user_config3 in", values, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3NotIn(List<String> values) {
            addCriterion("user_config3 not in", values, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3Between(String value1, String value2) {
            addCriterion("user_config3 between", value1, value2, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig3NotBetween(String value1, String value2) {
            addCriterion("user_config3 not between", value1, value2, "userConfig3");
            return (Criteria) this;
        }

        public Criteria andUserConfig4IsNull() {
            addCriterion("user_config4 is null");
            return (Criteria) this;
        }

        public Criteria andUserConfig4IsNotNull() {
            addCriterion("user_config4 is not null");
            return (Criteria) this;
        }

        public Criteria andUserConfig4EqualTo(String value) {
            addCriterion("user_config4 =", value, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4NotEqualTo(String value) {
            addCriterion("user_config4 <>", value, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4GreaterThan(String value) {
            addCriterion("user_config4 >", value, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4GreaterThanOrEqualTo(String value) {
            addCriterion("user_config4 >=", value, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4LessThan(String value) {
            addCriterion("user_config4 <", value, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4LessThanOrEqualTo(String value) {
            addCriterion("user_config4 <=", value, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4Like(String value) {
            addCriterion("user_config4 like", value, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4NotLike(String value) {
            addCriterion("user_config4 not like", value, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4In(List<String> values) {
            addCriterion("user_config4 in", values, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4NotIn(List<String> values) {
            addCriterion("user_config4 not in", values, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4Between(String value1, String value2) {
            addCriterion("user_config4 between", value1, value2, "userConfig4");
            return (Criteria) this;
        }

        public Criteria andUserConfig4NotBetween(String value1, String value2) {
            addCriterion("user_config4 not between", value1, value2, "userConfig4");
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