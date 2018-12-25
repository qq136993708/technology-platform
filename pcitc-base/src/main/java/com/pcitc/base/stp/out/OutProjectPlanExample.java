package com.pcitc.base.stp.out;

import java.util.ArrayList;
import java.util.List;

public class OutProjectPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutProjectPlanExample() {
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

        public Criteria andNdIsNull() {
            addCriterion("ND is null");
            return (Criteria) this;
        }

        public Criteria andNdIsNotNull() {
            addCriterion("ND is not null");
            return (Criteria) this;
        }

        public Criteria andNdEqualTo(String value) {
            addCriterion("ND =", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotEqualTo(String value) {
            addCriterion("ND <>", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThan(String value) {
            addCriterion("ND >", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThanOrEqualTo(String value) {
            addCriterion("ND >=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThan(String value) {
            addCriterion("ND <", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThanOrEqualTo(String value) {
            addCriterion("ND <=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLike(String value) {
            addCriterion("ND like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotLike(String value) {
            addCriterion("ND not like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdIn(List<String> values) {
            addCriterion("ND in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotIn(List<String> values) {
            addCriterion("ND not in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdBetween(String value1, String value2) {
            addCriterion("ND between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotBetween(String value1, String value2) {
            addCriterion("ND not between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andHthIsNull() {
            addCriterion("HTH is null");
            return (Criteria) this;
        }

        public Criteria andHthIsNotNull() {
            addCriterion("HTH is not null");
            return (Criteria) this;
        }

        public Criteria andHthEqualTo(String value) {
            addCriterion("HTH =", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotEqualTo(String value) {
            addCriterion("HTH <>", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthGreaterThan(String value) {
            addCriterion("HTH >", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthGreaterThanOrEqualTo(String value) {
            addCriterion("HTH >=", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthLessThan(String value) {
            addCriterion("HTH <", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthLessThanOrEqualTo(String value) {
            addCriterion("HTH <=", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthLike(String value) {
            addCriterion("HTH like", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotLike(String value) {
            addCriterion("HTH not like", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthIn(List<String> values) {
            addCriterion("HTH in", values, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotIn(List<String> values) {
            addCriterion("HTH not in", values, "hth");
            return (Criteria) this;
        }

        public Criteria andHthBetween(String value1, String value2) {
            addCriterion("HTH between", value1, value2, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotBetween(String value1, String value2) {
            addCriterion("HTH not between", value1, value2, "hth");
            return (Criteria) this;
        }

        public Criteria andXmmcIsNull() {
            addCriterion("XMMC is null");
            return (Criteria) this;
        }

        public Criteria andXmmcIsNotNull() {
            addCriterion("XMMC is not null");
            return (Criteria) this;
        }

        public Criteria andXmmcEqualTo(String value) {
            addCriterion("XMMC =", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotEqualTo(String value) {
            addCriterion("XMMC <>", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcGreaterThan(String value) {
            addCriterion("XMMC >", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcGreaterThanOrEqualTo(String value) {
            addCriterion("XMMC >=", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcLessThan(String value) {
            addCriterion("XMMC <", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcLessThanOrEqualTo(String value) {
            addCriterion("XMMC <=", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcLike(String value) {
            addCriterion("XMMC like", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotLike(String value) {
            addCriterion("XMMC not like", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcIn(List<String> values) {
            addCriterion("XMMC in", values, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotIn(List<String> values) {
            addCriterion("XMMC not in", values, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcBetween(String value1, String value2) {
            addCriterion("XMMC between", value1, value2, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotBetween(String value1, String value2) {
            addCriterion("XMMC not between", value1, value2, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmjbIsNull() {
            addCriterion("XMJB is null");
            return (Criteria) this;
        }

        public Criteria andXmjbIsNotNull() {
            addCriterion("XMJB is not null");
            return (Criteria) this;
        }

        public Criteria andXmjbEqualTo(String value) {
            addCriterion("XMJB =", value, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbNotEqualTo(String value) {
            addCriterion("XMJB <>", value, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbGreaterThan(String value) {
            addCriterion("XMJB >", value, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbGreaterThanOrEqualTo(String value) {
            addCriterion("XMJB >=", value, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbLessThan(String value) {
            addCriterion("XMJB <", value, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbLessThanOrEqualTo(String value) {
            addCriterion("XMJB <=", value, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbLike(String value) {
            addCriterion("XMJB like", value, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbNotLike(String value) {
            addCriterion("XMJB not like", value, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbIn(List<String> values) {
            addCriterion("XMJB in", values, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbNotIn(List<String> values) {
            addCriterion("XMJB not in", values, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbBetween(String value1, String value2) {
            addCriterion("XMJB between", value1, value2, "xmjb");
            return (Criteria) this;
        }

        public Criteria andXmjbNotBetween(String value1, String value2) {
            addCriterion("XMJB not between", value1, value2, "xmjb");
            return (Criteria) this;
        }

        public Criteria andJfIsNull() {
            addCriterion("JF is null");
            return (Criteria) this;
        }

        public Criteria andJfIsNotNull() {
            addCriterion("JF is not null");
            return (Criteria) this;
        }

        public Criteria andJfEqualTo(String value) {
            addCriterion("JF =", value, "jf");
            return (Criteria) this;
        }

        public Criteria andJfNotEqualTo(String value) {
            addCriterion("JF <>", value, "jf");
            return (Criteria) this;
        }

        public Criteria andJfGreaterThan(String value) {
            addCriterion("JF >", value, "jf");
            return (Criteria) this;
        }

        public Criteria andJfGreaterThanOrEqualTo(String value) {
            addCriterion("JF >=", value, "jf");
            return (Criteria) this;
        }

        public Criteria andJfLessThan(String value) {
            addCriterion("JF <", value, "jf");
            return (Criteria) this;
        }

        public Criteria andJfLessThanOrEqualTo(String value) {
            addCriterion("JF <=", value, "jf");
            return (Criteria) this;
        }

        public Criteria andJfLike(String value) {
            addCriterion("JF like", value, "jf");
            return (Criteria) this;
        }

        public Criteria andJfNotLike(String value) {
            addCriterion("JF not like", value, "jf");
            return (Criteria) this;
        }

        public Criteria andJfIn(List<String> values) {
            addCriterion("JF in", values, "jf");
            return (Criteria) this;
        }

        public Criteria andJfNotIn(List<String> values) {
            addCriterion("JF not in", values, "jf");
            return (Criteria) this;
        }

        public Criteria andJfBetween(String value1, String value2) {
            addCriterion("JF between", value1, value2, "jf");
            return (Criteria) this;
        }

        public Criteria andJfNotBetween(String value1, String value2) {
            addCriterion("JF not between", value1, value2, "jf");
            return (Criteria) this;
        }

        public Criteria andFwdxbmIsNull() {
            addCriterion("FWDXBM is null");
            return (Criteria) this;
        }

        public Criteria andFwdxbmIsNotNull() {
            addCriterion("FWDXBM is not null");
            return (Criteria) this;
        }

        public Criteria andFwdxbmEqualTo(String value) {
            addCriterion("FWDXBM =", value, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmNotEqualTo(String value) {
            addCriterion("FWDXBM <>", value, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmGreaterThan(String value) {
            addCriterion("FWDXBM >", value, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmGreaterThanOrEqualTo(String value) {
            addCriterion("FWDXBM >=", value, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmLessThan(String value) {
            addCriterion("FWDXBM <", value, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmLessThanOrEqualTo(String value) {
            addCriterion("FWDXBM <=", value, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmLike(String value) {
            addCriterion("FWDXBM like", value, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmNotLike(String value) {
            addCriterion("FWDXBM not like", value, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmIn(List<String> values) {
            addCriterion("FWDXBM in", values, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmNotIn(List<String> values) {
            addCriterion("FWDXBM not in", values, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmBetween(String value1, String value2) {
            addCriterion("FWDXBM between", value1, value2, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxbmNotBetween(String value1, String value2) {
            addCriterion("FWDXBM not between", value1, value2, "fwdxbm");
            return (Criteria) this;
        }

        public Criteria andFwdxIsNull() {
            addCriterion("FWDX is null");
            return (Criteria) this;
        }

        public Criteria andFwdxIsNotNull() {
            addCriterion("FWDX is not null");
            return (Criteria) this;
        }

        public Criteria andFwdxEqualTo(String value) {
            addCriterion("FWDX =", value, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxNotEqualTo(String value) {
            addCriterion("FWDX <>", value, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxGreaterThan(String value) {
            addCriterion("FWDX >", value, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxGreaterThanOrEqualTo(String value) {
            addCriterion("FWDX >=", value, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxLessThan(String value) {
            addCriterion("FWDX <", value, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxLessThanOrEqualTo(String value) {
            addCriterion("FWDX <=", value, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxLike(String value) {
            addCriterion("FWDX like", value, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxNotLike(String value) {
            addCriterion("FWDX not like", value, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxIn(List<String> values) {
            addCriterion("FWDX in", values, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxNotIn(List<String> values) {
            addCriterion("FWDX not in", values, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxBetween(String value1, String value2) {
            addCriterion("FWDX between", value1, value2, "fwdx");
            return (Criteria) this;
        }

        public Criteria andFwdxNotBetween(String value1, String value2) {
            addCriterion("FWDX not between", value1, value2, "fwdx");
            return (Criteria) this;
        }

        public Criteria andGsbmbmIsNull() {
            addCriterion("GSBMBM is null");
            return (Criteria) this;
        }

        public Criteria andGsbmbmIsNotNull() {
            addCriterion("GSBMBM is not null");
            return (Criteria) this;
        }

        public Criteria andGsbmbmEqualTo(String value) {
            addCriterion("GSBMBM =", value, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmNotEqualTo(String value) {
            addCriterion("GSBMBM <>", value, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmGreaterThan(String value) {
            addCriterion("GSBMBM >", value, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmGreaterThanOrEqualTo(String value) {
            addCriterion("GSBMBM >=", value, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmLessThan(String value) {
            addCriterion("GSBMBM <", value, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmLessThanOrEqualTo(String value) {
            addCriterion("GSBMBM <=", value, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmLike(String value) {
            addCriterion("GSBMBM like", value, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmNotLike(String value) {
            addCriterion("GSBMBM not like", value, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmIn(List<String> values) {
            addCriterion("GSBMBM in", values, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmNotIn(List<String> values) {
            addCriterion("GSBMBM not in", values, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmBetween(String value1, String value2) {
            addCriterion("GSBMBM between", value1, value2, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmbmNotBetween(String value1, String value2) {
            addCriterion("GSBMBM not between", value1, value2, "gsbmbm");
            return (Criteria) this;
        }

        public Criteria andGsbmmcIsNull() {
            addCriterion("GSBMMC is null");
            return (Criteria) this;
        }

        public Criteria andGsbmmcIsNotNull() {
            addCriterion("GSBMMC is not null");
            return (Criteria) this;
        }

        public Criteria andGsbmmcEqualTo(String value) {
            addCriterion("GSBMMC =", value, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcNotEqualTo(String value) {
            addCriterion("GSBMMC <>", value, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcGreaterThan(String value) {
            addCriterion("GSBMMC >", value, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcGreaterThanOrEqualTo(String value) {
            addCriterion("GSBMMC >=", value, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcLessThan(String value) {
            addCriterion("GSBMMC <", value, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcLessThanOrEqualTo(String value) {
            addCriterion("GSBMMC <=", value, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcLike(String value) {
            addCriterion("GSBMMC like", value, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcNotLike(String value) {
            addCriterion("GSBMMC not like", value, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcIn(List<String> values) {
            addCriterion("GSBMMC in", values, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcNotIn(List<String> values) {
            addCriterion("GSBMMC not in", values, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcBetween(String value1, String value2) {
            addCriterion("GSBMMC between", value1, value2, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andGsbmmcNotBetween(String value1, String value2) {
            addCriterion("GSBMMC not between", value1, value2, "gsbmmc");
            return (Criteria) this;
        }

        public Criteria andZycbmIsNull() {
            addCriterion("ZYCBM is null");
            return (Criteria) this;
        }

        public Criteria andZycbmIsNotNull() {
            addCriterion("ZYCBM is not null");
            return (Criteria) this;
        }

        public Criteria andZycbmEqualTo(String value) {
            addCriterion("ZYCBM =", value, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmNotEqualTo(String value) {
            addCriterion("ZYCBM <>", value, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmGreaterThan(String value) {
            addCriterion("ZYCBM >", value, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmGreaterThanOrEqualTo(String value) {
            addCriterion("ZYCBM >=", value, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmLessThan(String value) {
            addCriterion("ZYCBM <", value, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmLessThanOrEqualTo(String value) {
            addCriterion("ZYCBM <=", value, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmLike(String value) {
            addCriterion("ZYCBM like", value, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmNotLike(String value) {
            addCriterion("ZYCBM not like", value, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmIn(List<String> values) {
            addCriterion("ZYCBM in", values, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmNotIn(List<String> values) {
            addCriterion("ZYCBM not in", values, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmBetween(String value1, String value2) {
            addCriterion("ZYCBM between", value1, value2, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycbmNotBetween(String value1, String value2) {
            addCriterion("ZYCBM not between", value1, value2, "zycbm");
            return (Criteria) this;
        }

        public Criteria andZycmcIsNull() {
            addCriterion("ZYCMC is null");
            return (Criteria) this;
        }

        public Criteria andZycmcIsNotNull() {
            addCriterion("ZYCMC is not null");
            return (Criteria) this;
        }

        public Criteria andZycmcEqualTo(String value) {
            addCriterion("ZYCMC =", value, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcNotEqualTo(String value) {
            addCriterion("ZYCMC <>", value, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcGreaterThan(String value) {
            addCriterion("ZYCMC >", value, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcGreaterThanOrEqualTo(String value) {
            addCriterion("ZYCMC >=", value, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcLessThan(String value) {
            addCriterion("ZYCMC <", value, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcLessThanOrEqualTo(String value) {
            addCriterion("ZYCMC <=", value, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcLike(String value) {
            addCriterion("ZYCMC like", value, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcNotLike(String value) {
            addCriterion("ZYCMC not like", value, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcIn(List<String> values) {
            addCriterion("ZYCMC in", values, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcNotIn(List<String> values) {
            addCriterion("ZYCMC not in", values, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcBetween(String value1, String value2) {
            addCriterion("ZYCMC between", value1, value2, "zycmc");
            return (Criteria) this;
        }

        public Criteria andZycmcNotBetween(String value1, String value2) {
            addCriterion("ZYCMC not between", value1, value2, "zycmc");
            return (Criteria) this;
        }

        public Criteria andXmlbbmIsNull() {
            addCriterion("XMLBBM is null");
            return (Criteria) this;
        }

        public Criteria andXmlbbmIsNotNull() {
            addCriterion("XMLBBM is not null");
            return (Criteria) this;
        }

        public Criteria andXmlbbmEqualTo(String value) {
            addCriterion("XMLBBM =", value, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmNotEqualTo(String value) {
            addCriterion("XMLBBM <>", value, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmGreaterThan(String value) {
            addCriterion("XMLBBM >", value, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmGreaterThanOrEqualTo(String value) {
            addCriterion("XMLBBM >=", value, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmLessThan(String value) {
            addCriterion("XMLBBM <", value, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmLessThanOrEqualTo(String value) {
            addCriterion("XMLBBM <=", value, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmLike(String value) {
            addCriterion("XMLBBM like", value, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmNotLike(String value) {
            addCriterion("XMLBBM not like", value, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmIn(List<String> values) {
            addCriterion("XMLBBM in", values, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmNotIn(List<String> values) {
            addCriterion("XMLBBM not in", values, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmBetween(String value1, String value2) {
            addCriterion("XMLBBM between", value1, value2, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbbmNotBetween(String value1, String value2) {
            addCriterion("XMLBBM not between", value1, value2, "xmlbbm");
            return (Criteria) this;
        }

        public Criteria andXmlbmcIsNull() {
            addCriterion("XMLBMC is null");
            return (Criteria) this;
        }

        public Criteria andXmlbmcIsNotNull() {
            addCriterion("XMLBMC is not null");
            return (Criteria) this;
        }

        public Criteria andXmlbmcEqualTo(String value) {
            addCriterion("XMLBMC =", value, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcNotEqualTo(String value) {
            addCriterion("XMLBMC <>", value, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcGreaterThan(String value) {
            addCriterion("XMLBMC >", value, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcGreaterThanOrEqualTo(String value) {
            addCriterion("XMLBMC >=", value, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcLessThan(String value) {
            addCriterion("XMLBMC <", value, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcLessThanOrEqualTo(String value) {
            addCriterion("XMLBMC <=", value, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcLike(String value) {
            addCriterion("XMLBMC like", value, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcNotLike(String value) {
            addCriterion("XMLBMC not like", value, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcIn(List<String> values) {
            addCriterion("XMLBMC in", values, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcNotIn(List<String> values) {
            addCriterion("XMLBMC not in", values, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcBetween(String value1, String value2) {
            addCriterion("XMLBMC between", value1, value2, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andXmlbmcNotBetween(String value1, String value2) {
            addCriterion("XMLBMC not between", value1, value2, "xmlbmc");
            return (Criteria) this;
        }

        public Criteria andZylbbmIsNull() {
            addCriterion("ZYLBBM is null");
            return (Criteria) this;
        }

        public Criteria andZylbbmIsNotNull() {
            addCriterion("ZYLBBM is not null");
            return (Criteria) this;
        }

        public Criteria andZylbbmEqualTo(String value) {
            addCriterion("ZYLBBM =", value, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmNotEqualTo(String value) {
            addCriterion("ZYLBBM <>", value, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmGreaterThan(String value) {
            addCriterion("ZYLBBM >", value, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmGreaterThanOrEqualTo(String value) {
            addCriterion("ZYLBBM >=", value, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmLessThan(String value) {
            addCriterion("ZYLBBM <", value, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmLessThanOrEqualTo(String value) {
            addCriterion("ZYLBBM <=", value, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmLike(String value) {
            addCriterion("ZYLBBM like", value, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmNotLike(String value) {
            addCriterion("ZYLBBM not like", value, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmIn(List<String> values) {
            addCriterion("ZYLBBM in", values, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmNotIn(List<String> values) {
            addCriterion("ZYLBBM not in", values, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmBetween(String value1, String value2) {
            addCriterion("ZYLBBM between", value1, value2, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbbmNotBetween(String value1, String value2) {
            addCriterion("ZYLBBM not between", value1, value2, "zylbbm");
            return (Criteria) this;
        }

        public Criteria andZylbIsNull() {
            addCriterion("ZYLB is null");
            return (Criteria) this;
        }

        public Criteria andZylbIsNotNull() {
            addCriterion("ZYLB is not null");
            return (Criteria) this;
        }

        public Criteria andZylbEqualTo(String value) {
            addCriterion("ZYLB =", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbNotEqualTo(String value) {
            addCriterion("ZYLB <>", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbGreaterThan(String value) {
            addCriterion("ZYLB >", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbGreaterThanOrEqualTo(String value) {
            addCriterion("ZYLB >=", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbLessThan(String value) {
            addCriterion("ZYLB <", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbLessThanOrEqualTo(String value) {
            addCriterion("ZYLB <=", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbLike(String value) {
            addCriterion("ZYLB like", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbNotLike(String value) {
            addCriterion("ZYLB not like", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbIn(List<String> values) {
            addCriterion("ZYLB in", values, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbNotIn(List<String> values) {
            addCriterion("ZYLB not in", values, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbBetween(String value1, String value2) {
            addCriterion("ZYLB between", value1, value2, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbNotBetween(String value1, String value2) {
            addCriterion("ZYLB not between", value1, value2, "zylb");
            return (Criteria) this;
        }

        public Criteria andFzdwbmIsNull() {
            addCriterion("FZDWBM is null");
            return (Criteria) this;
        }

        public Criteria andFzdwbmIsNotNull() {
            addCriterion("FZDWBM is not null");
            return (Criteria) this;
        }

        public Criteria andFzdwbmEqualTo(String value) {
            addCriterion("FZDWBM =", value, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmNotEqualTo(String value) {
            addCriterion("FZDWBM <>", value, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmGreaterThan(String value) {
            addCriterion("FZDWBM >", value, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmGreaterThanOrEqualTo(String value) {
            addCriterion("FZDWBM >=", value, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmLessThan(String value) {
            addCriterion("FZDWBM <", value, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmLessThanOrEqualTo(String value) {
            addCriterion("FZDWBM <=", value, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmLike(String value) {
            addCriterion("FZDWBM like", value, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmNotLike(String value) {
            addCriterion("FZDWBM not like", value, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmIn(List<String> values) {
            addCriterion("FZDWBM in", values, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmNotIn(List<String> values) {
            addCriterion("FZDWBM not in", values, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmBetween(String value1, String value2) {
            addCriterion("FZDWBM between", value1, value2, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwbmNotBetween(String value1, String value2) {
            addCriterion("FZDWBM not between", value1, value2, "fzdwbm");
            return (Criteria) this;
        }

        public Criteria andFzdwIsNull() {
            addCriterion("FZDW is null");
            return (Criteria) this;
        }

        public Criteria andFzdwIsNotNull() {
            addCriterion("FZDW is not null");
            return (Criteria) this;
        }

        public Criteria andFzdwEqualTo(String value) {
            addCriterion("FZDW =", value, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwNotEqualTo(String value) {
            addCriterion("FZDW <>", value, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwGreaterThan(String value) {
            addCriterion("FZDW >", value, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwGreaterThanOrEqualTo(String value) {
            addCriterion("FZDW >=", value, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwLessThan(String value) {
            addCriterion("FZDW <", value, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwLessThanOrEqualTo(String value) {
            addCriterion("FZDW <=", value, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwLike(String value) {
            addCriterion("FZDW like", value, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwNotLike(String value) {
            addCriterion("FZDW not like", value, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwIn(List<String> values) {
            addCriterion("FZDW in", values, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwNotIn(List<String> values) {
            addCriterion("FZDW not in", values, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwBetween(String value1, String value2) {
            addCriterion("FZDW between", value1, value2, "fzdw");
            return (Criteria) this;
        }

        public Criteria andFzdwNotBetween(String value1, String value2) {
            addCriterion("FZDW not between", value1, value2, "fzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmIsNull() {
            addCriterion("JTFZDWBM is null");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmIsNotNull() {
            addCriterion("JTFZDWBM is not null");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmEqualTo(String value) {
            addCriterion("JTFZDWBM =", value, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmNotEqualTo(String value) {
            addCriterion("JTFZDWBM <>", value, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmGreaterThan(String value) {
            addCriterion("JTFZDWBM >", value, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmGreaterThanOrEqualTo(String value) {
            addCriterion("JTFZDWBM >=", value, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmLessThan(String value) {
            addCriterion("JTFZDWBM <", value, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmLessThanOrEqualTo(String value) {
            addCriterion("JTFZDWBM <=", value, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmLike(String value) {
            addCriterion("JTFZDWBM like", value, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmNotLike(String value) {
            addCriterion("JTFZDWBM not like", value, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmIn(List<String> values) {
            addCriterion("JTFZDWBM in", values, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmNotIn(List<String> values) {
            addCriterion("JTFZDWBM not in", values, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmBetween(String value1, String value2) {
            addCriterion("JTFZDWBM between", value1, value2, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwbmNotBetween(String value1, String value2) {
            addCriterion("JTFZDWBM not between", value1, value2, "jtfzdwbm");
            return (Criteria) this;
        }

        public Criteria andJtfzdwIsNull() {
            addCriterion("JTFZDW is null");
            return (Criteria) this;
        }

        public Criteria andJtfzdwIsNotNull() {
            addCriterion("JTFZDW is not null");
            return (Criteria) this;
        }

        public Criteria andJtfzdwEqualTo(String value) {
            addCriterion("JTFZDW =", value, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwNotEqualTo(String value) {
            addCriterion("JTFZDW <>", value, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwGreaterThan(String value) {
            addCriterion("JTFZDW >", value, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwGreaterThanOrEqualTo(String value) {
            addCriterion("JTFZDW >=", value, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwLessThan(String value) {
            addCriterion("JTFZDW <", value, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwLessThanOrEqualTo(String value) {
            addCriterion("JTFZDW <=", value, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwLike(String value) {
            addCriterion("JTFZDW like", value, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwNotLike(String value) {
            addCriterion("JTFZDW not like", value, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwIn(List<String> values) {
            addCriterion("JTFZDW in", values, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwNotIn(List<String> values) {
            addCriterion("JTFZDW not in", values, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwBetween(String value1, String value2) {
            addCriterion("JTFZDW between", value1, value2, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andJtfzdwNotBetween(String value1, String value2) {
            addCriterion("JTFZDW not between", value1, value2, "jtfzdw");
            return (Criteria) this;
        }

        public Criteria andFzryxIsNull() {
            addCriterion("FZRYX is null");
            return (Criteria) this;
        }

        public Criteria andFzryxIsNotNull() {
            addCriterion("FZRYX is not null");
            return (Criteria) this;
        }

        public Criteria andFzryxEqualTo(String value) {
            addCriterion("FZRYX =", value, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxNotEqualTo(String value) {
            addCriterion("FZRYX <>", value, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxGreaterThan(String value) {
            addCriterion("FZRYX >", value, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxGreaterThanOrEqualTo(String value) {
            addCriterion("FZRYX >=", value, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxLessThan(String value) {
            addCriterion("FZRYX <", value, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxLessThanOrEqualTo(String value) {
            addCriterion("FZRYX <=", value, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxLike(String value) {
            addCriterion("FZRYX like", value, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxNotLike(String value) {
            addCriterion("FZRYX not like", value, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxIn(List<String> values) {
            addCriterion("FZRYX in", values, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxNotIn(List<String> values) {
            addCriterion("FZRYX not in", values, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxBetween(String value1, String value2) {
            addCriterion("FZRYX between", value1, value2, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzryxNotBetween(String value1, String value2) {
            addCriterion("FZRYX not between", value1, value2, "fzryx");
            return (Criteria) this;
        }

        public Criteria andFzrdhIsNull() {
            addCriterion("FZRDH is null");
            return (Criteria) this;
        }

        public Criteria andFzrdhIsNotNull() {
            addCriterion("FZRDH is not null");
            return (Criteria) this;
        }

        public Criteria andFzrdhEqualTo(String value) {
            addCriterion("FZRDH =", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhNotEqualTo(String value) {
            addCriterion("FZRDH <>", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhGreaterThan(String value) {
            addCriterion("FZRDH >", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhGreaterThanOrEqualTo(String value) {
            addCriterion("FZRDH >=", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhLessThan(String value) {
            addCriterion("FZRDH <", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhLessThanOrEqualTo(String value) {
            addCriterion("FZRDH <=", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhLike(String value) {
            addCriterion("FZRDH like", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhNotLike(String value) {
            addCriterion("FZRDH not like", value, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhIn(List<String> values) {
            addCriterion("FZRDH in", values, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhNotIn(List<String> values) {
            addCriterion("FZRDH not in", values, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhBetween(String value1, String value2) {
            addCriterion("FZRDH between", value1, value2, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrdhNotBetween(String value1, String value2) {
            addCriterion("FZRDH not between", value1, value2, "fzrdh");
            return (Criteria) this;
        }

        public Criteria andFzrxmIsNull() {
            addCriterion("FZRXM is null");
            return (Criteria) this;
        }

        public Criteria andFzrxmIsNotNull() {
            addCriterion("FZRXM is not null");
            return (Criteria) this;
        }

        public Criteria andFzrxmEqualTo(String value) {
            addCriterion("FZRXM =", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmNotEqualTo(String value) {
            addCriterion("FZRXM <>", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmGreaterThan(String value) {
            addCriterion("FZRXM >", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmGreaterThanOrEqualTo(String value) {
            addCriterion("FZRXM >=", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmLessThan(String value) {
            addCriterion("FZRXM <", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmLessThanOrEqualTo(String value) {
            addCriterion("FZRXM <=", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmLike(String value) {
            addCriterion("FZRXM like", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmNotLike(String value) {
            addCriterion("FZRXM not like", value, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmIn(List<String> values) {
            addCriterion("FZRXM in", values, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmNotIn(List<String> values) {
            addCriterion("FZRXM not in", values, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmBetween(String value1, String value2) {
            addCriterion("FZRXM between", value1, value2, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andFzrxmNotBetween(String value1, String value2) {
            addCriterion("FZRXM not between", value1, value2, "fzrxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmIsNull() {
            addCriterion("JSSXXM is null");
            return (Criteria) this;
        }

        public Criteria andJssxxmIsNotNull() {
            addCriterion("JSSXXM is not null");
            return (Criteria) this;
        }

        public Criteria andJssxxmEqualTo(String value) {
            addCriterion("JSSXXM =", value, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmNotEqualTo(String value) {
            addCriterion("JSSXXM <>", value, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmGreaterThan(String value) {
            addCriterion("JSSXXM >", value, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmGreaterThanOrEqualTo(String value) {
            addCriterion("JSSXXM >=", value, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmLessThan(String value) {
            addCriterion("JSSXXM <", value, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmLessThanOrEqualTo(String value) {
            addCriterion("JSSXXM <=", value, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmLike(String value) {
            addCriterion("JSSXXM like", value, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmNotLike(String value) {
            addCriterion("JSSXXM not like", value, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmIn(List<String> values) {
            addCriterion("JSSXXM in", values, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmNotIn(List<String> values) {
            addCriterion("JSSXXM not in", values, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmBetween(String value1, String value2) {
            addCriterion("JSSXXM between", value1, value2, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssxxmNotBetween(String value1, String value2) {
            addCriterion("JSSXXM not between", value1, value2, "jssxxm");
            return (Criteria) this;
        }

        public Criteria andJssjIsNull() {
            addCriterion("JSSJ is null");
            return (Criteria) this;
        }

        public Criteria andJssjIsNotNull() {
            addCriterion("JSSJ is not null");
            return (Criteria) this;
        }

        public Criteria andJssjEqualTo(String value) {
            addCriterion("JSSJ =", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotEqualTo(String value) {
            addCriterion("JSSJ <>", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjGreaterThan(String value) {
            addCriterion("JSSJ >", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjGreaterThanOrEqualTo(String value) {
            addCriterion("JSSJ >=", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLessThan(String value) {
            addCriterion("JSSJ <", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLessThanOrEqualTo(String value) {
            addCriterion("JSSJ <=", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLike(String value) {
            addCriterion("JSSJ like", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotLike(String value) {
            addCriterion("JSSJ not like", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjIn(List<String> values) {
            addCriterion("JSSJ in", values, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotIn(List<String> values) {
            addCriterion("JSSJ not in", values, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjBetween(String value1, String value2) {
            addCriterion("JSSJ between", value1, value2, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotBetween(String value1, String value2) {
            addCriterion("JSSJ not between", value1, value2, "jssj");
            return (Criteria) this;
        }

        public Criteria andKssjIsNull() {
            addCriterion("KSSJ is null");
            return (Criteria) this;
        }

        public Criteria andKssjIsNotNull() {
            addCriterion("KSSJ is not null");
            return (Criteria) this;
        }

        public Criteria andKssjEqualTo(String value) {
            addCriterion("KSSJ =", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotEqualTo(String value) {
            addCriterion("KSSJ <>", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjGreaterThan(String value) {
            addCriterion("KSSJ >", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjGreaterThanOrEqualTo(String value) {
            addCriterion("KSSJ >=", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjLessThan(String value) {
            addCriterion("KSSJ <", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjLessThanOrEqualTo(String value) {
            addCriterion("KSSJ <=", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjLike(String value) {
            addCriterion("KSSJ like", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotLike(String value) {
            addCriterion("KSSJ not like", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjIn(List<String> values) {
            addCriterion("KSSJ in", values, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotIn(List<String> values) {
            addCriterion("KSSJ not in", values, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjBetween(String value1, String value2) {
            addCriterion("KSSJ between", value1, value2, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotBetween(String value1, String value2) {
            addCriterion("KSSJ not between", value1, value2, "kssj");
            return (Criteria) this;
        }

        public Criteria andYjsjIsNull() {
            addCriterion("YJSJ is null");
            return (Criteria) this;
        }

        public Criteria andYjsjIsNotNull() {
            addCriterion("YJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andYjsjEqualTo(String value) {
            addCriterion("YJSJ =", value, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjNotEqualTo(String value) {
            addCriterion("YJSJ <>", value, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjGreaterThan(String value) {
            addCriterion("YJSJ >", value, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjGreaterThanOrEqualTo(String value) {
            addCriterion("YJSJ >=", value, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjLessThan(String value) {
            addCriterion("YJSJ <", value, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjLessThanOrEqualTo(String value) {
            addCriterion("YJSJ <=", value, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjLike(String value) {
            addCriterion("YJSJ like", value, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjNotLike(String value) {
            addCriterion("YJSJ not like", value, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjIn(List<String> values) {
            addCriterion("YJSJ in", values, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjNotIn(List<String> values) {
            addCriterion("YJSJ not in", values, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjBetween(String value1, String value2) {
            addCriterion("YJSJ between", value1, value2, "yjsj");
            return (Criteria) this;
        }

        public Criteria andYjsjNotBetween(String value1, String value2) {
            addCriterion("YJSJ not between", value1, value2, "yjsj");
            return (Criteria) this;
        }

        public Criteria andZylyIsNull() {
            addCriterion("ZYLY is null");
            return (Criteria) this;
        }

        public Criteria andZylyIsNotNull() {
            addCriterion("ZYLY is not null");
            return (Criteria) this;
        }

        public Criteria andZylyEqualTo(String value) {
            addCriterion("ZYLY =", value, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyNotEqualTo(String value) {
            addCriterion("ZYLY <>", value, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyGreaterThan(String value) {
            addCriterion("ZYLY >", value, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyGreaterThanOrEqualTo(String value) {
            addCriterion("ZYLY >=", value, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyLessThan(String value) {
            addCriterion("ZYLY <", value, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyLessThanOrEqualTo(String value) {
            addCriterion("ZYLY <=", value, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyLike(String value) {
            addCriterion("ZYLY like", value, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyNotLike(String value) {
            addCriterion("ZYLY not like", value, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyIn(List<String> values) {
            addCriterion("ZYLY in", values, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyNotIn(List<String> values) {
            addCriterion("ZYLY not in", values, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyBetween(String value1, String value2) {
            addCriterion("ZYLY between", value1, value2, "zyly");
            return (Criteria) this;
        }

        public Criteria andZylyNotBetween(String value1, String value2) {
            addCriterion("ZYLY not between", value1, value2, "zyly");
            return (Criteria) this;
        }

        public Criteria andZysxIsNull() {
            addCriterion("ZYSX is null");
            return (Criteria) this;
        }

        public Criteria andZysxIsNotNull() {
            addCriterion("ZYSX is not null");
            return (Criteria) this;
        }

        public Criteria andZysxEqualTo(String value) {
            addCriterion("ZYSX =", value, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxNotEqualTo(String value) {
            addCriterion("ZYSX <>", value, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxGreaterThan(String value) {
            addCriterion("ZYSX >", value, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxGreaterThanOrEqualTo(String value) {
            addCriterion("ZYSX >=", value, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxLessThan(String value) {
            addCriterion("ZYSX <", value, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxLessThanOrEqualTo(String value) {
            addCriterion("ZYSX <=", value, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxLike(String value) {
            addCriterion("ZYSX like", value, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxNotLike(String value) {
            addCriterion("ZYSX not like", value, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxIn(List<String> values) {
            addCriterion("ZYSX in", values, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxNotIn(List<String> values) {
            addCriterion("ZYSX not in", values, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxBetween(String value1, String value2) {
            addCriterion("ZYSX between", value1, value2, "zysx");
            return (Criteria) this;
        }

        public Criteria andZysxNotBetween(String value1, String value2) {
            addCriterion("ZYSX not between", value1, value2, "zysx");
            return (Criteria) this;
        }

        public Criteria andSjidIsNull() {
            addCriterion("SJID is null");
            return (Criteria) this;
        }

        public Criteria andSjidIsNotNull() {
            addCriterion("SJID is not null");
            return (Criteria) this;
        }

        public Criteria andSjidEqualTo(String value) {
            addCriterion("SJID =", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidNotEqualTo(String value) {
            addCriterion("SJID <>", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidGreaterThan(String value) {
            addCriterion("SJID >", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidGreaterThanOrEqualTo(String value) {
            addCriterion("SJID >=", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidLessThan(String value) {
            addCriterion("SJID <", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidLessThanOrEqualTo(String value) {
            addCriterion("SJID <=", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidLike(String value) {
            addCriterion("SJID like", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidNotLike(String value) {
            addCriterion("SJID not like", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidIn(List<String> values) {
            addCriterion("SJID in", values, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidNotIn(List<String> values) {
            addCriterion("SJID not in", values, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidBetween(String value1, String value2) {
            addCriterion("SJID between", value1, value2, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidNotBetween(String value1, String value2) {
            addCriterion("SJID not between", value1, value2, "sjid");
            return (Criteria) this;
        }

        public Criteria andLxbjIsNull() {
            addCriterion("LXBJ is null");
            return (Criteria) this;
        }

        public Criteria andLxbjIsNotNull() {
            addCriterion("LXBJ is not null");
            return (Criteria) this;
        }

        public Criteria andLxbjEqualTo(String value) {
            addCriterion("LXBJ =", value, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjNotEqualTo(String value) {
            addCriterion("LXBJ <>", value, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjGreaterThan(String value) {
            addCriterion("LXBJ >", value, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjGreaterThanOrEqualTo(String value) {
            addCriterion("LXBJ >=", value, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjLessThan(String value) {
            addCriterion("LXBJ <", value, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjLessThanOrEqualTo(String value) {
            addCriterion("LXBJ <=", value, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjLike(String value) {
            addCriterion("LXBJ like", value, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjNotLike(String value) {
            addCriterion("LXBJ not like", value, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjIn(List<String> values) {
            addCriterion("LXBJ in", values, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjNotIn(List<String> values) {
            addCriterion("LXBJ not in", values, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjBetween(String value1, String value2) {
            addCriterion("LXBJ between", value1, value2, "lxbj");
            return (Criteria) this;
        }

        public Criteria andLxbjNotBetween(String value1, String value2) {
            addCriterion("LXBJ not between", value1, value2, "lxbj");
            return (Criteria) this;
        }

        public Criteria andYjnrIsNull() {
            addCriterion("YJNR is null");
            return (Criteria) this;
        }

        public Criteria andYjnrIsNotNull() {
            addCriterion("YJNR is not null");
            return (Criteria) this;
        }

        public Criteria andYjnrEqualTo(String value) {
            addCriterion("YJNR =", value, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrNotEqualTo(String value) {
            addCriterion("YJNR <>", value, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrGreaterThan(String value) {
            addCriterion("YJNR >", value, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrGreaterThanOrEqualTo(String value) {
            addCriterion("YJNR >=", value, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrLessThan(String value) {
            addCriterion("YJNR <", value, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrLessThanOrEqualTo(String value) {
            addCriterion("YJNR <=", value, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrLike(String value) {
            addCriterion("YJNR like", value, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrNotLike(String value) {
            addCriterion("YJNR not like", value, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrIn(List<String> values) {
            addCriterion("YJNR in", values, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrNotIn(List<String> values) {
            addCriterion("YJNR not in", values, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrBetween(String value1, String value2) {
            addCriterion("YJNR between", value1, value2, "yjnr");
            return (Criteria) this;
        }

        public Criteria andYjnrNotBetween(String value1, String value2) {
            addCriterion("YJNR not between", value1, value2, "yjnr");
            return (Criteria) this;
        }

        public Criteria andJdapIsNull() {
            addCriterion("JDAP is null");
            return (Criteria) this;
        }

        public Criteria andJdapIsNotNull() {
            addCriterion("JDAP is not null");
            return (Criteria) this;
        }

        public Criteria andJdapEqualTo(String value) {
            addCriterion("JDAP =", value, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapNotEqualTo(String value) {
            addCriterion("JDAP <>", value, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapGreaterThan(String value) {
            addCriterion("JDAP >", value, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapGreaterThanOrEqualTo(String value) {
            addCriterion("JDAP >=", value, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapLessThan(String value) {
            addCriterion("JDAP <", value, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapLessThanOrEqualTo(String value) {
            addCriterion("JDAP <=", value, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapLike(String value) {
            addCriterion("JDAP like", value, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapNotLike(String value) {
            addCriterion("JDAP not like", value, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapIn(List<String> values) {
            addCriterion("JDAP in", values, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapNotIn(List<String> values) {
            addCriterion("JDAP not in", values, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapBetween(String value1, String value2) {
            addCriterion("JDAP between", value1, value2, "jdap");
            return (Criteria) this;
        }

        public Criteria andJdapNotBetween(String value1, String value2) {
            addCriterion("JDAP not between", value1, value2, "jdap");
            return (Criteria) this;
        }

        public Criteria andYjmbIsNull() {
            addCriterion("YJMB is null");
            return (Criteria) this;
        }

        public Criteria andYjmbIsNotNull() {
            addCriterion("YJMB is not null");
            return (Criteria) this;
        }

        public Criteria andYjmbEqualTo(String value) {
            addCriterion("YJMB =", value, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbNotEqualTo(String value) {
            addCriterion("YJMB <>", value, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbGreaterThan(String value) {
            addCriterion("YJMB >", value, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbGreaterThanOrEqualTo(String value) {
            addCriterion("YJMB >=", value, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbLessThan(String value) {
            addCriterion("YJMB <", value, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbLessThanOrEqualTo(String value) {
            addCriterion("YJMB <=", value, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbLike(String value) {
            addCriterion("YJMB like", value, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbNotLike(String value) {
            addCriterion("YJMB not like", value, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbIn(List<String> values) {
            addCriterion("YJMB in", values, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbNotIn(List<String> values) {
            addCriterion("YJMB not in", values, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbBetween(String value1, String value2) {
            addCriterion("YJMB between", value1, value2, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjmbNotBetween(String value1, String value2) {
            addCriterion("YJMB not between", value1, value2, "yjmb");
            return (Criteria) this;
        }

        public Criteria andYjyjcIsNull() {
            addCriterion("YJYJC is null");
            return (Criteria) this;
        }

        public Criteria andYjyjcIsNotNull() {
            addCriterion("YJYJC is not null");
            return (Criteria) this;
        }

        public Criteria andYjyjcEqualTo(String value) {
            addCriterion("YJYJC =", value, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcNotEqualTo(String value) {
            addCriterion("YJYJC <>", value, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcGreaterThan(String value) {
            addCriterion("YJYJC >", value, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcGreaterThanOrEqualTo(String value) {
            addCriterion("YJYJC >=", value, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcLessThan(String value) {
            addCriterion("YJYJC <", value, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcLessThanOrEqualTo(String value) {
            addCriterion("YJYJC <=", value, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcLike(String value) {
            addCriterion("YJYJC like", value, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcNotLike(String value) {
            addCriterion("YJYJC not like", value, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcIn(List<String> values) {
            addCriterion("YJYJC in", values, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcNotIn(List<String> values) {
            addCriterion("YJYJC not in", values, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcBetween(String value1, String value2) {
            addCriterion("YJYJC between", value1, value2, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andYjyjcNotBetween(String value1, String value2) {
            addCriterion("YJYJC not between", value1, value2, "yjyjc");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyIsNull() {
            addCriterion("PROJECT_PROPERTY is null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyIsNotNull() {
            addCriterion("PROJECT_PROPERTY is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyEqualTo(String value) {
            addCriterion("PROJECT_PROPERTY =", value, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyNotEqualTo(String value) {
            addCriterion("PROJECT_PROPERTY <>", value, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyGreaterThan(String value) {
            addCriterion("PROJECT_PROPERTY >", value, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_PROPERTY >=", value, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyLessThan(String value) {
            addCriterion("PROJECT_PROPERTY <", value, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_PROPERTY <=", value, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyLike(String value) {
            addCriterion("PROJECT_PROPERTY like", value, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyNotLike(String value) {
            addCriterion("PROJECT_PROPERTY not like", value, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyIn(List<String> values) {
            addCriterion("PROJECT_PROPERTY in", values, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyNotIn(List<String> values) {
            addCriterion("PROJECT_PROPERTY not in", values, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyBetween(String value1, String value2) {
            addCriterion("PROJECT_PROPERTY between", value1, value2, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectPropertyNotBetween(String value1, String value2) {
            addCriterion("PROJECT_PROPERTY not between", value1, value2, "projectProperty");
            return (Criteria) this;
        }

        public Criteria andProjectScopeIsNull() {
            addCriterion("PROJECT_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andProjectScopeIsNotNull() {
            addCriterion("PROJECT_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andProjectScopeEqualTo(String value) {
            addCriterion("PROJECT_SCOPE =", value, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeNotEqualTo(String value) {
            addCriterion("PROJECT_SCOPE <>", value, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeGreaterThan(String value) {
            addCriterion("PROJECT_SCOPE >", value, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_SCOPE >=", value, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeLessThan(String value) {
            addCriterion("PROJECT_SCOPE <", value, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_SCOPE <=", value, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeLike(String value) {
            addCriterion("PROJECT_SCOPE like", value, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeNotLike(String value) {
            addCriterion("PROJECT_SCOPE not like", value, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeIn(List<String> values) {
            addCriterion("PROJECT_SCOPE in", values, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeNotIn(List<String> values) {
            addCriterion("PROJECT_SCOPE not in", values, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeBetween(String value1, String value2) {
            addCriterion("PROJECT_SCOPE between", value1, value2, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectScopeNotBetween(String value1, String value2) {
            addCriterion("PROJECT_SCOPE not between", value1, value2, "projectScope");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("PROJECT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("PROJECT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("PROJECT_TYPE =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("PROJECT_TYPE <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("PROJECT_TYPE >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_TYPE >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("PROJECT_TYPE <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_TYPE <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("PROJECT_TYPE like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("PROJECT_TYPE not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("PROJECT_TYPE in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("PROJECT_TYPE not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("PROJECT_TYPE between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("PROJECT_TYPE not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andDefine1IsNull() {
            addCriterion("DEFINE1 is null");
            return (Criteria) this;
        }

        public Criteria andDefine1IsNotNull() {
            addCriterion("DEFINE1 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine1EqualTo(String value) {
            addCriterion("DEFINE1 =", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotEqualTo(String value) {
            addCriterion("DEFINE1 <>", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1GreaterThan(String value) {
            addCriterion("DEFINE1 >", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1GreaterThanOrEqualTo(String value) {
            addCriterion("DEFINE1 >=", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1LessThan(String value) {
            addCriterion("DEFINE1 <", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1LessThanOrEqualTo(String value) {
            addCriterion("DEFINE1 <=", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1Like(String value) {
            addCriterion("DEFINE1 like", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotLike(String value) {
            addCriterion("DEFINE1 not like", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1In(List<String> values) {
            addCriterion("DEFINE1 in", values, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotIn(List<String> values) {
            addCriterion("DEFINE1 not in", values, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1Between(String value1, String value2) {
            addCriterion("DEFINE1 between", value1, value2, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotBetween(String value1, String value2) {
            addCriterion("DEFINE1 not between", value1, value2, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine2IsNull() {
            addCriterion("DEFINE2 is null");
            return (Criteria) this;
        }

        public Criteria andDefine2IsNotNull() {
            addCriterion("DEFINE2 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine2EqualTo(String value) {
            addCriterion("DEFINE2 =", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotEqualTo(String value) {
            addCriterion("DEFINE2 <>", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2GreaterThan(String value) {
            addCriterion("DEFINE2 >", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2GreaterThanOrEqualTo(String value) {
            addCriterion("DEFINE2 >=", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2LessThan(String value) {
            addCriterion("DEFINE2 <", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2LessThanOrEqualTo(String value) {
            addCriterion("DEFINE2 <=", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2Like(String value) {
            addCriterion("DEFINE2 like", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotLike(String value) {
            addCriterion("DEFINE2 not like", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2In(List<String> values) {
            addCriterion("DEFINE2 in", values, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotIn(List<String> values) {
            addCriterion("DEFINE2 not in", values, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2Between(String value1, String value2) {
            addCriterion("DEFINE2 between", value1, value2, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotBetween(String value1, String value2) {
            addCriterion("DEFINE2 not between", value1, value2, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine3IsNull() {
            addCriterion("DEFINE3 is null");
            return (Criteria) this;
        }

        public Criteria andDefine3IsNotNull() {
            addCriterion("DEFINE3 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine3EqualTo(String value) {
            addCriterion("DEFINE3 =", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotEqualTo(String value) {
            addCriterion("DEFINE3 <>", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3GreaterThan(String value) {
            addCriterion("DEFINE3 >", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3GreaterThanOrEqualTo(String value) {
            addCriterion("DEFINE3 >=", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3LessThan(String value) {
            addCriterion("DEFINE3 <", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3LessThanOrEqualTo(String value) {
            addCriterion("DEFINE3 <=", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3Like(String value) {
            addCriterion("DEFINE3 like", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotLike(String value) {
            addCriterion("DEFINE3 not like", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3In(List<String> values) {
            addCriterion("DEFINE3 in", values, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotIn(List<String> values) {
            addCriterion("DEFINE3 not in", values, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3Between(String value1, String value2) {
            addCriterion("DEFINE3 between", value1, value2, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotBetween(String value1, String value2) {
            addCriterion("DEFINE3 not between", value1, value2, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine4IsNull() {
            addCriterion("DEFINE4 is null");
            return (Criteria) this;
        }

        public Criteria andDefine4IsNotNull() {
            addCriterion("DEFINE4 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine4EqualTo(String value) {
            addCriterion("DEFINE4 =", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotEqualTo(String value) {
            addCriterion("DEFINE4 <>", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4GreaterThan(String value) {
            addCriterion("DEFINE4 >", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4GreaterThanOrEqualTo(String value) {
            addCriterion("DEFINE4 >=", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4LessThan(String value) {
            addCriterion("DEFINE4 <", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4LessThanOrEqualTo(String value) {
            addCriterion("DEFINE4 <=", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4Like(String value) {
            addCriterion("DEFINE4 like", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotLike(String value) {
            addCriterion("DEFINE4 not like", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4In(List<String> values) {
            addCriterion("DEFINE4 in", values, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotIn(List<String> values) {
            addCriterion("DEFINE4 not in", values, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4Between(String value1, String value2) {
            addCriterion("DEFINE4 between", value1, value2, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotBetween(String value1, String value2) {
            addCriterion("DEFINE4 not between", value1, value2, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine5IsNull() {
            addCriterion("DEFINE5 is null");
            return (Criteria) this;
        }

        public Criteria andDefine5IsNotNull() {
            addCriterion("DEFINE5 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine5EqualTo(String value) {
            addCriterion("DEFINE5 =", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5NotEqualTo(String value) {
            addCriterion("DEFINE5 <>", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5GreaterThan(String value) {
            addCriterion("DEFINE5 >", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5GreaterThanOrEqualTo(String value) {
            addCriterion("DEFINE5 >=", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5LessThan(String value) {
            addCriterion("DEFINE5 <", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5LessThanOrEqualTo(String value) {
            addCriterion("DEFINE5 <=", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5Like(String value) {
            addCriterion("DEFINE5 like", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5NotLike(String value) {
            addCriterion("DEFINE5 not like", value, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5In(List<String> values) {
            addCriterion("DEFINE5 in", values, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5NotIn(List<String> values) {
            addCriterion("DEFINE5 not in", values, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5Between(String value1, String value2) {
            addCriterion("DEFINE5 between", value1, value2, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine5NotBetween(String value1, String value2) {
            addCriterion("DEFINE5 not between", value1, value2, "define5");
            return (Criteria) this;
        }

        public Criteria andDefine6IsNull() {
            addCriterion("DEFINE6 is null");
            return (Criteria) this;
        }

        public Criteria andDefine6IsNotNull() {
            addCriterion("DEFINE6 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine6EqualTo(String value) {
            addCriterion("DEFINE6 =", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6NotEqualTo(String value) {
            addCriterion("DEFINE6 <>", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6GreaterThan(String value) {
            addCriterion("DEFINE6 >", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6GreaterThanOrEqualTo(String value) {
            addCriterion("DEFINE6 >=", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6LessThan(String value) {
            addCriterion("DEFINE6 <", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6LessThanOrEqualTo(String value) {
            addCriterion("DEFINE6 <=", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6Like(String value) {
            addCriterion("DEFINE6 like", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6NotLike(String value) {
            addCriterion("DEFINE6 not like", value, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6In(List<String> values) {
            addCriterion("DEFINE6 in", values, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6NotIn(List<String> values) {
            addCriterion("DEFINE6 not in", values, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6Between(String value1, String value2) {
            addCriterion("DEFINE6 between", value1, value2, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine6NotBetween(String value1, String value2) {
            addCriterion("DEFINE6 not between", value1, value2, "define6");
            return (Criteria) this;
        }

        public Criteria andDefine7IsNull() {
            addCriterion("DEFINE7 is null");
            return (Criteria) this;
        }

        public Criteria andDefine7IsNotNull() {
            addCriterion("DEFINE7 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine7EqualTo(String value) {
            addCriterion("DEFINE7 =", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7NotEqualTo(String value) {
            addCriterion("DEFINE7 <>", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7GreaterThan(String value) {
            addCriterion("DEFINE7 >", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7GreaterThanOrEqualTo(String value) {
            addCriterion("DEFINE7 >=", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7LessThan(String value) {
            addCriterion("DEFINE7 <", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7LessThanOrEqualTo(String value) {
            addCriterion("DEFINE7 <=", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7Like(String value) {
            addCriterion("DEFINE7 like", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7NotLike(String value) {
            addCriterion("DEFINE7 not like", value, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7In(List<String> values) {
            addCriterion("DEFINE7 in", values, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7NotIn(List<String> values) {
            addCriterion("DEFINE7 not in", values, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7Between(String value1, String value2) {
            addCriterion("DEFINE7 between", value1, value2, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine7NotBetween(String value1, String value2) {
            addCriterion("DEFINE7 not between", value1, value2, "define7");
            return (Criteria) this;
        }

        public Criteria andDefine8IsNull() {
            addCriterion("DEFINE8 is null");
            return (Criteria) this;
        }

        public Criteria andDefine8IsNotNull() {
            addCriterion("DEFINE8 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine8EqualTo(String value) {
            addCriterion("DEFINE8 =", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8NotEqualTo(String value) {
            addCriterion("DEFINE8 <>", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8GreaterThan(String value) {
            addCriterion("DEFINE8 >", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8GreaterThanOrEqualTo(String value) {
            addCriterion("DEFINE8 >=", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8LessThan(String value) {
            addCriterion("DEFINE8 <", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8LessThanOrEqualTo(String value) {
            addCriterion("DEFINE8 <=", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8Like(String value) {
            addCriterion("DEFINE8 like", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8NotLike(String value) {
            addCriterion("DEFINE8 not like", value, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8In(List<String> values) {
            addCriterion("DEFINE8 in", values, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8NotIn(List<String> values) {
            addCriterion("DEFINE8 not in", values, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8Between(String value1, String value2) {
            addCriterion("DEFINE8 between", value1, value2, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine8NotBetween(String value1, String value2) {
            addCriterion("DEFINE8 not between", value1, value2, "define8");
            return (Criteria) this;
        }

        public Criteria andDefine9IsNull() {
            addCriterion("DEFINE9 is null");
            return (Criteria) this;
        }

        public Criteria andDefine9IsNotNull() {
            addCriterion("DEFINE9 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine9EqualTo(String value) {
            addCriterion("DEFINE9 =", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9NotEqualTo(String value) {
            addCriterion("DEFINE9 <>", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9GreaterThan(String value) {
            addCriterion("DEFINE9 >", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9GreaterThanOrEqualTo(String value) {
            addCriterion("DEFINE9 >=", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9LessThan(String value) {
            addCriterion("DEFINE9 <", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9LessThanOrEqualTo(String value) {
            addCriterion("DEFINE9 <=", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9Like(String value) {
            addCriterion("DEFINE9 like", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9NotLike(String value) {
            addCriterion("DEFINE9 not like", value, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9In(List<String> values) {
            addCriterion("DEFINE9 in", values, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9NotIn(List<String> values) {
            addCriterion("DEFINE9 not in", values, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9Between(String value1, String value2) {
            addCriterion("DEFINE9 between", value1, value2, "define9");
            return (Criteria) this;
        }

        public Criteria andDefine9NotBetween(String value1, String value2) {
            addCriterion("DEFINE9 not between", value1, value2, "define9");
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