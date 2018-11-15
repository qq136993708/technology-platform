package com.pcitc.base.engin.quality.qualityPlan.vo;

import java.util.ArrayList;
import java.util.List;

public class QualityPlanVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QualityPlanVOExample() {
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
            addCriterion("DATA_ID is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("DATA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(String value) {
            addCriterion("DATA_ID =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(String value) {
            addCriterion("DATA_ID <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(String value) {
            addCriterion("DATA_ID >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_ID >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(String value) {
            addCriterion("DATA_ID <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(String value) {
            addCriterion("DATA_ID <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLike(String value) {
            addCriterion("DATA_ID like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotLike(String value) {
            addCriterion("DATA_ID not like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<String> values) {
            addCriterion("DATA_ID in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<String> values) {
            addCriterion("DATA_ID not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(String value1, String value2) {
            addCriterion("DATA_ID between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(String value1, String value2) {
            addCriterion("DATA_ID not between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andSysFlagIsNull() {
            addCriterion("SYS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSysFlagIsNotNull() {
            addCriterion("SYS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSysFlagEqualTo(String value) {
            addCriterion("SYS_FLAG =", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotEqualTo(String value) {
            addCriterion("SYS_FLAG <>", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThan(String value) {
            addCriterion("SYS_FLAG >", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_FLAG >=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThan(String value) {
            addCriterion("SYS_FLAG <", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThanOrEqualTo(String value) {
            addCriterion("SYS_FLAG <=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLike(String value) {
            addCriterion("SYS_FLAG like", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotLike(String value) {
            addCriterion("SYS_FLAG not like", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagIn(List<String> values) {
            addCriterion("SYS_FLAG in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotIn(List<String> values) {
            addCriterion("SYS_FLAG not in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagBetween(String value1, String value2) {
            addCriterion("SYS_FLAG between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotBetween(String value1, String value2) {
            addCriterion("SYS_FLAG not between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andDataOrderIsNull() {
            addCriterion("DATA_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andDataOrderIsNotNull() {
            addCriterion("DATA_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andDataOrderEqualTo(String value) {
            addCriterion("DATA_ORDER =", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotEqualTo(String value) {
            addCriterion("DATA_ORDER <>", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderGreaterThan(String value) {
            addCriterion("DATA_ORDER >", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_ORDER >=", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderLessThan(String value) {
            addCriterion("DATA_ORDER <", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderLessThanOrEqualTo(String value) {
            addCriterion("DATA_ORDER <=", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderLike(String value) {
            addCriterion("DATA_ORDER like", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotLike(String value) {
            addCriterion("DATA_ORDER not like", value, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderIn(List<String> values) {
            addCriterion("DATA_ORDER in", values, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotIn(List<String> values) {
            addCriterion("DATA_ORDER not in", values, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderBetween(String value1, String value2) {
            addCriterion("DATA_ORDER between", value1, value2, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDataOrderNotBetween(String value1, String value2) {
            addCriterion("DATA_ORDER not between", value1, value2, "dataOrder");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("DEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("DEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("DEL_FLAG =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("DEL_FLAG <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("DEL_FLAG >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("DEL_FLAG <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("DEL_FLAG like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("DEL_FLAG not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("DEL_FLAG in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("DEL_FLAG not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("DEL_FLAG between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("CREATE_DATE like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("CREATE_DATE not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("MODIFY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("MODIFY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(String value) {
            addCriterion("MODIFY_DATE =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(String value) {
            addCriterion("MODIFY_DATE <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(String value) {
            addCriterion("MODIFY_DATE >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFY_DATE >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(String value) {
            addCriterion("MODIFY_DATE <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(String value) {
            addCriterion("MODIFY_DATE <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLike(String value) {
            addCriterion("MODIFY_DATE like", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotLike(String value) {
            addCriterion("MODIFY_DATE not like", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<String> values) {
            addCriterion("MODIFY_DATE in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<String> values) {
            addCriterion("MODIFY_DATE not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(String value1, String value2) {
            addCriterion("MODIFY_DATE between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(String value1, String value2) {
            addCriterion("MODIFY_DATE not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNull() {
            addCriterion("MODIFY_USER is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNotNull() {
            addCriterion("MODIFY_USER is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserEqualTo(String value) {
            addCriterion("MODIFY_USER =", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotEqualTo(String value) {
            addCriterion("MODIFY_USER <>", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThan(String value) {
            addCriterion("MODIFY_USER >", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFY_USER >=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThan(String value) {
            addCriterion("MODIFY_USER <", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThanOrEqualTo(String value) {
            addCriterion("MODIFY_USER <=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLike(String value) {
            addCriterion("MODIFY_USER like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLike(String value) {
            addCriterion("MODIFY_USER not like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserIn(List<String> values) {
            addCriterion("MODIFY_USER in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotIn(List<String> values) {
            addCriterion("MODIFY_USER not in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserBetween(String value1, String value2) {
            addCriterion("MODIFY_USER between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotBetween(String value1, String value2) {
            addCriterion("MODIFY_USER not between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateIsNull() {
            addCriterion("WORKFLOW_STATE is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateIsNotNull() {
            addCriterion("WORKFLOW_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateEqualTo(String value) {
            addCriterion("WORKFLOW_STATE =", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateNotEqualTo(String value) {
            addCriterion("WORKFLOW_STATE <>", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateGreaterThan(String value) {
            addCriterion("WORKFLOW_STATE >", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateGreaterThanOrEqualTo(String value) {
            addCriterion("WORKFLOW_STATE >=", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateLessThan(String value) {
            addCriterion("WORKFLOW_STATE <", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateLessThanOrEqualTo(String value) {
            addCriterion("WORKFLOW_STATE <=", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateLike(String value) {
            addCriterion("WORKFLOW_STATE like", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateNotLike(String value) {
            addCriterion("WORKFLOW_STATE not like", value, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateIn(List<String> values) {
            addCriterion("WORKFLOW_STATE in", values, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateNotIn(List<String> values) {
            addCriterion("WORKFLOW_STATE not in", values, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateBetween(String value1, String value2) {
            addCriterion("WORKFLOW_STATE between", value1, value2, "workflowState");
            return (Criteria) this;
        }

        public Criteria andWorkflowStateNotBetween(String value1, String value2) {
            addCriterion("WORKFLOW_STATE not between", value1, value2, "workflowState");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNull() {
            addCriterion("COMPANY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("COMPANY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("COMPANY_CODE =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("COMPANY_CODE <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("COMPANY_CODE >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_CODE >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("COMPANY_CODE <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_CODE <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("COMPANY_CODE like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("COMPANY_CODE not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("COMPANY_CODE in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("COMPANY_CODE not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("COMPANY_CODE between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("COMPANY_CODE not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andZljhbmIsNull() {
            addCriterion("ZLJHBM is null");
            return (Criteria) this;
        }

        public Criteria andZljhbmIsNotNull() {
            addCriterion("ZLJHBM is not null");
            return (Criteria) this;
        }

        public Criteria andZljhbmEqualTo(String value) {
            addCriterion("ZLJHBM =", value, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmNotEqualTo(String value) {
            addCriterion("ZLJHBM <>", value, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmGreaterThan(String value) {
            addCriterion("ZLJHBM >", value, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmGreaterThanOrEqualTo(String value) {
            addCriterion("ZLJHBM >=", value, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmLessThan(String value) {
            addCriterion("ZLJHBM <", value, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmLessThanOrEqualTo(String value) {
            addCriterion("ZLJHBM <=", value, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmLike(String value) {
            addCriterion("ZLJHBM like", value, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmNotLike(String value) {
            addCriterion("ZLJHBM not like", value, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmIn(List<String> values) {
            addCriterion("ZLJHBM in", values, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmNotIn(List<String> values) {
            addCriterion("ZLJHBM not in", values, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmBetween(String value1, String value2) {
            addCriterion("ZLJHBM between", value1, value2, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhbmNotBetween(String value1, String value2) {
            addCriterion("ZLJHBM not between", value1, value2, "zljhbm");
            return (Criteria) this;
        }

        public Criteria andZljhidIsNull() {
            addCriterion("ZLJHID is null");
            return (Criteria) this;
        }

        public Criteria andZljhidIsNotNull() {
            addCriterion("ZLJHID is not null");
            return (Criteria) this;
        }

        public Criteria andZljhidEqualTo(String value) {
            addCriterion("ZLJHID =", value, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidNotEqualTo(String value) {
            addCriterion("ZLJHID <>", value, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidGreaterThan(String value) {
            addCriterion("ZLJHID >", value, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidGreaterThanOrEqualTo(String value) {
            addCriterion("ZLJHID >=", value, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidLessThan(String value) {
            addCriterion("ZLJHID <", value, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidLessThanOrEqualTo(String value) {
            addCriterion("ZLJHID <=", value, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidLike(String value) {
            addCriterion("ZLJHID like", value, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidNotLike(String value) {
            addCriterion("ZLJHID not like", value, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidIn(List<String> values) {
            addCriterion("ZLJHID in", values, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidNotIn(List<String> values) {
            addCriterion("ZLJHID not in", values, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidBetween(String value1, String value2) {
            addCriterion("ZLJHID between", value1, value2, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhidNotBetween(String value1, String value2) {
            addCriterion("ZLJHID not between", value1, value2, "zljhid");
            return (Criteria) this;
        }

        public Criteria andZljhmcIsNull() {
            addCriterion("ZLJHMC is null");
            return (Criteria) this;
        }

        public Criteria andZljhmcIsNotNull() {
            addCriterion("ZLJHMC is not null");
            return (Criteria) this;
        }

        public Criteria andZljhmcEqualTo(String value) {
            addCriterion("ZLJHMC =", value, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcNotEqualTo(String value) {
            addCriterion("ZLJHMC <>", value, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcGreaterThan(String value) {
            addCriterion("ZLJHMC >", value, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcGreaterThanOrEqualTo(String value) {
            addCriterion("ZLJHMC >=", value, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcLessThan(String value) {
            addCriterion("ZLJHMC <", value, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcLessThanOrEqualTo(String value) {
            addCriterion("ZLJHMC <=", value, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcLike(String value) {
            addCriterion("ZLJHMC like", value, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcNotLike(String value) {
            addCriterion("ZLJHMC not like", value, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcIn(List<String> values) {
            addCriterion("ZLJHMC in", values, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcNotIn(List<String> values) {
            addCriterion("ZLJHMC not in", values, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcBetween(String value1, String value2) {
            addCriterion("ZLJHMC between", value1, value2, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andZljhmcNotBetween(String value1, String value2) {
            addCriterion("ZLJHMC not between", value1, value2, "zljhmc");
            return (Criteria) this;
        }

        public Criteria andXmidIsNull() {
            addCriterion("XMID is null");
            return (Criteria) this;
        }

        public Criteria andXmidIsNotNull() {
            addCriterion("XMID is not null");
            return (Criteria) this;
        }

        public Criteria andXmidEqualTo(String value) {
            addCriterion("XMID =", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidNotEqualTo(String value) {
            addCriterion("XMID <>", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidGreaterThan(String value) {
            addCriterion("XMID >", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidGreaterThanOrEqualTo(String value) {
            addCriterion("XMID >=", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidLessThan(String value) {
            addCriterion("XMID <", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidLessThanOrEqualTo(String value) {
            addCriterion("XMID <=", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidLike(String value) {
            addCriterion("XMID like", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidNotLike(String value) {
            addCriterion("XMID not like", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidIn(List<String> values) {
            addCriterion("XMID in", values, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidNotIn(List<String> values) {
            addCriterion("XMID not in", values, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidBetween(String value1, String value2) {
            addCriterion("XMID between", value1, value2, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidNotBetween(String value1, String value2) {
            addCriterion("XMID not between", value1, value2, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmbmIsNull() {
            addCriterion("XMBM is null");
            return (Criteria) this;
        }

        public Criteria andXmbmIsNotNull() {
            addCriterion("XMBM is not null");
            return (Criteria) this;
        }

        public Criteria andXmbmEqualTo(String value) {
            addCriterion("XMBM =", value, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmNotEqualTo(String value) {
            addCriterion("XMBM <>", value, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmGreaterThan(String value) {
            addCriterion("XMBM >", value, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmGreaterThanOrEqualTo(String value) {
            addCriterion("XMBM >=", value, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmLessThan(String value) {
            addCriterion("XMBM <", value, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmLessThanOrEqualTo(String value) {
            addCriterion("XMBM <=", value, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmLike(String value) {
            addCriterion("XMBM like", value, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmNotLike(String value) {
            addCriterion("XMBM not like", value, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmIn(List<String> values) {
            addCriterion("XMBM in", values, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmNotIn(List<String> values) {
            addCriterion("XMBM not in", values, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmBetween(String value1, String value2) {
            addCriterion("XMBM between", value1, value2, "xmbm");
            return (Criteria) this;
        }

        public Criteria andXmbmNotBetween(String value1, String value2) {
            addCriterion("XMBM not between", value1, value2, "xmbm");
            return (Criteria) this;
        }

        public Criteria andZxmmcIsNull() {
            addCriterion("ZXMMC is null");
            return (Criteria) this;
        }

        public Criteria andZxmmcIsNotNull() {
            addCriterion("ZXMMC is not null");
            return (Criteria) this;
        }

        public Criteria andZxmmcEqualTo(String value) {
            addCriterion("ZXMMC =", value, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcNotEqualTo(String value) {
            addCriterion("ZXMMC <>", value, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcGreaterThan(String value) {
            addCriterion("ZXMMC >", value, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcGreaterThanOrEqualTo(String value) {
            addCriterion("ZXMMC >=", value, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcLessThan(String value) {
            addCriterion("ZXMMC <", value, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcLessThanOrEqualTo(String value) {
            addCriterion("ZXMMC <=", value, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcLike(String value) {
            addCriterion("ZXMMC like", value, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcNotLike(String value) {
            addCriterion("ZXMMC not like", value, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcIn(List<String> values) {
            addCriterion("ZXMMC in", values, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcNotIn(List<String> values) {
            addCriterion("ZXMMC not in", values, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcBetween(String value1, String value2) {
            addCriterion("ZXMMC between", value1, value2, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andZxmmcNotBetween(String value1, String value2) {
            addCriterion("ZXMMC not between", value1, value2, "zxmmc");
            return (Criteria) this;
        }

        public Criteria andWbsidIsNull() {
            addCriterion("WBSID is null");
            return (Criteria) this;
        }

        public Criteria andWbsidIsNotNull() {
            addCriterion("WBSID is not null");
            return (Criteria) this;
        }

        public Criteria andWbsidEqualTo(String value) {
            addCriterion("WBSID =", value, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidNotEqualTo(String value) {
            addCriterion("WBSID <>", value, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidGreaterThan(String value) {
            addCriterion("WBSID >", value, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidGreaterThanOrEqualTo(String value) {
            addCriterion("WBSID >=", value, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidLessThan(String value) {
            addCriterion("WBSID <", value, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidLessThanOrEqualTo(String value) {
            addCriterion("WBSID <=", value, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidLike(String value) {
            addCriterion("WBSID like", value, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidNotLike(String value) {
            addCriterion("WBSID not like", value, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidIn(List<String> values) {
            addCriterion("WBSID in", values, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidNotIn(List<String> values) {
            addCriterion("WBSID not in", values, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidBetween(String value1, String value2) {
            addCriterion("WBSID between", value1, value2, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsidNotBetween(String value1, String value2) {
            addCriterion("WBSID not between", value1, value2, "wbsid");
            return (Criteria) this;
        }

        public Criteria andWbsbmIsNull() {
            addCriterion("WBSBM is null");
            return (Criteria) this;
        }

        public Criteria andWbsbmIsNotNull() {
            addCriterion("WBSBM is not null");
            return (Criteria) this;
        }

        public Criteria andWbsbmEqualTo(String value) {
            addCriterion("WBSBM =", value, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmNotEqualTo(String value) {
            addCriterion("WBSBM <>", value, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmGreaterThan(String value) {
            addCriterion("WBSBM >", value, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmGreaterThanOrEqualTo(String value) {
            addCriterion("WBSBM >=", value, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmLessThan(String value) {
            addCriterion("WBSBM <", value, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmLessThanOrEqualTo(String value) {
            addCriterion("WBSBM <=", value, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmLike(String value) {
            addCriterion("WBSBM like", value, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmNotLike(String value) {
            addCriterion("WBSBM not like", value, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmIn(List<String> values) {
            addCriterion("WBSBM in", values, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmNotIn(List<String> values) {
            addCriterion("WBSBM not in", values, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmBetween(String value1, String value2) {
            addCriterion("WBSBM between", value1, value2, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsbmNotBetween(String value1, String value2) {
            addCriterion("WBSBM not between", value1, value2, "wbsbm");
            return (Criteria) this;
        }

        public Criteria andWbsmcIsNull() {
            addCriterion("WBSMC is null");
            return (Criteria) this;
        }

        public Criteria andWbsmcIsNotNull() {
            addCriterion("WBSMC is not null");
            return (Criteria) this;
        }

        public Criteria andWbsmcEqualTo(String value) {
            addCriterion("WBSMC =", value, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcNotEqualTo(String value) {
            addCriterion("WBSMC <>", value, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcGreaterThan(String value) {
            addCriterion("WBSMC >", value, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcGreaterThanOrEqualTo(String value) {
            addCriterion("WBSMC >=", value, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcLessThan(String value) {
            addCriterion("WBSMC <", value, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcLessThanOrEqualTo(String value) {
            addCriterion("WBSMC <=", value, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcLike(String value) {
            addCriterion("WBSMC like", value, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcNotLike(String value) {
            addCriterion("WBSMC not like", value, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcIn(List<String> values) {
            addCriterion("WBSMC in", values, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcNotIn(List<String> values) {
            addCriterion("WBSMC not in", values, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcBetween(String value1, String value2) {
            addCriterion("WBSMC between", value1, value2, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andWbsmcNotBetween(String value1, String value2) {
            addCriterion("WBSMC not between", value1, value2, "wbsmc");
            return (Criteria) this;
        }

        public Criteria andHtidIsNull() {
            addCriterion("HTID is null");
            return (Criteria) this;
        }

        public Criteria andHtidIsNotNull() {
            addCriterion("HTID is not null");
            return (Criteria) this;
        }

        public Criteria andHtidEqualTo(String value) {
            addCriterion("HTID =", value, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidNotEqualTo(String value) {
            addCriterion("HTID <>", value, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidGreaterThan(String value) {
            addCriterion("HTID >", value, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidGreaterThanOrEqualTo(String value) {
            addCriterion("HTID >=", value, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidLessThan(String value) {
            addCriterion("HTID <", value, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidLessThanOrEqualTo(String value) {
            addCriterion("HTID <=", value, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidLike(String value) {
            addCriterion("HTID like", value, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidNotLike(String value) {
            addCriterion("HTID not like", value, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidIn(List<String> values) {
            addCriterion("HTID in", values, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidNotIn(List<String> values) {
            addCriterion("HTID not in", values, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidBetween(String value1, String value2) {
            addCriterion("HTID between", value1, value2, "htid");
            return (Criteria) this;
        }

        public Criteria andHtidNotBetween(String value1, String value2) {
            addCriterion("HTID not between", value1, value2, "htid");
            return (Criteria) this;
        }

        public Criteria andHtbmIsNull() {
            addCriterion("HTBM is null");
            return (Criteria) this;
        }

        public Criteria andHtbmIsNotNull() {
            addCriterion("HTBM is not null");
            return (Criteria) this;
        }

        public Criteria andHtbmEqualTo(String value) {
            addCriterion("HTBM =", value, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmNotEqualTo(String value) {
            addCriterion("HTBM <>", value, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmGreaterThan(String value) {
            addCriterion("HTBM >", value, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmGreaterThanOrEqualTo(String value) {
            addCriterion("HTBM >=", value, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmLessThan(String value) {
            addCriterion("HTBM <", value, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmLessThanOrEqualTo(String value) {
            addCriterion("HTBM <=", value, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmLike(String value) {
            addCriterion("HTBM like", value, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmNotLike(String value) {
            addCriterion("HTBM not like", value, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmIn(List<String> values) {
            addCriterion("HTBM in", values, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmNotIn(List<String> values) {
            addCriterion("HTBM not in", values, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmBetween(String value1, String value2) {
            addCriterion("HTBM between", value1, value2, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtbmNotBetween(String value1, String value2) {
            addCriterion("HTBM not between", value1, value2, "htbm");
            return (Criteria) this;
        }

        public Criteria andHtmcIsNull() {
            addCriterion("HTMC is null");
            return (Criteria) this;
        }

        public Criteria andHtmcIsNotNull() {
            addCriterion("HTMC is not null");
            return (Criteria) this;
        }

        public Criteria andHtmcEqualTo(String value) {
            addCriterion("HTMC =", value, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcNotEqualTo(String value) {
            addCriterion("HTMC <>", value, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcGreaterThan(String value) {
            addCriterion("HTMC >", value, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcGreaterThanOrEqualTo(String value) {
            addCriterion("HTMC >=", value, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcLessThan(String value) {
            addCriterion("HTMC <", value, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcLessThanOrEqualTo(String value) {
            addCriterion("HTMC <=", value, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcLike(String value) {
            addCriterion("HTMC like", value, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcNotLike(String value) {
            addCriterion("HTMC not like", value, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcIn(List<String> values) {
            addCriterion("HTMC in", values, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcNotIn(List<String> values) {
            addCriterion("HTMC not in", values, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcBetween(String value1, String value2) {
            addCriterion("HTMC between", value1, value2, "htmc");
            return (Criteria) this;
        }

        public Criteria andHtmcNotBetween(String value1, String value2) {
            addCriterion("HTMC not between", value1, value2, "htmc");
            return (Criteria) this;
        }

        public Criteria andJldwbmIsNull() {
            addCriterion("JLDWBM is null");
            return (Criteria) this;
        }

        public Criteria andJldwbmIsNotNull() {
            addCriterion("JLDWBM is not null");
            return (Criteria) this;
        }

        public Criteria andJldwbmEqualTo(String value) {
            addCriterion("JLDWBM =", value, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmNotEqualTo(String value) {
            addCriterion("JLDWBM <>", value, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmGreaterThan(String value) {
            addCriterion("JLDWBM >", value, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmGreaterThanOrEqualTo(String value) {
            addCriterion("JLDWBM >=", value, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmLessThan(String value) {
            addCriterion("JLDWBM <", value, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmLessThanOrEqualTo(String value) {
            addCriterion("JLDWBM <=", value, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmLike(String value) {
            addCriterion("JLDWBM like", value, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmNotLike(String value) {
            addCriterion("JLDWBM not like", value, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmIn(List<String> values) {
            addCriterion("JLDWBM in", values, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmNotIn(List<String> values) {
            addCriterion("JLDWBM not in", values, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmBetween(String value1, String value2) {
            addCriterion("JLDWBM between", value1, value2, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwbmNotBetween(String value1, String value2) {
            addCriterion("JLDWBM not between", value1, value2, "jldwbm");
            return (Criteria) this;
        }

        public Criteria andJldwmcIsNull() {
            addCriterion("JLDWMC is null");
            return (Criteria) this;
        }

        public Criteria andJldwmcIsNotNull() {
            addCriterion("JLDWMC is not null");
            return (Criteria) this;
        }

        public Criteria andJldwmcEqualTo(String value) {
            addCriterion("JLDWMC =", value, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcNotEqualTo(String value) {
            addCriterion("JLDWMC <>", value, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcGreaterThan(String value) {
            addCriterion("JLDWMC >", value, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcGreaterThanOrEqualTo(String value) {
            addCriterion("JLDWMC >=", value, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcLessThan(String value) {
            addCriterion("JLDWMC <", value, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcLessThanOrEqualTo(String value) {
            addCriterion("JLDWMC <=", value, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcLike(String value) {
            addCriterion("JLDWMC like", value, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcNotLike(String value) {
            addCriterion("JLDWMC not like", value, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcIn(List<String> values) {
            addCriterion("JLDWMC in", values, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcNotIn(List<String> values) {
            addCriterion("JLDWMC not in", values, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcBetween(String value1, String value2) {
            addCriterion("JLDWMC between", value1, value2, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andJldwmcNotBetween(String value1, String value2) {
            addCriterion("JLDWMC not between", value1, value2, "jldwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwbmIsNull() {
            addCriterion("SGDWBM is null");
            return (Criteria) this;
        }

        public Criteria andSgdwbmIsNotNull() {
            addCriterion("SGDWBM is not null");
            return (Criteria) this;
        }

        public Criteria andSgdwbmEqualTo(String value) {
            addCriterion("SGDWBM =", value, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmNotEqualTo(String value) {
            addCriterion("SGDWBM <>", value, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmGreaterThan(String value) {
            addCriterion("SGDWBM >", value, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmGreaterThanOrEqualTo(String value) {
            addCriterion("SGDWBM >=", value, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmLessThan(String value) {
            addCriterion("SGDWBM <", value, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmLessThanOrEqualTo(String value) {
            addCriterion("SGDWBM <=", value, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmLike(String value) {
            addCriterion("SGDWBM like", value, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmNotLike(String value) {
            addCriterion("SGDWBM not like", value, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmIn(List<String> values) {
            addCriterion("SGDWBM in", values, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmNotIn(List<String> values) {
            addCriterion("SGDWBM not in", values, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmBetween(String value1, String value2) {
            addCriterion("SGDWBM between", value1, value2, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwbmNotBetween(String value1, String value2) {
            addCriterion("SGDWBM not between", value1, value2, "sgdwbm");
            return (Criteria) this;
        }

        public Criteria andSgdwmcIsNull() {
            addCriterion("SGDWMC is null");
            return (Criteria) this;
        }

        public Criteria andSgdwmcIsNotNull() {
            addCriterion("SGDWMC is not null");
            return (Criteria) this;
        }

        public Criteria andSgdwmcEqualTo(String value) {
            addCriterion("SGDWMC =", value, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcNotEqualTo(String value) {
            addCriterion("SGDWMC <>", value, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcGreaterThan(String value) {
            addCriterion("SGDWMC >", value, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcGreaterThanOrEqualTo(String value) {
            addCriterion("SGDWMC >=", value, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcLessThan(String value) {
            addCriterion("SGDWMC <", value, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcLessThanOrEqualTo(String value) {
            addCriterion("SGDWMC <=", value, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcLike(String value) {
            addCriterion("SGDWMC like", value, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcNotLike(String value) {
            addCriterion("SGDWMC not like", value, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcIn(List<String> values) {
            addCriterion("SGDWMC in", values, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcNotIn(List<String> values) {
            addCriterion("SGDWMC not in", values, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcBetween(String value1, String value2) {
            addCriterion("SGDWMC between", value1, value2, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andSgdwmcNotBetween(String value1, String value2) {
            addCriterion("SGDWMC not between", value1, value2, "sgdwmc");
            return (Criteria) this;
        }

        public Criteria andXmfbbmIsNull() {
            addCriterion("XMFBBM is null");
            return (Criteria) this;
        }

        public Criteria andXmfbbmIsNotNull() {
            addCriterion("XMFBBM is not null");
            return (Criteria) this;
        }

        public Criteria andXmfbbmEqualTo(String value) {
            addCriterion("XMFBBM =", value, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmNotEqualTo(String value) {
            addCriterion("XMFBBM <>", value, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmGreaterThan(String value) {
            addCriterion("XMFBBM >", value, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmGreaterThanOrEqualTo(String value) {
            addCriterion("XMFBBM >=", value, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmLessThan(String value) {
            addCriterion("XMFBBM <", value, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmLessThanOrEqualTo(String value) {
            addCriterion("XMFBBM <=", value, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmLike(String value) {
            addCriterion("XMFBBM like", value, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmNotLike(String value) {
            addCriterion("XMFBBM not like", value, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmIn(List<String> values) {
            addCriterion("XMFBBM in", values, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmNotIn(List<String> values) {
            addCriterion("XMFBBM not in", values, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmBetween(String value1, String value2) {
            addCriterion("XMFBBM between", value1, value2, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbbmNotBetween(String value1, String value2) {
            addCriterion("XMFBBM not between", value1, value2, "xmfbbm");
            return (Criteria) this;
        }

        public Criteria andXmfbmcIsNull() {
            addCriterion("XMFBMC is null");
            return (Criteria) this;
        }

        public Criteria andXmfbmcIsNotNull() {
            addCriterion("XMFBMC is not null");
            return (Criteria) this;
        }

        public Criteria andXmfbmcEqualTo(String value) {
            addCriterion("XMFBMC =", value, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcNotEqualTo(String value) {
            addCriterion("XMFBMC <>", value, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcGreaterThan(String value) {
            addCriterion("XMFBMC >", value, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcGreaterThanOrEqualTo(String value) {
            addCriterion("XMFBMC >=", value, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcLessThan(String value) {
            addCriterion("XMFBMC <", value, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcLessThanOrEqualTo(String value) {
            addCriterion("XMFBMC <=", value, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcLike(String value) {
            addCriterion("XMFBMC like", value, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcNotLike(String value) {
            addCriterion("XMFBMC not like", value, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcIn(List<String> values) {
            addCriterion("XMFBMC in", values, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcNotIn(List<String> values) {
            addCriterion("XMFBMC not in", values, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcBetween(String value1, String value2) {
            addCriterion("XMFBMC between", value1, value2, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andXmfbmcNotBetween(String value1, String value2) {
            addCriterion("XMFBMC not between", value1, value2, "xmfbmc");
            return (Criteria) this;
        }

        public Criteria andZhxgrIsNull() {
            addCriterion("ZHXGR is null");
            return (Criteria) this;
        }

        public Criteria andZhxgrIsNotNull() {
            addCriterion("ZHXGR is not null");
            return (Criteria) this;
        }

        public Criteria andZhxgrEqualTo(String value) {
            addCriterion("ZHXGR =", value, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrNotEqualTo(String value) {
            addCriterion("ZHXGR <>", value, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrGreaterThan(String value) {
            addCriterion("ZHXGR >", value, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrGreaterThanOrEqualTo(String value) {
            addCriterion("ZHXGR >=", value, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrLessThan(String value) {
            addCriterion("ZHXGR <", value, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrLessThanOrEqualTo(String value) {
            addCriterion("ZHXGR <=", value, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrLike(String value) {
            addCriterion("ZHXGR like", value, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrNotLike(String value) {
            addCriterion("ZHXGR not like", value, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrIn(List<String> values) {
            addCriterion("ZHXGR in", values, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrNotIn(List<String> values) {
            addCriterion("ZHXGR not in", values, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrBetween(String value1, String value2) {
            addCriterion("ZHXGR between", value1, value2, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andZhxgrNotBetween(String value1, String value2) {
            addCriterion("ZHXGR not between", value1, value2, "zhxgr");
            return (Criteria) this;
        }

        public Criteria andJldwidIsNull() {
            addCriterion("JLDWID is null");
            return (Criteria) this;
        }

        public Criteria andJldwidIsNotNull() {
            addCriterion("JLDWID is not null");
            return (Criteria) this;
        }

        public Criteria andJldwidEqualTo(String value) {
            addCriterion("JLDWID =", value, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidNotEqualTo(String value) {
            addCriterion("JLDWID <>", value, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidGreaterThan(String value) {
            addCriterion("JLDWID >", value, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidGreaterThanOrEqualTo(String value) {
            addCriterion("JLDWID >=", value, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidLessThan(String value) {
            addCriterion("JLDWID <", value, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidLessThanOrEqualTo(String value) {
            addCriterion("JLDWID <=", value, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidLike(String value) {
            addCriterion("JLDWID like", value, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidNotLike(String value) {
            addCriterion("JLDWID not like", value, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidIn(List<String> values) {
            addCriterion("JLDWID in", values, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidNotIn(List<String> values) {
            addCriterion("JLDWID not in", values, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidBetween(String value1, String value2) {
            addCriterion("JLDWID between", value1, value2, "jldwid");
            return (Criteria) this;
        }

        public Criteria andJldwidNotBetween(String value1, String value2) {
            addCriterion("JLDWID not between", value1, value2, "jldwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidIsNull() {
            addCriterion("SGDWID is null");
            return (Criteria) this;
        }

        public Criteria andSgdwidIsNotNull() {
            addCriterion("SGDWID is not null");
            return (Criteria) this;
        }

        public Criteria andSgdwidEqualTo(String value) {
            addCriterion("SGDWID =", value, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidNotEqualTo(String value) {
            addCriterion("SGDWID <>", value, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidGreaterThan(String value) {
            addCriterion("SGDWID >", value, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidGreaterThanOrEqualTo(String value) {
            addCriterion("SGDWID >=", value, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidLessThan(String value) {
            addCriterion("SGDWID <", value, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidLessThanOrEqualTo(String value) {
            addCriterion("SGDWID <=", value, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidLike(String value) {
            addCriterion("SGDWID like", value, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidNotLike(String value) {
            addCriterion("SGDWID not like", value, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidIn(List<String> values) {
            addCriterion("SGDWID in", values, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidNotIn(List<String> values) {
            addCriterion("SGDWID not in", values, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidBetween(String value1, String value2) {
            addCriterion("SGDWID between", value1, value2, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andSgdwidNotBetween(String value1, String value2) {
            addCriterion("SGDWID not between", value1, value2, "sgdwid");
            return (Criteria) this;
        }

        public Criteria andXmfbidIsNull() {
            addCriterion("XMFBID is null");
            return (Criteria) this;
        }

        public Criteria andXmfbidIsNotNull() {
            addCriterion("XMFBID is not null");
            return (Criteria) this;
        }

        public Criteria andXmfbidEqualTo(String value) {
            addCriterion("XMFBID =", value, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidNotEqualTo(String value) {
            addCriterion("XMFBID <>", value, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidGreaterThan(String value) {
            addCriterion("XMFBID >", value, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidGreaterThanOrEqualTo(String value) {
            addCriterion("XMFBID >=", value, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidLessThan(String value) {
            addCriterion("XMFBID <", value, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidLessThanOrEqualTo(String value) {
            addCriterion("XMFBID <=", value, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidLike(String value) {
            addCriterion("XMFBID like", value, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidNotLike(String value) {
            addCriterion("XMFBID not like", value, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidIn(List<String> values) {
            addCriterion("XMFBID in", values, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidNotIn(List<String> values) {
            addCriterion("XMFBID not in", values, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidBetween(String value1, String value2) {
            addCriterion("XMFBID between", value1, value2, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andXmfbidNotBetween(String value1, String value2) {
            addCriterion("XMFBID not between", value1, value2, "xmfbid");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcIsNull() {
            addCriterion("ZCBDWMC is null");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcIsNotNull() {
            addCriterion("ZCBDWMC is not null");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcEqualTo(String value) {
            addCriterion("ZCBDWMC =", value, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcNotEqualTo(String value) {
            addCriterion("ZCBDWMC <>", value, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcGreaterThan(String value) {
            addCriterion("ZCBDWMC >", value, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcGreaterThanOrEqualTo(String value) {
            addCriterion("ZCBDWMC >=", value, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcLessThan(String value) {
            addCriterion("ZCBDWMC <", value, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcLessThanOrEqualTo(String value) {
            addCriterion("ZCBDWMC <=", value, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcLike(String value) {
            addCriterion("ZCBDWMC like", value, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcNotLike(String value) {
            addCriterion("ZCBDWMC not like", value, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcIn(List<String> values) {
            addCriterion("ZCBDWMC in", values, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcNotIn(List<String> values) {
            addCriterion("ZCBDWMC not in", values, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcBetween(String value1, String value2) {
            addCriterion("ZCBDWMC between", value1, value2, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwmcNotBetween(String value1, String value2) {
            addCriterion("ZCBDWMC not between", value1, value2, "zcbdwmc");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmIsNull() {
            addCriterion("ZCBDWBM is null");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmIsNotNull() {
            addCriterion("ZCBDWBM is not null");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmEqualTo(String value) {
            addCriterion("ZCBDWBM =", value, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmNotEqualTo(String value) {
            addCriterion("ZCBDWBM <>", value, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmGreaterThan(String value) {
            addCriterion("ZCBDWBM >", value, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmGreaterThanOrEqualTo(String value) {
            addCriterion("ZCBDWBM >=", value, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmLessThan(String value) {
            addCriterion("ZCBDWBM <", value, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmLessThanOrEqualTo(String value) {
            addCriterion("ZCBDWBM <=", value, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmLike(String value) {
            addCriterion("ZCBDWBM like", value, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmNotLike(String value) {
            addCriterion("ZCBDWBM not like", value, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmIn(List<String> values) {
            addCriterion("ZCBDWBM in", values, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmNotIn(List<String> values) {
            addCriterion("ZCBDWBM not in", values, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmBetween(String value1, String value2) {
            addCriterion("ZCBDWBM between", value1, value2, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwbmNotBetween(String value1, String value2) {
            addCriterion("ZCBDWBM not between", value1, value2, "zcbdwbm");
            return (Criteria) this;
        }

        public Criteria andZcbdwidIsNull() {
            addCriterion("ZCBDWID is null");
            return (Criteria) this;
        }

        public Criteria andZcbdwidIsNotNull() {
            addCriterion("ZCBDWID is not null");
            return (Criteria) this;
        }

        public Criteria andZcbdwidEqualTo(String value) {
            addCriterion("ZCBDWID =", value, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidNotEqualTo(String value) {
            addCriterion("ZCBDWID <>", value, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidGreaterThan(String value) {
            addCriterion("ZCBDWID >", value, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidGreaterThanOrEqualTo(String value) {
            addCriterion("ZCBDWID >=", value, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidLessThan(String value) {
            addCriterion("ZCBDWID <", value, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidLessThanOrEqualTo(String value) {
            addCriterion("ZCBDWID <=", value, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidLike(String value) {
            addCriterion("ZCBDWID like", value, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidNotLike(String value) {
            addCriterion("ZCBDWID not like", value, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidIn(List<String> values) {
            addCriterion("ZCBDWID in", values, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidNotIn(List<String> values) {
            addCriterion("ZCBDWID not in", values, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidBetween(String value1, String value2) {
            addCriterion("ZCBDWID between", value1, value2, "zcbdwid");
            return (Criteria) this;
        }

        public Criteria andZcbdwidNotBetween(String value1, String value2) {
            addCriterion("ZCBDWID not between", value1, value2, "zcbdwid");
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