package com.pcitc.base.stp.out;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutPatentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutPatentExample() {
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

        public Criteria andSqhIsNull() {
            addCriterion("SQH is null");
            return (Criteria) this;
        }

        public Criteria andSqhIsNotNull() {
            addCriterion("SQH is not null");
            return (Criteria) this;
        }

        public Criteria andSqhEqualTo(String value) {
            addCriterion("SQH =", value, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhNotEqualTo(String value) {
            addCriterion("SQH <>", value, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhGreaterThan(String value) {
            addCriterion("SQH >", value, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhGreaterThanOrEqualTo(String value) {
            addCriterion("SQH >=", value, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhLessThan(String value) {
            addCriterion("SQH <", value, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhLessThanOrEqualTo(String value) {
            addCriterion("SQH <=", value, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhLike(String value) {
            addCriterion("SQH like", value, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhNotLike(String value) {
            addCriterion("SQH not like", value, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhIn(List<String> values) {
            addCriterion("SQH in", values, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhNotIn(List<String> values) {
            addCriterion("SQH not in", values, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhBetween(String value1, String value2) {
            addCriterion("SQH between", value1, value2, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqhNotBetween(String value1, String value2) {
            addCriterion("SQH not between", value1, value2, "sqh");
            return (Criteria) this;
        }

        public Criteria andSqriIsNull() {
            addCriterion("SQRI is null");
            return (Criteria) this;
        }

        public Criteria andSqriIsNotNull() {
            addCriterion("SQRI is not null");
            return (Criteria) this;
        }

        public Criteria andSqriEqualTo(String value) {
            addCriterion("SQRI =", value, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriNotEqualTo(String value) {
            addCriterion("SQRI <>", value, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriGreaterThan(String value) {
            addCriterion("SQRI >", value, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriGreaterThanOrEqualTo(String value) {
            addCriterion("SQRI >=", value, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriLessThan(String value) {
            addCriterion("SQRI <", value, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriLessThanOrEqualTo(String value) {
            addCriterion("SQRI <=", value, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriLike(String value) {
            addCriterion("SQRI like", value, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriNotLike(String value) {
            addCriterion("SQRI not like", value, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriIn(List<String> values) {
            addCriterion("SQRI in", values, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriNotIn(List<String> values) {
            addCriterion("SQRI not in", values, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriBetween(String value1, String value2) {
            addCriterion("SQRI between", value1, value2, "sqri");
            return (Criteria) this;
        }

        public Criteria andSqriNotBetween(String value1, String value2) {
            addCriterion("SQRI not between", value1, value2, "sqri");
            return (Criteria) this;
        }

        public Criteria andFmmcIsNull() {
            addCriterion("FMMC is null");
            return (Criteria) this;
        }

        public Criteria andFmmcIsNotNull() {
            addCriterion("FMMC is not null");
            return (Criteria) this;
        }

        public Criteria andFmmcEqualTo(String value) {
            addCriterion("FMMC =", value, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcNotEqualTo(String value) {
            addCriterion("FMMC <>", value, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcGreaterThan(String value) {
            addCriterion("FMMC >", value, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcGreaterThanOrEqualTo(String value) {
            addCriterion("FMMC >=", value, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcLessThan(String value) {
            addCriterion("FMMC <", value, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcLessThanOrEqualTo(String value) {
            addCriterion("FMMC <=", value, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcLike(String value) {
            addCriterion("FMMC like", value, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcNotLike(String value) {
            addCriterion("FMMC not like", value, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcIn(List<String> values) {
            addCriterion("FMMC in", values, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcNotIn(List<String> values) {
            addCriterion("FMMC not in", values, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcBetween(String value1, String value2) {
            addCriterion("FMMC between", value1, value2, "fmmc");
            return (Criteria) this;
        }

        public Criteria andFmmcNotBetween(String value1, String value2) {
            addCriterion("FMMC not between", value1, value2, "fmmc");
            return (Criteria) this;
        }

        public Criteria andZhyIsNull() {
            addCriterion("ZHY is null");
            return (Criteria) this;
        }

        public Criteria andZhyIsNotNull() {
            addCriterion("ZHY is not null");
            return (Criteria) this;
        }

        public Criteria andZhyEqualTo(String value) {
            addCriterion("ZHY =", value, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyNotEqualTo(String value) {
            addCriterion("ZHY <>", value, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyGreaterThan(String value) {
            addCriterion("ZHY >", value, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyGreaterThanOrEqualTo(String value) {
            addCriterion("ZHY >=", value, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyLessThan(String value) {
            addCriterion("ZHY <", value, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyLessThanOrEqualTo(String value) {
            addCriterion("ZHY <=", value, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyLike(String value) {
            addCriterion("ZHY like", value, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyNotLike(String value) {
            addCriterion("ZHY not like", value, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyIn(List<String> values) {
            addCriterion("ZHY in", values, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyNotIn(List<String> values) {
            addCriterion("ZHY not in", values, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyBetween(String value1, String value2) {
            addCriterion("ZHY between", value1, value2, "zhy");
            return (Criteria) this;
        }

        public Criteria andZhyNotBetween(String value1, String value2) {
            addCriterion("ZHY not between", value1, value2, "zhy");
            return (Criteria) this;
        }

        public Criteria andGkhIsNull() {
            addCriterion("GKH is null");
            return (Criteria) this;
        }

        public Criteria andGkhIsNotNull() {
            addCriterion("GKH is not null");
            return (Criteria) this;
        }

        public Criteria andGkhEqualTo(String value) {
            addCriterion("GKH =", value, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhNotEqualTo(String value) {
            addCriterion("GKH <>", value, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhGreaterThan(String value) {
            addCriterion("GKH >", value, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhGreaterThanOrEqualTo(String value) {
            addCriterion("GKH >=", value, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhLessThan(String value) {
            addCriterion("GKH <", value, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhLessThanOrEqualTo(String value) {
            addCriterion("GKH <=", value, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhLike(String value) {
            addCriterion("GKH like", value, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhNotLike(String value) {
            addCriterion("GKH not like", value, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhIn(List<String> values) {
            addCriterion("GKH in", values, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhNotIn(List<String> values) {
            addCriterion("GKH not in", values, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhBetween(String value1, String value2) {
            addCriterion("GKH between", value1, value2, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkhNotBetween(String value1, String value2) {
            addCriterion("GKH not between", value1, value2, "gkh");
            return (Criteria) this;
        }

        public Criteria andGkrIsNull() {
            addCriterion("GKR is null");
            return (Criteria) this;
        }

        public Criteria andGkrIsNotNull() {
            addCriterion("GKR is not null");
            return (Criteria) this;
        }

        public Criteria andGkrEqualTo(String value) {
            addCriterion("GKR =", value, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrNotEqualTo(String value) {
            addCriterion("GKR <>", value, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrGreaterThan(String value) {
            addCriterion("GKR >", value, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrGreaterThanOrEqualTo(String value) {
            addCriterion("GKR >=", value, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrLessThan(String value) {
            addCriterion("GKR <", value, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrLessThanOrEqualTo(String value) {
            addCriterion("GKR <=", value, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrLike(String value) {
            addCriterion("GKR like", value, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrNotLike(String value) {
            addCriterion("GKR not like", value, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrIn(List<String> values) {
            addCriterion("GKR in", values, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrNotIn(List<String> values) {
            addCriterion("GKR not in", values, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrBetween(String value1, String value2) {
            addCriterion("GKR between", value1, value2, "gkr");
            return (Criteria) this;
        }

        public Criteria andGkrNotBetween(String value1, String value2) {
            addCriterion("GKR not between", value1, value2, "gkr");
            return (Criteria) this;
        }

        public Criteria andWxlxIsNull() {
            addCriterion("WXLX is null");
            return (Criteria) this;
        }

        public Criteria andWxlxIsNotNull() {
            addCriterion("WXLX is not null");
            return (Criteria) this;
        }

        public Criteria andWxlxEqualTo(String value) {
            addCriterion("WXLX =", value, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxNotEqualTo(String value) {
            addCriterion("WXLX <>", value, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxGreaterThan(String value) {
            addCriterion("WXLX >", value, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxGreaterThanOrEqualTo(String value) {
            addCriterion("WXLX >=", value, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxLessThan(String value) {
            addCriterion("WXLX <", value, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxLessThanOrEqualTo(String value) {
            addCriterion("WXLX <=", value, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxLike(String value) {
            addCriterion("WXLX like", value, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxNotLike(String value) {
            addCriterion("WXLX not like", value, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxIn(List<String> values) {
            addCriterion("WXLX in", values, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxNotIn(List<String> values) {
            addCriterion("WXLX not in", values, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxBetween(String value1, String value2) {
            addCriterion("WXLX between", value1, value2, "wxlx");
            return (Criteria) this;
        }

        public Criteria andWxlxNotBetween(String value1, String value2) {
            addCriterion("WXLX not between", value1, value2, "wxlx");
            return (Criteria) this;
        }

        public Criteria andShenqrIsNull() {
            addCriterion("SHENQR is null");
            return (Criteria) this;
        }

        public Criteria andShenqrIsNotNull() {
            addCriterion("SHENQR is not null");
            return (Criteria) this;
        }

        public Criteria andShenqrEqualTo(String value) {
            addCriterion("SHENQR =", value, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrNotEqualTo(String value) {
            addCriterion("SHENQR <>", value, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrGreaterThan(String value) {
            addCriterion("SHENQR >", value, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrGreaterThanOrEqualTo(String value) {
            addCriterion("SHENQR >=", value, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrLessThan(String value) {
            addCriterion("SHENQR <", value, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrLessThanOrEqualTo(String value) {
            addCriterion("SHENQR <=", value, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrLike(String value) {
            addCriterion("SHENQR like", value, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrNotLike(String value) {
            addCriterion("SHENQR not like", value, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrIn(List<String> values) {
            addCriterion("SHENQR in", values, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrNotIn(List<String> values) {
            addCriterion("SHENQR not in", values, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrBetween(String value1, String value2) {
            addCriterion("SHENQR between", value1, value2, "shenqr");
            return (Criteria) this;
        }

        public Criteria andShenqrNotBetween(String value1, String value2) {
            addCriterion("SHENQR not between", value1, value2, "shenqr");
            return (Criteria) this;
        }

        public Criteria andFmrIsNull() {
            addCriterion("FMR is null");
            return (Criteria) this;
        }

        public Criteria andFmrIsNotNull() {
            addCriterion("FMR is not null");
            return (Criteria) this;
        }

        public Criteria andFmrEqualTo(String value) {
            addCriterion("FMR =", value, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrNotEqualTo(String value) {
            addCriterion("FMR <>", value, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrGreaterThan(String value) {
            addCriterion("FMR >", value, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrGreaterThanOrEqualTo(String value) {
            addCriterion("FMR >=", value, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrLessThan(String value) {
            addCriterion("FMR <", value, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrLessThanOrEqualTo(String value) {
            addCriterion("FMR <=", value, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrLike(String value) {
            addCriterion("FMR like", value, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrNotLike(String value) {
            addCriterion("FMR not like", value, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrIn(List<String> values) {
            addCriterion("FMR in", values, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrNotIn(List<String> values) {
            addCriterion("FMR not in", values, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrBetween(String value1, String value2) {
            addCriterion("FMR between", value1, value2, "fmr");
            return (Criteria) this;
        }

        public Criteria andFmrNotBetween(String value1, String value2) {
            addCriterion("FMR not between", value1, value2, "fmr");
            return (Criteria) this;
        }

        public Criteria andSqrdzIsNull() {
            addCriterion("SQRDZ is null");
            return (Criteria) this;
        }

        public Criteria andSqrdzIsNotNull() {
            addCriterion("SQRDZ is not null");
            return (Criteria) this;
        }

        public Criteria andSqrdzEqualTo(String value) {
            addCriterion("SQRDZ =", value, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzNotEqualTo(String value) {
            addCriterion("SQRDZ <>", value, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzGreaterThan(String value) {
            addCriterion("SQRDZ >", value, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzGreaterThanOrEqualTo(String value) {
            addCriterion("SQRDZ >=", value, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzLessThan(String value) {
            addCriterion("SQRDZ <", value, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzLessThanOrEqualTo(String value) {
            addCriterion("SQRDZ <=", value, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzLike(String value) {
            addCriterion("SQRDZ like", value, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzNotLike(String value) {
            addCriterion("SQRDZ not like", value, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzIn(List<String> values) {
            addCriterion("SQRDZ in", values, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzNotIn(List<String> values) {
            addCriterion("SQRDZ not in", values, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzBetween(String value1, String value2) {
            addCriterion("SQRDZ between", value1, value2, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andSqrdzNotBetween(String value1, String value2) {
            addCriterion("SQRDZ not between", value1, value2, "sqrdz");
            return (Criteria) this;
        }

        public Criteria andDlrIsNull() {
            addCriterion("DLR is null");
            return (Criteria) this;
        }

        public Criteria andDlrIsNotNull() {
            addCriterion("DLR is not null");
            return (Criteria) this;
        }

        public Criteria andDlrEqualTo(String value) {
            addCriterion("DLR =", value, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrNotEqualTo(String value) {
            addCriterion("DLR <>", value, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrGreaterThan(String value) {
            addCriterion("DLR >", value, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrGreaterThanOrEqualTo(String value) {
            addCriterion("DLR >=", value, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrLessThan(String value) {
            addCriterion("DLR <", value, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrLessThanOrEqualTo(String value) {
            addCriterion("DLR <=", value, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrLike(String value) {
            addCriterion("DLR like", value, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrNotLike(String value) {
            addCriterion("DLR not like", value, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrIn(List<String> values) {
            addCriterion("DLR in", values, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrNotIn(List<String> values) {
            addCriterion("DLR not in", values, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrBetween(String value1, String value2) {
            addCriterion("DLR between", value1, value2, "dlr");
            return (Criteria) this;
        }

        public Criteria andDlrNotBetween(String value1, String value2) {
            addCriterion("DLR not between", value1, value2, "dlr");
            return (Criteria) this;
        }

        public Criteria andDljgIsNull() {
            addCriterion("DLJG is null");
            return (Criteria) this;
        }

        public Criteria andDljgIsNotNull() {
            addCriterion("DLJG is not null");
            return (Criteria) this;
        }

        public Criteria andDljgEqualTo(String value) {
            addCriterion("DLJG =", value, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgNotEqualTo(String value) {
            addCriterion("DLJG <>", value, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgGreaterThan(String value) {
            addCriterion("DLJG >", value, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgGreaterThanOrEqualTo(String value) {
            addCriterion("DLJG >=", value, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgLessThan(String value) {
            addCriterion("DLJG <", value, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgLessThanOrEqualTo(String value) {
            addCriterion("DLJG <=", value, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgLike(String value) {
            addCriterion("DLJG like", value, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgNotLike(String value) {
            addCriterion("DLJG not like", value, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgIn(List<String> values) {
            addCriterion("DLJG in", values, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgNotIn(List<String> values) {
            addCriterion("DLJG not in", values, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgBetween(String value1, String value2) {
            addCriterion("DLJG between", value1, value2, "dljg");
            return (Criteria) this;
        }

        public Criteria andDljgNotBetween(String value1, String value2) {
            addCriterion("DLJG not between", value1, value2, "dljg");
            return (Criteria) this;
        }

        public Criteria andGbdmIsNull() {
            addCriterion("GBDM is null");
            return (Criteria) this;
        }

        public Criteria andGbdmIsNotNull() {
            addCriterion("GBDM is not null");
            return (Criteria) this;
        }

        public Criteria andGbdmEqualTo(String value) {
            addCriterion("GBDM =", value, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmNotEqualTo(String value) {
            addCriterion("GBDM <>", value, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmGreaterThan(String value) {
            addCriterion("GBDM >", value, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmGreaterThanOrEqualTo(String value) {
            addCriterion("GBDM >=", value, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmLessThan(String value) {
            addCriterion("GBDM <", value, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmLessThanOrEqualTo(String value) {
            addCriterion("GBDM <=", value, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmLike(String value) {
            addCriterion("GBDM like", value, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmNotLike(String value) {
            addCriterion("GBDM not like", value, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmIn(List<String> values) {
            addCriterion("GBDM in", values, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmNotIn(List<String> values) {
            addCriterion("GBDM not in", values, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmBetween(String value1, String value2) {
            addCriterion("GBDM between", value1, value2, "gbdm");
            return (Criteria) this;
        }

        public Criteria andGbdmNotBetween(String value1, String value2) {
            addCriterion("GBDM not between", value1, value2, "gbdm");
            return (Criteria) this;
        }

        public Criteria andIpcflhIsNull() {
            addCriterion("IPCFLH is null");
            return (Criteria) this;
        }

        public Criteria andIpcflhIsNotNull() {
            addCriterion("IPCFLH is not null");
            return (Criteria) this;
        }

        public Criteria andIpcflhEqualTo(String value) {
            addCriterion("IPCFLH =", value, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhNotEqualTo(String value) {
            addCriterion("IPCFLH <>", value, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhGreaterThan(String value) {
            addCriterion("IPCFLH >", value, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhGreaterThanOrEqualTo(String value) {
            addCriterion("IPCFLH >=", value, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhLessThan(String value) {
            addCriterion("IPCFLH <", value, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhLessThanOrEqualTo(String value) {
            addCriterion("IPCFLH <=", value, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhLike(String value) {
            addCriterion("IPCFLH like", value, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhNotLike(String value) {
            addCriterion("IPCFLH not like", value, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhIn(List<String> values) {
            addCriterion("IPCFLH in", values, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhNotIn(List<String> values) {
            addCriterion("IPCFLH not in", values, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhBetween(String value1, String value2) {
            addCriterion("IPCFLH between", value1, value2, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andIpcflhNotBetween(String value1, String value2) {
            addCriterion("IPCFLH not between", value1, value2, "ipcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhIsNull() {
            addCriterion("CPCFLH is null");
            return (Criteria) this;
        }

        public Criteria andCpcflhIsNotNull() {
            addCriterion("CPCFLH is not null");
            return (Criteria) this;
        }

        public Criteria andCpcflhEqualTo(String value) {
            addCriterion("CPCFLH =", value, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhNotEqualTo(String value) {
            addCriterion("CPCFLH <>", value, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhGreaterThan(String value) {
            addCriterion("CPCFLH >", value, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhGreaterThanOrEqualTo(String value) {
            addCriterion("CPCFLH >=", value, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhLessThan(String value) {
            addCriterion("CPCFLH <", value, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhLessThanOrEqualTo(String value) {
            addCriterion("CPCFLH <=", value, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhLike(String value) {
            addCriterion("CPCFLH like", value, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhNotLike(String value) {
            addCriterion("CPCFLH not like", value, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhIn(List<String> values) {
            addCriterion("CPCFLH in", values, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhNotIn(List<String> values) {
            addCriterion("CPCFLH not in", values, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhBetween(String value1, String value2) {
            addCriterion("CPCFLH between", value1, value2, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andCpcflhNotBetween(String value1, String value2) {
            addCriterion("CPCFLH not between", value1, value2, "cpcflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhIsNull() {
            addCriterion("LJNFLH is null");
            return (Criteria) this;
        }

        public Criteria andLjnflhIsNotNull() {
            addCriterion("LJNFLH is not null");
            return (Criteria) this;
        }

        public Criteria andLjnflhEqualTo(String value) {
            addCriterion("LJNFLH =", value, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhNotEqualTo(String value) {
            addCriterion("LJNFLH <>", value, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhGreaterThan(String value) {
            addCriterion("LJNFLH >", value, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhGreaterThanOrEqualTo(String value) {
            addCriterion("LJNFLH >=", value, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhLessThan(String value) {
            addCriterion("LJNFLH <", value, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhLessThanOrEqualTo(String value) {
            addCriterion("LJNFLH <=", value, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhLike(String value) {
            addCriterion("LJNFLH like", value, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhNotLike(String value) {
            addCriterion("LJNFLH not like", value, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhIn(List<String> values) {
            addCriterion("LJNFLH in", values, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhNotIn(List<String> values) {
            addCriterion("LJNFLH not in", values, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhBetween(String value1, String value2) {
            addCriterion("LJNFLH between", value1, value2, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andLjnflhNotBetween(String value1, String value2) {
            addCriterion("LJNFLH not between", value1, value2, "ljnflh");
            return (Criteria) this;
        }

        public Criteria andYxqhIsNull() {
            addCriterion("YXQH is null");
            return (Criteria) this;
        }

        public Criteria andYxqhIsNotNull() {
            addCriterion("YXQH is not null");
            return (Criteria) this;
        }

        public Criteria andYxqhEqualTo(String value) {
            addCriterion("YXQH =", value, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhNotEqualTo(String value) {
            addCriterion("YXQH <>", value, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhGreaterThan(String value) {
            addCriterion("YXQH >", value, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhGreaterThanOrEqualTo(String value) {
            addCriterion("YXQH >=", value, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhLessThan(String value) {
            addCriterion("YXQH <", value, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhLessThanOrEqualTo(String value) {
            addCriterion("YXQH <=", value, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhLike(String value) {
            addCriterion("YXQH like", value, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhNotLike(String value) {
            addCriterion("YXQH not like", value, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhIn(List<String> values) {
            addCriterion("YXQH in", values, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhNotIn(List<String> values) {
            addCriterion("YXQH not in", values, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhBetween(String value1, String value2) {
            addCriterion("YXQH between", value1, value2, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqhNotBetween(String value1, String value2) {
            addCriterion("YXQH not between", value1, value2, "yxqh");
            return (Criteria) this;
        }

        public Criteria andYxqrIsNull() {
            addCriterion("YXQR is null");
            return (Criteria) this;
        }

        public Criteria andYxqrIsNotNull() {
            addCriterion("YXQR is not null");
            return (Criteria) this;
        }

        public Criteria andYxqrEqualTo(String value) {
            addCriterion("YXQR =", value, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrNotEqualTo(String value) {
            addCriterion("YXQR <>", value, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrGreaterThan(String value) {
            addCriterion("YXQR >", value, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrGreaterThanOrEqualTo(String value) {
            addCriterion("YXQR >=", value, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrLessThan(String value) {
            addCriterion("YXQR <", value, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrLessThanOrEqualTo(String value) {
            addCriterion("YXQR <=", value, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrLike(String value) {
            addCriterion("YXQR like", value, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrNotLike(String value) {
            addCriterion("YXQR not like", value, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrIn(List<String> values) {
            addCriterion("YXQR in", values, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrNotIn(List<String> values) {
            addCriterion("YXQR not in", values, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrBetween(String value1, String value2) {
            addCriterion("YXQR between", value1, value2, "yxqr");
            return (Criteria) this;
        }

        public Criteria andYxqrNotBetween(String value1, String value2) {
            addCriterion("YXQR not between", value1, value2, "yxqr");
            return (Criteria) this;
        }

        public Criteria andDqflztIsNull() {
            addCriterion("DQFLZT is null");
            return (Criteria) this;
        }

        public Criteria andDqflztIsNotNull() {
            addCriterion("DQFLZT is not null");
            return (Criteria) this;
        }

        public Criteria andDqflztEqualTo(String value) {
            addCriterion("DQFLZT =", value, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztNotEqualTo(String value) {
            addCriterion("DQFLZT <>", value, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztGreaterThan(String value) {
            addCriterion("DQFLZT >", value, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztGreaterThanOrEqualTo(String value) {
            addCriterion("DQFLZT >=", value, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztLessThan(String value) {
            addCriterion("DQFLZT <", value, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztLessThanOrEqualTo(String value) {
            addCriterion("DQFLZT <=", value, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztLike(String value) {
            addCriterion("DQFLZT like", value, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztNotLike(String value) {
            addCriterion("DQFLZT not like", value, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztIn(List<String> values) {
            addCriterion("DQFLZT in", values, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztNotIn(List<String> values) {
            addCriterion("DQFLZT not in", values, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztBetween(String value1, String value2) {
            addCriterion("DQFLZT between", value1, value2, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andDqflztNotBetween(String value1, String value2) {
            addCriterion("DQFLZT not between", value1, value2, "dqflzt");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxIsNull() {
            addCriterion("FLZTLSXX is null");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxIsNotNull() {
            addCriterion("FLZTLSXX is not null");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxEqualTo(String value) {
            addCriterion("FLZTLSXX =", value, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxNotEqualTo(String value) {
            addCriterion("FLZTLSXX <>", value, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxGreaterThan(String value) {
            addCriterion("FLZTLSXX >", value, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxGreaterThanOrEqualTo(String value) {
            addCriterion("FLZTLSXX >=", value, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxLessThan(String value) {
            addCriterion("FLZTLSXX <", value, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxLessThanOrEqualTo(String value) {
            addCriterion("FLZTLSXX <=", value, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxLike(String value) {
            addCriterion("FLZTLSXX like", value, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxNotLike(String value) {
            addCriterion("FLZTLSXX not like", value, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxIn(List<String> values) {
            addCriterion("FLZTLSXX in", values, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxNotIn(List<String> values) {
            addCriterion("FLZTLSXX not in", values, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxBetween(String value1, String value2) {
            addCriterion("FLZTLSXX between", value1, value2, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztlsxxNotBetween(String value1, String value2) {
            addCriterion("FLZTLSXX not between", value1, value2, "flztlsxx");
            return (Criteria) this;
        }

        public Criteria andFlztggrqIsNull() {
            addCriterion("FLZTGGRQ is null");
            return (Criteria) this;
        }

        public Criteria andFlztggrqIsNotNull() {
            addCriterion("FLZTGGRQ is not null");
            return (Criteria) this;
        }

        public Criteria andFlztggrqEqualTo(String value) {
            addCriterion("FLZTGGRQ =", value, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqNotEqualTo(String value) {
            addCriterion("FLZTGGRQ <>", value, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqGreaterThan(String value) {
            addCriterion("FLZTGGRQ >", value, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqGreaterThanOrEqualTo(String value) {
            addCriterion("FLZTGGRQ >=", value, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqLessThan(String value) {
            addCriterion("FLZTGGRQ <", value, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqLessThanOrEqualTo(String value) {
            addCriterion("FLZTGGRQ <=", value, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqLike(String value) {
            addCriterion("FLZTGGRQ like", value, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqNotLike(String value) {
            addCriterion("FLZTGGRQ not like", value, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqIn(List<String> values) {
            addCriterion("FLZTGGRQ in", values, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqNotIn(List<String> values) {
            addCriterion("FLZTGGRQ not in", values, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqBetween(String value1, String value2) {
            addCriterion("FLZTGGRQ between", value1, value2, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztggrqNotBetween(String value1, String value2) {
            addCriterion("FLZTGGRQ not between", value1, value2, "flztggrq");
            return (Criteria) this;
        }

        public Criteria andFlztyjIsNull() {
            addCriterion("FLZTYJ is null");
            return (Criteria) this;
        }

        public Criteria andFlztyjIsNotNull() {
            addCriterion("FLZTYJ is not null");
            return (Criteria) this;
        }

        public Criteria andFlztyjEqualTo(String value) {
            addCriterion("FLZTYJ =", value, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjNotEqualTo(String value) {
            addCriterion("FLZTYJ <>", value, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjGreaterThan(String value) {
            addCriterion("FLZTYJ >", value, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjGreaterThanOrEqualTo(String value) {
            addCriterion("FLZTYJ >=", value, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjLessThan(String value) {
            addCriterion("FLZTYJ <", value, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjLessThanOrEqualTo(String value) {
            addCriterion("FLZTYJ <=", value, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjLike(String value) {
            addCriterion("FLZTYJ like", value, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjNotLike(String value) {
            addCriterion("FLZTYJ not like", value, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjIn(List<String> values) {
            addCriterion("FLZTYJ in", values, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjNotIn(List<String> values) {
            addCriterion("FLZTYJ not in", values, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjBetween(String value1, String value2) {
            addCriterion("FLZTYJ between", value1, value2, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztyjNotBetween(String value1, String value2) {
            addCriterion("FLZTYJ not between", value1, value2, "flztyj");
            return (Criteria) this;
        }

        public Criteria andFlztejIsNull() {
            addCriterion("FLZTEJ is null");
            return (Criteria) this;
        }

        public Criteria andFlztejIsNotNull() {
            addCriterion("FLZTEJ is not null");
            return (Criteria) this;
        }

        public Criteria andFlztejEqualTo(String value) {
            addCriterion("FLZTEJ =", value, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejNotEqualTo(String value) {
            addCriterion("FLZTEJ <>", value, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejGreaterThan(String value) {
            addCriterion("FLZTEJ >", value, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejGreaterThanOrEqualTo(String value) {
            addCriterion("FLZTEJ >=", value, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejLessThan(String value) {
            addCriterion("FLZTEJ <", value, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejLessThanOrEqualTo(String value) {
            addCriterion("FLZTEJ <=", value, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejLike(String value) {
            addCriterion("FLZTEJ like", value, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejNotLike(String value) {
            addCriterion("FLZTEJ not like", value, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejIn(List<String> values) {
            addCriterion("FLZTEJ in", values, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejNotIn(List<String> values) {
            addCriterion("FLZTEJ not in", values, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejBetween(String value1, String value2) {
            addCriterion("FLZTEJ between", value1, value2, "flztej");
            return (Criteria) this;
        }

        public Criteria andFlztejNotBetween(String value1, String value2) {
            addCriterion("FLZTEJ not between", value1, value2, "flztej");
            return (Criteria) this;
        }

        public Criteria andShouqrIsNull() {
            addCriterion("SHOUQR is null");
            return (Criteria) this;
        }

        public Criteria andShouqrIsNotNull() {
            addCriterion("SHOUQR is not null");
            return (Criteria) this;
        }

        public Criteria andShouqrEqualTo(String value) {
            addCriterion("SHOUQR =", value, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrNotEqualTo(String value) {
            addCriterion("SHOUQR <>", value, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrGreaterThan(String value) {
            addCriterion("SHOUQR >", value, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrGreaterThanOrEqualTo(String value) {
            addCriterion("SHOUQR >=", value, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrLessThan(String value) {
            addCriterion("SHOUQR <", value, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrLessThanOrEqualTo(String value) {
            addCriterion("SHOUQR <=", value, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrLike(String value) {
            addCriterion("SHOUQR like", value, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrNotLike(String value) {
            addCriterion("SHOUQR not like", value, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrIn(List<String> values) {
            addCriterion("SHOUQR in", values, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrNotIn(List<String> values) {
            addCriterion("SHOUQR not in", values, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrBetween(String value1, String value2) {
            addCriterion("SHOUQR between", value1, value2, "shouqr");
            return (Criteria) this;
        }

        public Criteria andShouqrNotBetween(String value1, String value2) {
            addCriterion("SHOUQR not between", value1, value2, "shouqr");
            return (Criteria) this;
        }

        public Criteria andSqgghIsNull() {
            addCriterion("SQGGH is null");
            return (Criteria) this;
        }

        public Criteria andSqgghIsNotNull() {
            addCriterion("SQGGH is not null");
            return (Criteria) this;
        }

        public Criteria andSqgghEqualTo(String value) {
            addCriterion("SQGGH =", value, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghNotEqualTo(String value) {
            addCriterion("SQGGH <>", value, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghGreaterThan(String value) {
            addCriterion("SQGGH >", value, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghGreaterThanOrEqualTo(String value) {
            addCriterion("SQGGH >=", value, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghLessThan(String value) {
            addCriterion("SQGGH <", value, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghLessThanOrEqualTo(String value) {
            addCriterion("SQGGH <=", value, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghLike(String value) {
            addCriterion("SQGGH like", value, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghNotLike(String value) {
            addCriterion("SQGGH not like", value, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghIn(List<String> values) {
            addCriterion("SQGGH in", values, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghNotIn(List<String> values) {
            addCriterion("SQGGH not in", values, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghBetween(String value1, String value2) {
            addCriterion("SQGGH between", value1, value2, "sqggh");
            return (Criteria) this;
        }

        public Criteria andSqgghNotBetween(String value1, String value2) {
            addCriterion("SQGGH not between", value1, value2, "sqggh");
            return (Criteria) this;
        }

        public Criteria andZshIsNull() {
            addCriterion("ZSH is null");
            return (Criteria) this;
        }

        public Criteria andZshIsNotNull() {
            addCriterion("ZSH is not null");
            return (Criteria) this;
        }

        public Criteria andZshEqualTo(String value) {
            addCriterion("ZSH =", value, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshNotEqualTo(String value) {
            addCriterion("ZSH <>", value, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshGreaterThan(String value) {
            addCriterion("ZSH >", value, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshGreaterThanOrEqualTo(String value) {
            addCriterion("ZSH >=", value, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshLessThan(String value) {
            addCriterion("ZSH <", value, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshLessThanOrEqualTo(String value) {
            addCriterion("ZSH <=", value, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshLike(String value) {
            addCriterion("ZSH like", value, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshNotLike(String value) {
            addCriterion("ZSH not like", value, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshIn(List<String> values) {
            addCriterion("ZSH in", values, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshNotIn(List<String> values) {
            addCriterion("ZSH not in", values, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshBetween(String value1, String value2) {
            addCriterion("ZSH between", value1, value2, "zsh");
            return (Criteria) this;
        }

        public Criteria andZshNotBetween(String value1, String value2) {
            addCriterion("ZSH not between", value1, value2, "zsh");
            return (Criteria) this;
        }

        public Criteria andZlqrIsNull() {
            addCriterion("ZLQR is null");
            return (Criteria) this;
        }

        public Criteria andZlqrIsNotNull() {
            addCriterion("ZLQR is not null");
            return (Criteria) this;
        }

        public Criteria andZlqrEqualTo(String value) {
            addCriterion("ZLQR =", value, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrNotEqualTo(String value) {
            addCriterion("ZLQR <>", value, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrGreaterThan(String value) {
            addCriterion("ZLQR >", value, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrGreaterThanOrEqualTo(String value) {
            addCriterion("ZLQR >=", value, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrLessThan(String value) {
            addCriterion("ZLQR <", value, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrLessThanOrEqualTo(String value) {
            addCriterion("ZLQR <=", value, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrLike(String value) {
            addCriterion("ZLQR like", value, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrNotLike(String value) {
            addCriterion("ZLQR not like", value, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrIn(List<String> values) {
            addCriterion("ZLQR in", values, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrNotIn(List<String> values) {
            addCriterion("ZLQR not in", values, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrBetween(String value1, String value2) {
            addCriterion("ZLQR between", value1, value2, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlqrNotBetween(String value1, String value2) {
            addCriterion("ZLQR not between", value1, value2, "zlqr");
            return (Criteria) this;
        }

        public Criteria andZlhIsNull() {
            addCriterion("ZLH is null");
            return (Criteria) this;
        }

        public Criteria andZlhIsNotNull() {
            addCriterion("ZLH is not null");
            return (Criteria) this;
        }

        public Criteria andZlhEqualTo(String value) {
            addCriterion("ZLH =", value, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhNotEqualTo(String value) {
            addCriterion("ZLH <>", value, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhGreaterThan(String value) {
            addCriterion("ZLH >", value, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhGreaterThanOrEqualTo(String value) {
            addCriterion("ZLH >=", value, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhLessThan(String value) {
            addCriterion("ZLH <", value, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhLessThanOrEqualTo(String value) {
            addCriterion("ZLH <=", value, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhLike(String value) {
            addCriterion("ZLH like", value, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhNotLike(String value) {
            addCriterion("ZLH not like", value, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhIn(List<String> values) {
            addCriterion("ZLH in", values, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhNotIn(List<String> values) {
            addCriterion("ZLH not in", values, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhBetween(String value1, String value2) {
            addCriterion("ZLH between", value1, value2, "zlh");
            return (Criteria) this;
        }

        public Criteria andZlhNotBetween(String value1, String value2) {
            addCriterion("ZLH not between", value1, value2, "zlh");
            return (Criteria) this;
        }

        public Criteria andQlyqIsNull() {
            addCriterion("QLYQ is null");
            return (Criteria) this;
        }

        public Criteria andQlyqIsNotNull() {
            addCriterion("QLYQ is not null");
            return (Criteria) this;
        }

        public Criteria andQlyqEqualTo(String value) {
            addCriterion("QLYQ =", value, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqNotEqualTo(String value) {
            addCriterion("QLYQ <>", value, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqGreaterThan(String value) {
            addCriterion("QLYQ >", value, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqGreaterThanOrEqualTo(String value) {
            addCriterion("QLYQ >=", value, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqLessThan(String value) {
            addCriterion("QLYQ <", value, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqLessThanOrEqualTo(String value) {
            addCriterion("QLYQ <=", value, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqLike(String value) {
            addCriterion("QLYQ like", value, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqNotLike(String value) {
            addCriterion("QLYQ not like", value, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqIn(List<String> values) {
            addCriterion("QLYQ in", values, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqNotIn(List<String> values) {
            addCriterion("QLYQ not in", values, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqBetween(String value1, String value2) {
            addCriterion("QLYQ between", value1, value2, "qlyq");
            return (Criteria) this;
        }

        public Criteria andQlyqNotBetween(String value1, String value2) {
            addCriterion("QLYQ not between", value1, value2, "qlyq");
            return (Criteria) this;
        }

        public Criteria andZlpdfIsNull() {
            addCriterion("ZLPDF is null");
            return (Criteria) this;
        }

        public Criteria andZlpdfIsNotNull() {
            addCriterion("ZLPDF is not null");
            return (Criteria) this;
        }

        public Criteria andZlpdfEqualTo(String value) {
            addCriterion("ZLPDF =", value, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfNotEqualTo(String value) {
            addCriterion("ZLPDF <>", value, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfGreaterThan(String value) {
            addCriterion("ZLPDF >", value, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfGreaterThanOrEqualTo(String value) {
            addCriterion("ZLPDF >=", value, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfLessThan(String value) {
            addCriterion("ZLPDF <", value, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfLessThanOrEqualTo(String value) {
            addCriterion("ZLPDF <=", value, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfLike(String value) {
            addCriterion("ZLPDF like", value, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfNotLike(String value) {
            addCriterion("ZLPDF not like", value, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfIn(List<String> values) {
            addCriterion("ZLPDF in", values, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfNotIn(List<String> values) {
            addCriterion("ZLPDF not in", values, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfBetween(String value1, String value2) {
            addCriterion("ZLPDF between", value1, value2, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andZlpdfNotBetween(String value1, String value2) {
            addCriterion("ZLPDF not between", value1, value2, "zlpdf");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrIsNull() {
            addCriterion("SCYJTZSFWR is null");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrIsNotNull() {
            addCriterion("SCYJTZSFWR is not null");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrEqualTo(String value) {
            addCriterion("SCYJTZSFWR =", value, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrNotEqualTo(String value) {
            addCriterion("SCYJTZSFWR <>", value, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrGreaterThan(String value) {
            addCriterion("SCYJTZSFWR >", value, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrGreaterThanOrEqualTo(String value) {
            addCriterion("SCYJTZSFWR >=", value, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrLessThan(String value) {
            addCriterion("SCYJTZSFWR <", value, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrLessThanOrEqualTo(String value) {
            addCriterion("SCYJTZSFWR <=", value, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrLike(String value) {
            addCriterion("SCYJTZSFWR like", value, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrNotLike(String value) {
            addCriterion("SCYJTZSFWR not like", value, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrIn(List<String> values) {
            addCriterion("SCYJTZSFWR in", values, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrNotIn(List<String> values) {
            addCriterion("SCYJTZSFWR not in", values, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrBetween(String value1, String value2) {
            addCriterion("SCYJTZSFWR between", value1, value2, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjtzsfwrNotBetween(String value1, String value2) {
            addCriterion("SCYJTZSFWR not between", value1, value2, "scyjtzsfwr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrIsNull() {
            addCriterion("SCYJDFR is null");
            return (Criteria) this;
        }

        public Criteria andScyjdfrIsNotNull() {
            addCriterion("SCYJDFR is not null");
            return (Criteria) this;
        }

        public Criteria andScyjdfrEqualTo(String value) {
            addCriterion("SCYJDFR =", value, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrNotEqualTo(String value) {
            addCriterion("SCYJDFR <>", value, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrGreaterThan(String value) {
            addCriterion("SCYJDFR >", value, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrGreaterThanOrEqualTo(String value) {
            addCriterion("SCYJDFR >=", value, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrLessThan(String value) {
            addCriterion("SCYJDFR <", value, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrLessThanOrEqualTo(String value) {
            addCriterion("SCYJDFR <=", value, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrLike(String value) {
            addCriterion("SCYJDFR like", value, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrNotLike(String value) {
            addCriterion("SCYJDFR not like", value, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrIn(List<String> values) {
            addCriterion("SCYJDFR in", values, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrNotIn(List<String> values) {
            addCriterion("SCYJDFR not in", values, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrBetween(String value1, String value2) {
            addCriterion("SCYJDFR between", value1, value2, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjdfrNotBetween(String value1, String value2) {
            addCriterion("SCYJDFR not between", value1, value2, "scyjdfr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrIsNull() {
            addCriterion("SCYJBZR is null");
            return (Criteria) this;
        }

        public Criteria andScyjbzrIsNotNull() {
            addCriterion("SCYJBZR is not null");
            return (Criteria) this;
        }

        public Criteria andScyjbzrEqualTo(String value) {
            addCriterion("SCYJBZR =", value, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrNotEqualTo(String value) {
            addCriterion("SCYJBZR <>", value, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrGreaterThan(String value) {
            addCriterion("SCYJBZR >", value, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrGreaterThanOrEqualTo(String value) {
            addCriterion("SCYJBZR >=", value, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrLessThan(String value) {
            addCriterion("SCYJBZR <", value, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrLessThanOrEqualTo(String value) {
            addCriterion("SCYJBZR <=", value, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrLike(String value) {
            addCriterion("SCYJBZR like", value, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrNotLike(String value) {
            addCriterion("SCYJBZR not like", value, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrIn(List<String> values) {
            addCriterion("SCYJBZR in", values, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrNotIn(List<String> values) {
            addCriterion("SCYJBZR not in", values, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrBetween(String value1, String value2) {
            addCriterion("SCYJBZR between", value1, value2, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andScyjbzrNotBetween(String value1, String value2) {
            addCriterion("SCYJBZR not between", value1, value2, "scyjbzr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrIsNull() {
            addCriterion("BZTZFFWR is null");
            return (Criteria) this;
        }

        public Criteria andBztzffwrIsNotNull() {
            addCriterion("BZTZFFWR is not null");
            return (Criteria) this;
        }

        public Criteria andBztzffwrEqualTo(String value) {
            addCriterion("BZTZFFWR =", value, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrNotEqualTo(String value) {
            addCriterion("BZTZFFWR <>", value, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrGreaterThan(String value) {
            addCriterion("BZTZFFWR >", value, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrGreaterThanOrEqualTo(String value) {
            addCriterion("BZTZFFWR >=", value, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrLessThan(String value) {
            addCriterion("BZTZFFWR <", value, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrLessThanOrEqualTo(String value) {
            addCriterion("BZTZFFWR <=", value, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrLike(String value) {
            addCriterion("BZTZFFWR like", value, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrNotLike(String value) {
            addCriterion("BZTZFFWR not like", value, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrIn(List<String> values) {
            addCriterion("BZTZFFWR in", values, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrNotIn(List<String> values) {
            addCriterion("BZTZFFWR not in", values, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrBetween(String value1, String value2) {
            addCriterion("BZTZFFWR between", value1, value2, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBztzffwrNotBetween(String value1, String value2) {
            addCriterion("BZTZFFWR not between", value1, value2, "bztzffwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrIsNull() {
            addCriterion("BHTZSFWR is null");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrIsNotNull() {
            addCriterion("BHTZSFWR is not null");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrEqualTo(String value) {
            addCriterion("BHTZSFWR =", value, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrNotEqualTo(String value) {
            addCriterion("BHTZSFWR <>", value, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrGreaterThan(String value) {
            addCriterion("BHTZSFWR >", value, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrGreaterThanOrEqualTo(String value) {
            addCriterion("BHTZSFWR >=", value, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrLessThan(String value) {
            addCriterion("BHTZSFWR <", value, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrLessThanOrEqualTo(String value) {
            addCriterion("BHTZSFWR <=", value, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrLike(String value) {
            addCriterion("BHTZSFWR like", value, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrNotLike(String value) {
            addCriterion("BHTZSFWR not like", value, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrIn(List<String> values) {
            addCriterion("BHTZSFWR in", values, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrNotIn(List<String> values) {
            addCriterion("BHTZSFWR not in", values, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrBetween(String value1, String value2) {
            addCriterion("BHTZSFWR between", value1, value2, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andBhtzsfwrNotBetween(String value1, String value2) {
            addCriterion("BHTZSFWR not between", value1, value2, "bhtzsfwr");
            return (Criteria) this;
        }

        public Criteria andFsqqrIsNull() {
            addCriterion("FSQQR is null");
            return (Criteria) this;
        }

        public Criteria andFsqqrIsNotNull() {
            addCriterion("FSQQR is not null");
            return (Criteria) this;
        }

        public Criteria andFsqqrEqualTo(String value) {
            addCriterion("FSQQR =", value, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrNotEqualTo(String value) {
            addCriterion("FSQQR <>", value, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrGreaterThan(String value) {
            addCriterion("FSQQR >", value, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrGreaterThanOrEqualTo(String value) {
            addCriterion("FSQQR >=", value, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrLessThan(String value) {
            addCriterion("FSQQR <", value, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrLessThanOrEqualTo(String value) {
            addCriterion("FSQQR <=", value, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrLike(String value) {
            addCriterion("FSQQR like", value, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrNotLike(String value) {
            addCriterion("FSQQR not like", value, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrIn(List<String> values) {
            addCriterion("FSQQR in", values, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrNotIn(List<String> values) {
            addCriterion("FSQQR not in", values, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrBetween(String value1, String value2) {
            addCriterion("FSQQR between", value1, value2, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsqqrNotBetween(String value1, String value2) {
            addCriterion("FSQQR not between", value1, value2, "fsqqr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrIsNull() {
            addCriterion("FSSLFWR is null");
            return (Criteria) this;
        }

        public Criteria andFsslfwrIsNotNull() {
            addCriterion("FSSLFWR is not null");
            return (Criteria) this;
        }

        public Criteria andFsslfwrEqualTo(String value) {
            addCriterion("FSSLFWR =", value, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrNotEqualTo(String value) {
            addCriterion("FSSLFWR <>", value, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrGreaterThan(String value) {
            addCriterion("FSSLFWR >", value, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrGreaterThanOrEqualTo(String value) {
            addCriterion("FSSLFWR >=", value, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrLessThan(String value) {
            addCriterion("FSSLFWR <", value, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrLessThanOrEqualTo(String value) {
            addCriterion("FSSLFWR <=", value, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrLike(String value) {
            addCriterion("FSSLFWR like", value, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrNotLike(String value) {
            addCriterion("FSSLFWR not like", value, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrIn(List<String> values) {
            addCriterion("FSSLFWR in", values, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrNotIn(List<String> values) {
            addCriterion("FSSLFWR not in", values, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrBetween(String value1, String value2) {
            addCriterion("FSSLFWR between", value1, value2, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andFsslfwrNotBetween(String value1, String value2) {
            addCriterion("FSSLFWR not between", value1, value2, "fsslfwr");
            return (Criteria) this;
        }

        public Criteria andDfgcwjIsNull() {
            addCriterion("DFGCWJ is null");
            return (Criteria) this;
        }

        public Criteria andDfgcwjIsNotNull() {
            addCriterion("DFGCWJ is not null");
            return (Criteria) this;
        }

        public Criteria andDfgcwjEqualTo(String value) {
            addCriterion("DFGCWJ =", value, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjNotEqualTo(String value) {
            addCriterion("DFGCWJ <>", value, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjGreaterThan(String value) {
            addCriterion("DFGCWJ >", value, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjGreaterThanOrEqualTo(String value) {
            addCriterion("DFGCWJ >=", value, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjLessThan(String value) {
            addCriterion("DFGCWJ <", value, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjLessThanOrEqualTo(String value) {
            addCriterion("DFGCWJ <=", value, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjLike(String value) {
            addCriterion("DFGCWJ like", value, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjNotLike(String value) {
            addCriterion("DFGCWJ not like", value, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjIn(List<String> values) {
            addCriterion("DFGCWJ in", values, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjNotIn(List<String> values) {
            addCriterion("DFGCWJ not in", values, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjBetween(String value1, String value2) {
            addCriterion("DFGCWJ between", value1, value2, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andDfgcwjNotBetween(String value1, String value2) {
            addCriterion("DFGCWJ not between", value1, value2, "dfgcwj");
            return (Criteria) this;
        }

        public Criteria andSqbzIsNull() {
            addCriterion("SQBZ is null");
            return (Criteria) this;
        }

        public Criteria andSqbzIsNotNull() {
            addCriterion("SQBZ is not null");
            return (Criteria) this;
        }

        public Criteria andSqbzEqualTo(String value) {
            addCriterion("SQBZ =", value, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzNotEqualTo(String value) {
            addCriterion("SQBZ <>", value, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzGreaterThan(String value) {
            addCriterion("SQBZ >", value, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzGreaterThanOrEqualTo(String value) {
            addCriterion("SQBZ >=", value, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzLessThan(String value) {
            addCriterion("SQBZ <", value, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzLessThanOrEqualTo(String value) {
            addCriterion("SQBZ <=", value, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzLike(String value) {
            addCriterion("SQBZ like", value, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzNotLike(String value) {
            addCriterion("SQBZ not like", value, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzIn(List<String> values) {
            addCriterion("SQBZ in", values, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzNotIn(List<String> values) {
            addCriterion("SQBZ not in", values, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzBetween(String value1, String value2) {
            addCriterion("SQBZ between", value1, value2, "sqbz");
            return (Criteria) this;
        }

        public Criteria andSqbzNotBetween(String value1, String value2) {
            addCriterion("SQBZ not between", value1, value2, "sqbz");
            return (Criteria) this;
        }

        public Criteria andRksjIsNull() {
            addCriterion("RKSJ is null");
            return (Criteria) this;
        }

        public Criteria andRksjIsNotNull() {
            addCriterion("RKSJ is not null");
            return (Criteria) this;
        }

        public Criteria andRksjEqualTo(String value) {
            addCriterion("RKSJ =", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjNotEqualTo(String value) {
            addCriterion("RKSJ <>", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjGreaterThan(String value) {
            addCriterion("RKSJ >", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjGreaterThanOrEqualTo(String value) {
            addCriterion("RKSJ >=", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjLessThan(String value) {
            addCriterion("RKSJ <", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjLessThanOrEqualTo(String value) {
            addCriterion("RKSJ <=", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjLike(String value) {
            addCriterion("RKSJ like", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjNotLike(String value) {
            addCriterion("RKSJ not like", value, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjIn(List<String> values) {
            addCriterion("RKSJ in", values, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjNotIn(List<String> values) {
            addCriterion("RKSJ not in", values, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjBetween(String value1, String value2) {
            addCriterion("RKSJ between", value1, value2, "rksj");
            return (Criteria) this;
        }

        public Criteria andRksjNotBetween(String value1, String value2) {
            addCriterion("RKSJ not between", value1, value2, "rksj");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlIsNull() {
            addCriterion("GMJJHYML is null");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlIsNotNull() {
            addCriterion("GMJJHYML is not null");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlEqualTo(String value) {
            addCriterion("GMJJHYML =", value, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlNotEqualTo(String value) {
            addCriterion("GMJJHYML <>", value, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlGreaterThan(String value) {
            addCriterion("GMJJHYML >", value, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlGreaterThanOrEqualTo(String value) {
            addCriterion("GMJJHYML >=", value, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlLessThan(String value) {
            addCriterion("GMJJHYML <", value, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlLessThanOrEqualTo(String value) {
            addCriterion("GMJJHYML <=", value, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlLike(String value) {
            addCriterion("GMJJHYML like", value, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlNotLike(String value) {
            addCriterion("GMJJHYML not like", value, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlIn(List<String> values) {
            addCriterion("GMJJHYML in", values, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlNotIn(List<String> values) {
            addCriterion("GMJJHYML not in", values, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlBetween(String value1, String value2) {
            addCriterion("GMJJHYML between", value1, value2, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhymlNotBetween(String value1, String value2) {
            addCriterion("GMJJHYML not between", value1, value2, "gmjjhyml");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlIsNull() {
            addCriterion("GMJJHYDL is null");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlIsNotNull() {
            addCriterion("GMJJHYDL is not null");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlEqualTo(String value) {
            addCriterion("GMJJHYDL =", value, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlNotEqualTo(String value) {
            addCriterion("GMJJHYDL <>", value, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlGreaterThan(String value) {
            addCriterion("GMJJHYDL >", value, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlGreaterThanOrEqualTo(String value) {
            addCriterion("GMJJHYDL >=", value, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlLessThan(String value) {
            addCriterion("GMJJHYDL <", value, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlLessThanOrEqualTo(String value) {
            addCriterion("GMJJHYDL <=", value, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlLike(String value) {
            addCriterion("GMJJHYDL like", value, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlNotLike(String value) {
            addCriterion("GMJJHYDL not like", value, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlIn(List<String> values) {
            addCriterion("GMJJHYDL in", values, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlNotIn(List<String> values) {
            addCriterion("GMJJHYDL not in", values, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlBetween(String value1, String value2) {
            addCriterion("GMJJHYDL between", value1, value2, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhydlNotBetween(String value1, String value2) {
            addCriterion("GMJJHYDL not between", value1, value2, "gmjjhydl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlIsNull() {
            addCriterion("GMJJHYZL is null");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlIsNotNull() {
            addCriterion("GMJJHYZL is not null");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlEqualTo(String value) {
            addCriterion("GMJJHYZL =", value, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlNotEqualTo(String value) {
            addCriterion("GMJJHYZL <>", value, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlGreaterThan(String value) {
            addCriterion("GMJJHYZL >", value, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlGreaterThanOrEqualTo(String value) {
            addCriterion("GMJJHYZL >=", value, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlLessThan(String value) {
            addCriterion("GMJJHYZL <", value, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlLessThanOrEqualTo(String value) {
            addCriterion("GMJJHYZL <=", value, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlLike(String value) {
            addCriterion("GMJJHYZL like", value, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlNotLike(String value) {
            addCriterion("GMJJHYZL not like", value, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlIn(List<String> values) {
            addCriterion("GMJJHYZL in", values, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlNotIn(List<String> values) {
            addCriterion("GMJJHYZL not in", values, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlBetween(String value1, String value2) {
            addCriterion("GMJJHYZL between", value1, value2, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyzlNotBetween(String value1, String value2) {
            addCriterion("GMJJHYZL not between", value1, value2, "gmjjhyzl");
            return (Criteria) this;
        }

        public Criteria andZxcyyjIsNull() {
            addCriterion("ZXCYYJ is null");
            return (Criteria) this;
        }

        public Criteria andZxcyyjIsNotNull() {
            addCriterion("ZXCYYJ is not null");
            return (Criteria) this;
        }

        public Criteria andZxcyyjEqualTo(String value) {
            addCriterion("ZXCYYJ =", value, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjNotEqualTo(String value) {
            addCriterion("ZXCYYJ <>", value, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjGreaterThan(String value) {
            addCriterion("ZXCYYJ >", value, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjGreaterThanOrEqualTo(String value) {
            addCriterion("ZXCYYJ >=", value, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjLessThan(String value) {
            addCriterion("ZXCYYJ <", value, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjLessThanOrEqualTo(String value) {
            addCriterion("ZXCYYJ <=", value, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjLike(String value) {
            addCriterion("ZXCYYJ like", value, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjNotLike(String value) {
            addCriterion("ZXCYYJ not like", value, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjIn(List<String> values) {
            addCriterion("ZXCYYJ in", values, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjNotIn(List<String> values) {
            addCriterion("ZXCYYJ not in", values, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjBetween(String value1, String value2) {
            addCriterion("ZXCYYJ between", value1, value2, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyyjNotBetween(String value1, String value2) {
            addCriterion("ZXCYYJ not between", value1, value2, "zxcyyj");
            return (Criteria) this;
        }

        public Criteria andZxcyejIsNull() {
            addCriterion("ZXCYEJ is null");
            return (Criteria) this;
        }

        public Criteria andZxcyejIsNotNull() {
            addCriterion("ZXCYEJ is not null");
            return (Criteria) this;
        }

        public Criteria andZxcyejEqualTo(String value) {
            addCriterion("ZXCYEJ =", value, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejNotEqualTo(String value) {
            addCriterion("ZXCYEJ <>", value, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejGreaterThan(String value) {
            addCriterion("ZXCYEJ >", value, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejGreaterThanOrEqualTo(String value) {
            addCriterion("ZXCYEJ >=", value, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejLessThan(String value) {
            addCriterion("ZXCYEJ <", value, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejLessThanOrEqualTo(String value) {
            addCriterion("ZXCYEJ <=", value, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejLike(String value) {
            addCriterion("ZXCYEJ like", value, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejNotLike(String value) {
            addCriterion("ZXCYEJ not like", value, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejIn(List<String> values) {
            addCriterion("ZXCYEJ in", values, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejNotIn(List<String> values) {
            addCriterion("ZXCYEJ not in", values, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejBetween(String value1, String value2) {
            addCriterion("ZXCYEJ between", value1, value2, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcyejNotBetween(String value1, String value2) {
            addCriterion("ZXCYEJ not between", value1, value2, "zxcyej");
            return (Criteria) this;
        }

        public Criteria andZxcysjIsNull() {
            addCriterion("ZXCYSJ is null");
            return (Criteria) this;
        }

        public Criteria andZxcysjIsNotNull() {
            addCriterion("ZXCYSJ is not null");
            return (Criteria) this;
        }

        public Criteria andZxcysjEqualTo(String value) {
            addCriterion("ZXCYSJ =", value, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjNotEqualTo(String value) {
            addCriterion("ZXCYSJ <>", value, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjGreaterThan(String value) {
            addCriterion("ZXCYSJ >", value, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjGreaterThanOrEqualTo(String value) {
            addCriterion("ZXCYSJ >=", value, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjLessThan(String value) {
            addCriterion("ZXCYSJ <", value, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjLessThanOrEqualTo(String value) {
            addCriterion("ZXCYSJ <=", value, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjLike(String value) {
            addCriterion("ZXCYSJ like", value, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjNotLike(String value) {
            addCriterion("ZXCYSJ not like", value, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjIn(List<String> values) {
            addCriterion("ZXCYSJ in", values, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjNotIn(List<String> values) {
            addCriterion("ZXCYSJ not in", values, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjBetween(String value1, String value2) {
            addCriterion("ZXCYSJ between", value1, value2, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andZxcysjNotBetween(String value1, String value2) {
            addCriterion("ZXCYSJ not between", value1, value2, "zxcysj");
            return (Criteria) this;
        }

        public Criteria andByzcsIsNull() {
            addCriterion("BYZCS is null");
            return (Criteria) this;
        }

        public Criteria andByzcsIsNotNull() {
            addCriterion("BYZCS is not null");
            return (Criteria) this;
        }

        public Criteria andByzcsEqualTo(String value) {
            addCriterion("BYZCS =", value, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsNotEqualTo(String value) {
            addCriterion("BYZCS <>", value, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsGreaterThan(String value) {
            addCriterion("BYZCS >", value, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsGreaterThanOrEqualTo(String value) {
            addCriterion("BYZCS >=", value, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsLessThan(String value) {
            addCriterion("BYZCS <", value, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsLessThanOrEqualTo(String value) {
            addCriterion("BYZCS <=", value, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsLike(String value) {
            addCriterion("BYZCS like", value, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsNotLike(String value) {
            addCriterion("BYZCS not like", value, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsIn(List<String> values) {
            addCriterion("BYZCS in", values, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsNotIn(List<String> values) {
            addCriterion("BYZCS not in", values, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsBetween(String value1, String value2) {
            addCriterion("BYZCS between", value1, value2, "byzcs");
            return (Criteria) this;
        }

        public Criteria andByzcsNotBetween(String value1, String value2) {
            addCriterion("BYZCS not between", value1, value2, "byzcs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsIsNull() {
            addCriterion("BFMRYYCS is null");
            return (Criteria) this;
        }

        public Criteria andBfmryycsIsNotNull() {
            addCriterion("BFMRYYCS is not null");
            return (Criteria) this;
        }

        public Criteria andBfmryycsEqualTo(String value) {
            addCriterion("BFMRYYCS =", value, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsNotEqualTo(String value) {
            addCriterion("BFMRYYCS <>", value, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsGreaterThan(String value) {
            addCriterion("BFMRYYCS >", value, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsGreaterThanOrEqualTo(String value) {
            addCriterion("BFMRYYCS >=", value, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsLessThan(String value) {
            addCriterion("BFMRYYCS <", value, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsLessThanOrEqualTo(String value) {
            addCriterion("BFMRYYCS <=", value, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsLike(String value) {
            addCriterion("BFMRYYCS like", value, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsNotLike(String value) {
            addCriterion("BFMRYYCS not like", value, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsIn(List<String> values) {
            addCriterion("BFMRYYCS in", values, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsNotIn(List<String> values) {
            addCriterion("BFMRYYCS not in", values, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsBetween(String value1, String value2) {
            addCriterion("BFMRYYCS between", value1, value2, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBfmryycsNotBetween(String value1, String value2) {
            addCriterion("BFMRYYCS not between", value1, value2, "bfmryycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsIsNull() {
            addCriterion("BSCYYYCS is null");
            return (Criteria) this;
        }

        public Criteria andBscyyycsIsNotNull() {
            addCriterion("BSCYYYCS is not null");
            return (Criteria) this;
        }

        public Criteria andBscyyycsEqualTo(String value) {
            addCriterion("BSCYYYCS =", value, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsNotEqualTo(String value) {
            addCriterion("BSCYYYCS <>", value, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsGreaterThan(String value) {
            addCriterion("BSCYYYCS >", value, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsGreaterThanOrEqualTo(String value) {
            addCriterion("BSCYYYCS >=", value, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsLessThan(String value) {
            addCriterion("BSCYYYCS <", value, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsLessThanOrEqualTo(String value) {
            addCriterion("BSCYYYCS <=", value, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsLike(String value) {
            addCriterion("BSCYYYCS like", value, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsNotLike(String value) {
            addCriterion("BSCYYYCS not like", value, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsIn(List<String> values) {
            addCriterion("BSCYYYCS in", values, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsNotIn(List<String> values) {
            addCriterion("BSCYYYCS not in", values, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsBetween(String value1, String value2) {
            addCriterion("BSCYYYCS between", value1, value2, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andBscyyycsNotBetween(String value1, String value2) {
            addCriterion("BSCYYYCS not between", value1, value2, "bscyyycs");
            return (Criteria) this;
        }

        public Criteria andZycsIsNull() {
            addCriterion("ZYCS is null");
            return (Criteria) this;
        }

        public Criteria andZycsIsNotNull() {
            addCriterion("ZYCS is not null");
            return (Criteria) this;
        }

        public Criteria andZycsEqualTo(String value) {
            addCriterion("ZYCS =", value, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsNotEqualTo(String value) {
            addCriterion("ZYCS <>", value, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsGreaterThan(String value) {
            addCriterion("ZYCS >", value, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsGreaterThanOrEqualTo(String value) {
            addCriterion("ZYCS >=", value, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsLessThan(String value) {
            addCriterion("ZYCS <", value, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsLessThanOrEqualTo(String value) {
            addCriterion("ZYCS <=", value, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsLike(String value) {
            addCriterion("ZYCS like", value, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsNotLike(String value) {
            addCriterion("ZYCS not like", value, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsIn(List<String> values) {
            addCriterion("ZYCS in", values, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsNotIn(List<String> values) {
            addCriterion("ZYCS not in", values, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsBetween(String value1, String value2) {
            addCriterion("ZYCS between", value1, value2, "zycs");
            return (Criteria) this;
        }

        public Criteria andZycsNotBetween(String value1, String value2) {
            addCriterion("ZYCS not between", value1, value2, "zycs");
            return (Criteria) this;
        }

        public Criteria andTycsIsNull() {
            addCriterion("TYCS is null");
            return (Criteria) this;
        }

        public Criteria andTycsIsNotNull() {
            addCriterion("TYCS is not null");
            return (Criteria) this;
        }

        public Criteria andTycsEqualTo(String value) {
            addCriterion("TYCS =", value, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsNotEqualTo(String value) {
            addCriterion("TYCS <>", value, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsGreaterThan(String value) {
            addCriterion("TYCS >", value, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsGreaterThanOrEqualTo(String value) {
            addCriterion("TYCS >=", value, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsLessThan(String value) {
            addCriterion("TYCS <", value, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsLessThanOrEqualTo(String value) {
            addCriterion("TYCS <=", value, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsLike(String value) {
            addCriterion("TYCS like", value, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsNotLike(String value) {
            addCriterion("TYCS not like", value, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsIn(List<String> values) {
            addCriterion("TYCS in", values, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsNotIn(List<String> values) {
            addCriterion("TYCS not in", values, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsBetween(String value1, String value2) {
            addCriterion("TYCS between", value1, value2, "tycs");
            return (Criteria) this;
        }

        public Criteria andTycsNotBetween(String value1, String value2) {
            addCriterion("TYCS not between", value1, value2, "tycs");
            return (Criteria) this;
        }

        public Criteria andSqrdmIsNull() {
            addCriterion("SQRDM is null");
            return (Criteria) this;
        }

        public Criteria andSqrdmIsNotNull() {
            addCriterion("SQRDM is not null");
            return (Criteria) this;
        }

        public Criteria andSqrdmEqualTo(String value) {
            addCriterion("SQRDM =", value, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmNotEqualTo(String value) {
            addCriterion("SQRDM <>", value, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmGreaterThan(String value) {
            addCriterion("SQRDM >", value, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmGreaterThanOrEqualTo(String value) {
            addCriterion("SQRDM >=", value, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmLessThan(String value) {
            addCriterion("SQRDM <", value, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmLessThanOrEqualTo(String value) {
            addCriterion("SQRDM <=", value, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmLike(String value) {
            addCriterion("SQRDM like", value, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmNotLike(String value) {
            addCriterion("SQRDM not like", value, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmIn(List<String> values) {
            addCriterion("SQRDM in", values, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmNotIn(List<String> values) {
            addCriterion("SQRDM not in", values, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmBetween(String value1, String value2) {
            addCriterion("SQRDM between", value1, value2, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andSqrdmNotBetween(String value1, String value2) {
            addCriterion("SQRDM not between", value1, value2, "sqrdm");
            return (Criteria) this;
        }

        public Criteria andJghdmcIsNull() {
            addCriterion("JGHDMC is null");
            return (Criteria) this;
        }

        public Criteria andJghdmcIsNotNull() {
            addCriterion("JGHDMC is not null");
            return (Criteria) this;
        }

        public Criteria andJghdmcEqualTo(String value) {
            addCriterion("JGHDMC =", value, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcNotEqualTo(String value) {
            addCriterion("JGHDMC <>", value, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcGreaterThan(String value) {
            addCriterion("JGHDMC >", value, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcGreaterThanOrEqualTo(String value) {
            addCriterion("JGHDMC >=", value, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcLessThan(String value) {
            addCriterion("JGHDMC <", value, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcLessThanOrEqualTo(String value) {
            addCriterion("JGHDMC <=", value, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcLike(String value) {
            addCriterion("JGHDMC like", value, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcNotLike(String value) {
            addCriterion("JGHDMC not like", value, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcIn(List<String> values) {
            addCriterion("JGHDMC in", values, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcNotIn(List<String> values) {
            addCriterion("JGHDMC not in", values, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcBetween(String value1, String value2) {
            addCriterion("JGHDMC between", value1, value2, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJghdmcNotBetween(String value1, String value2) {
            addCriterion("JGHDMC not between", value1, value2, "jghdmc");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgIsNull() {
            addCriterion("JSWTHYYXG is null");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgIsNotNull() {
            addCriterion("JSWTHYYXG is not null");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgEqualTo(String value) {
            addCriterion("JSWTHYYXG =", value, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgNotEqualTo(String value) {
            addCriterion("JSWTHYYXG <>", value, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgGreaterThan(String value) {
            addCriterion("JSWTHYYXG >", value, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgGreaterThanOrEqualTo(String value) {
            addCriterion("JSWTHYYXG >=", value, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgLessThan(String value) {
            addCriterion("JSWTHYYXG <", value, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgLessThanOrEqualTo(String value) {
            addCriterion("JSWTHYYXG <=", value, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgLike(String value) {
            addCriterion("JSWTHYYXG like", value, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgNotLike(String value) {
            addCriterion("JSWTHYYXG not like", value, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgIn(List<String> values) {
            addCriterion("JSWTHYYXG in", values, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgNotIn(List<String> values) {
            addCriterion("JSWTHYYXG not in", values, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgBetween(String value1, String value2) {
            addCriterion("JSWTHYYXG between", value1, value2, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andJswthyyxgNotBetween(String value1, String value2) {
            addCriterion("JSWTHYYXG not between", value1, value2, "jswthyyxg");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaIsNull() {
            addCriterion("FMDHHXFA is null");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaIsNotNull() {
            addCriterion("FMDHHXFA is not null");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaEqualTo(String value) {
            addCriterion("FMDHHXFA =", value, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaNotEqualTo(String value) {
            addCriterion("FMDHHXFA <>", value, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaGreaterThan(String value) {
            addCriterion("FMDHHXFA >", value, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaGreaterThanOrEqualTo(String value) {
            addCriterion("FMDHHXFA >=", value, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaLessThan(String value) {
            addCriterion("FMDHHXFA <", value, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaLessThanOrEqualTo(String value) {
            addCriterion("FMDHHXFA <=", value, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaLike(String value) {
            addCriterion("FMDHHXFA like", value, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaNotLike(String value) {
            addCriterion("FMDHHXFA not like", value, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaIn(List<String> values) {
            addCriterion("FMDHHXFA in", values, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaNotIn(List<String> values) {
            addCriterion("FMDHHXFA not in", values, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaBetween(String value1, String value2) {
            addCriterion("FMDHHXFA between", value1, value2, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andFmdhhxfaNotBetween(String value1, String value2) {
            addCriterion("FMDHHXFA not between", value1, value2, "fmdhhxfa");
            return (Criteria) this;
        }

        public Criteria andYtIsNull() {
            addCriterion("YT is null");
            return (Criteria) this;
        }

        public Criteria andYtIsNotNull() {
            addCriterion("YT is not null");
            return (Criteria) this;
        }

        public Criteria andYtEqualTo(String value) {
            addCriterion("YT =", value, "yt");
            return (Criteria) this;
        }

        public Criteria andYtNotEqualTo(String value) {
            addCriterion("YT <>", value, "yt");
            return (Criteria) this;
        }

        public Criteria andYtGreaterThan(String value) {
            addCriterion("YT >", value, "yt");
            return (Criteria) this;
        }

        public Criteria andYtGreaterThanOrEqualTo(String value) {
            addCriterion("YT >=", value, "yt");
            return (Criteria) this;
        }

        public Criteria andYtLessThan(String value) {
            addCriterion("YT <", value, "yt");
            return (Criteria) this;
        }

        public Criteria andYtLessThanOrEqualTo(String value) {
            addCriterion("YT <=", value, "yt");
            return (Criteria) this;
        }

        public Criteria andYtLike(String value) {
            addCriterion("YT like", value, "yt");
            return (Criteria) this;
        }

        public Criteria andYtNotLike(String value) {
            addCriterion("YT not like", value, "yt");
            return (Criteria) this;
        }

        public Criteria andYtIn(List<String> values) {
            addCriterion("YT in", values, "yt");
            return (Criteria) this;
        }

        public Criteria andYtNotIn(List<String> values) {
            addCriterion("YT not in", values, "yt");
            return (Criteria) this;
        }

        public Criteria andYtBetween(String value1, String value2) {
            addCriterion("YT between", value1, value2, "yt");
            return (Criteria) this;
        }

        public Criteria andYtNotBetween(String value1, String value2) {
            addCriterion("YT not between", value1, value2, "yt");
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

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("CREATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("CREATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("CREATE_USER_ID =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("CREATE_USER_ID <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("CREATE_USER_ID >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("CREATE_USER_ID <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("CREATE_USER_ID like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("CREATE_USER_ID not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("CREATE_USER_ID in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("CREATE_USER_ID not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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