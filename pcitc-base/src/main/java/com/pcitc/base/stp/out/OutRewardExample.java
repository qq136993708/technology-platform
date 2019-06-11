package com.pcitc.base.stp.out;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutRewardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutRewardExample() {
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

        public Criteria andOrColumn(String value,String[] columns,String opt){
            String sql = "";
            String cal = "";
            if ("like".equals(opt)){
                cal="%";
            }
            int l = columns.length;
            for (int i = 0; i < l; i++) {
                if(i==0){
                    sql = sql + columns[i]+" "+opt+" '"+cal+value+cal+"'";
                }else {
                    sql = sql + " or "+columns[i]+" "+opt+" '"+cal+value+cal+"'";
                }
            }
            addCriterion("("+sql+")");
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

        public Criteria andXmidIsNull() {
            addCriterion("xmid is null");
            return (Criteria) this;
        }

        public Criteria andXmidIsNotNull() {
            addCriterion("xmid is not null");
            return (Criteria) this;
        }

        public Criteria andXmidEqualTo(String value) {
            addCriterion("xmid =", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidNotEqualTo(String value) {
            addCriterion("xmid <>", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidGreaterThan(String value) {
            addCriterion("xmid >", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidGreaterThanOrEqualTo(String value) {
            addCriterion("xmid >=", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidLessThan(String value) {
            addCriterion("xmid <", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidLessThanOrEqualTo(String value) {
            addCriterion("xmid <=", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidLike(String value) {
            addCriterion("xmid like", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidNotLike(String value) {
            addCriterion("xmid not like", value, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidIn(List<String> values) {
            addCriterion("xmid in", values, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidNotIn(List<String> values) {
            addCriterion("xmid not in", values, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidBetween(String value1, String value2) {
            addCriterion("xmid between", value1, value2, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmidNotBetween(String value1, String value2) {
            addCriterion("xmid not between", value1, value2, "xmid");
            return (Criteria) this;
        }

        public Criteria andXmbhIsNull() {
            addCriterion("xmbh is null");
            return (Criteria) this;
        }

        public Criteria andXmbhIsNotNull() {
            addCriterion("xmbh is not null");
            return (Criteria) this;
        }

        public Criteria andXmbhEqualTo(String value) {
            addCriterion("xmbh =", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhNotEqualTo(String value) {
            addCriterion("xmbh <>", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhGreaterThan(String value) {
            addCriterion("xmbh >", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhGreaterThanOrEqualTo(String value) {
            addCriterion("xmbh >=", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhLessThan(String value) {
            addCriterion("xmbh <", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhLessThanOrEqualTo(String value) {
            addCriterion("xmbh <=", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhLike(String value) {
            addCriterion("xmbh like", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhNotLike(String value) {
            addCriterion("xmbh not like", value, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhIn(List<String> values) {
            addCriterion("xmbh in", values, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhNotIn(List<String> values) {
            addCriterion("xmbh not in", values, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhBetween(String value1, String value2) {
            addCriterion("xmbh between", value1, value2, "xmbh");
            return (Criteria) this;
        }

        public Criteria andXmbhNotBetween(String value1, String value2) {
            addCriterion("xmbh not between", value1, value2, "xmbh");
            return (Criteria) this;
        }

        public Criteria andNdIsNull() {
            addCriterion("nd is null");
            return (Criteria) this;
        }

        public Criteria andNdIsNotNull() {
            addCriterion("nd is not null");
            return (Criteria) this;
        }

        public Criteria andNdEqualTo(String value) {
            addCriterion("nd =", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotEqualTo(String value) {
            addCriterion("nd <>", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThan(String value) {
            addCriterion("nd >", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThanOrEqualTo(String value) {
            addCriterion("nd >=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThan(String value) {
            addCriterion("nd <", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThanOrEqualTo(String value) {
            addCriterion("nd <=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLike(String value) {
            addCriterion("nd like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotLike(String value) {
            addCriterion("nd not like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdIn(List<String> values) {
            addCriterion("nd in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotIn(List<String> values) {
            addCriterion("nd not in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdBetween(String value1, String value2) {
            addCriterion("nd between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotBetween(String value1, String value2) {
            addCriterion("nd not between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andXmmcIsNull() {
            addCriterion("xmmc is null");
            return (Criteria) this;
        }

        public Criteria andXmmcIsNotNull() {
            addCriterion("xmmc is not null");
            return (Criteria) this;
        }

        public Criteria andXmmcEqualTo(String value) {
            addCriterion("xmmc =", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotEqualTo(String value) {
            addCriterion("xmmc <>", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcGreaterThan(String value) {
            addCriterion("xmmc >", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcGreaterThanOrEqualTo(String value) {
            addCriterion("xmmc >=", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcLessThan(String value) {
            addCriterion("xmmc <", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcLessThanOrEqualTo(String value) {
            addCriterion("xmmc <=", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcLike(String value) {
            addCriterion("xmmc like", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotLike(String value) {
            addCriterion("xmmc not like", value, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcIn(List<String> values) {
            addCriterion("xmmc in", values, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotIn(List<String> values) {
            addCriterion("xmmc not in", values, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcBetween(String value1, String value2) {
            addCriterion("xmmc between", value1, value2, "xmmc");
            return (Criteria) this;
        }

        public Criteria andXmmcNotBetween(String value1, String value2) {
            addCriterion("xmmc not between", value1, value2, "xmmc");
            return (Criteria) this;
        }

        public Criteria andSbdwIsNull() {
            addCriterion("sbdw is null");
            return (Criteria) this;
        }

        public Criteria andSbdwIsNotNull() {
            addCriterion("sbdw is not null");
            return (Criteria) this;
        }

        public Criteria andSbdwEqualTo(String value) {
            addCriterion("sbdw =", value, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwNotEqualTo(String value) {
            addCriterion("sbdw <>", value, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwGreaterThan(String value) {
            addCriterion("sbdw >", value, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwGreaterThanOrEqualTo(String value) {
            addCriterion("sbdw >=", value, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwLessThan(String value) {
            addCriterion("sbdw <", value, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwLessThanOrEqualTo(String value) {
            addCriterion("sbdw <=", value, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwLike(String value) {
            addCriterion("sbdw like", value, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwNotLike(String value) {
            addCriterion("sbdw not like", value, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwIn(List<String> values) {
            addCriterion("sbdw in", values, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwNotIn(List<String> values) {
            addCriterion("sbdw not in", values, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwBetween(String value1, String value2) {
            addCriterion("sbdw between", value1, value2, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbdwNotBetween(String value1, String value2) {
            addCriterion("sbdw not between", value1, value2, "sbdw");
            return (Criteria) this;
        }

        public Criteria andSbjzIsNull() {
            addCriterion("sbjz is null");
            return (Criteria) this;
        }

        public Criteria andSbjzIsNotNull() {
            addCriterion("sbjz is not null");
            return (Criteria) this;
        }

        public Criteria andSbjzEqualTo(String value) {
            addCriterion("sbjz =", value, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzNotEqualTo(String value) {
            addCriterion("sbjz <>", value, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzGreaterThan(String value) {
            addCriterion("sbjz >", value, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzGreaterThanOrEqualTo(String value) {
            addCriterion("sbjz >=", value, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzLessThan(String value) {
            addCriterion("sbjz <", value, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzLessThanOrEqualTo(String value) {
            addCriterion("sbjz <=", value, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzLike(String value) {
            addCriterion("sbjz like", value, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzNotLike(String value) {
            addCriterion("sbjz not like", value, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzIn(List<String> values) {
            addCriterion("sbjz in", values, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzNotIn(List<String> values) {
            addCriterion("sbjz not in", values, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzBetween(String value1, String value2) {
            addCriterion("sbjz between", value1, value2, "sbjz");
            return (Criteria) this;
        }

        public Criteria andSbjzNotBetween(String value1, String value2) {
            addCriterion("sbjz not between", value1, value2, "sbjz");
            return (Criteria) this;
        }

        public Criteria andXkflIsNull() {
            addCriterion("xkfl is null");
            return (Criteria) this;
        }

        public Criteria andXkflIsNotNull() {
            addCriterion("xkfl is not null");
            return (Criteria) this;
        }

        public Criteria andXkflEqualTo(String value) {
            addCriterion("xkfl =", value, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflNotEqualTo(String value) {
            addCriterion("xkfl <>", value, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflGreaterThan(String value) {
            addCriterion("xkfl >", value, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflGreaterThanOrEqualTo(String value) {
            addCriterion("xkfl >=", value, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflLessThan(String value) {
            addCriterion("xkfl <", value, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflLessThanOrEqualTo(String value) {
            addCriterion("xkfl <=", value, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflLike(String value) {
            addCriterion("xkfl like", value, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflNotLike(String value) {
            addCriterion("xkfl not like", value, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflIn(List<String> values) {
            addCriterion("xkfl in", values, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflNotIn(List<String> values) {
            addCriterion("xkfl not in", values, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflBetween(String value1, String value2) {
            addCriterion("xkfl between", value1, value2, "xkfl");
            return (Criteria) this;
        }

        public Criteria andXkflNotBetween(String value1, String value2) {
            addCriterion("xkfl not between", value1, value2, "xkfl");
            return (Criteria) this;
        }

        public Criteria andSbdjIsNull() {
            addCriterion("sbdj is null");
            return (Criteria) this;
        }

        public Criteria andSbdjIsNotNull() {
            addCriterion("sbdj is not null");
            return (Criteria) this;
        }

        public Criteria andSbdjEqualTo(String value) {
            addCriterion("sbdj =", value, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjNotEqualTo(String value) {
            addCriterion("sbdj <>", value, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjGreaterThan(String value) {
            addCriterion("sbdj >", value, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjGreaterThanOrEqualTo(String value) {
            addCriterion("sbdj >=", value, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjLessThan(String value) {
            addCriterion("sbdj <", value, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjLessThanOrEqualTo(String value) {
            addCriterion("sbdj <=", value, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjLike(String value) {
            addCriterion("sbdj like", value, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjNotLike(String value) {
            addCriterion("sbdj not like", value, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjIn(List<String> values) {
            addCriterion("sbdj in", values, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjNotIn(List<String> values) {
            addCriterion("sbdj not in", values, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjBetween(String value1, String value2) {
            addCriterion("sbdj between", value1, value2, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbdjNotBetween(String value1, String value2) {
            addCriterion("sbdj not between", value1, value2, "sbdj");
            return (Criteria) this;
        }

        public Criteria andSbrqIsNull() {
            addCriterion("sbrq is null");
            return (Criteria) this;
        }

        public Criteria andSbrqIsNotNull() {
            addCriterion("sbrq is not null");
            return (Criteria) this;
        }

        public Criteria andSbrqEqualTo(String value) {
            addCriterion("sbrq =", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqNotEqualTo(String value) {
            addCriterion("sbrq <>", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqGreaterThan(String value) {
            addCriterion("sbrq >", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqGreaterThanOrEqualTo(String value) {
            addCriterion("sbrq >=", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqLessThan(String value) {
            addCriterion("sbrq <", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqLessThanOrEqualTo(String value) {
            addCriterion("sbrq <=", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqLike(String value) {
            addCriterion("sbrq like", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqNotLike(String value) {
            addCriterion("sbrq not like", value, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqIn(List<String> values) {
            addCriterion("sbrq in", values, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqNotIn(List<String> values) {
            addCriterion("sbrq not in", values, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqBetween(String value1, String value2) {
            addCriterion("sbrq between", value1, value2, "sbrq");
            return (Criteria) this;
        }

        public Criteria andSbrqNotBetween(String value1, String value2) {
            addCriterion("sbrq not between", value1, value2, "sbrq");
            return (Criteria) this;
        }

        public Criteria andRwlyIsNull() {
            addCriterion("rwly is null");
            return (Criteria) this;
        }

        public Criteria andRwlyIsNotNull() {
            addCriterion("rwly is not null");
            return (Criteria) this;
        }

        public Criteria andRwlyEqualTo(String value) {
            addCriterion("rwly =", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyNotEqualTo(String value) {
            addCriterion("rwly <>", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyGreaterThan(String value) {
            addCriterion("rwly >", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyGreaterThanOrEqualTo(String value) {
            addCriterion("rwly >=", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyLessThan(String value) {
            addCriterion("rwly <", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyLessThanOrEqualTo(String value) {
            addCriterion("rwly <=", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyLike(String value) {
            addCriterion("rwly like", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyNotLike(String value) {
            addCriterion("rwly not like", value, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyIn(List<String> values) {
            addCriterion("rwly in", values, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyNotIn(List<String> values) {
            addCriterion("rwly not in", values, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyBetween(String value1, String value2) {
            addCriterion("rwly between", value1, value2, "rwly");
            return (Criteria) this;
        }

        public Criteria andRwlyNotBetween(String value1, String value2) {
            addCriterion("rwly not between", value1, value2, "rwly");
            return (Criteria) this;
        }

        public Criteria andJddwIsNull() {
            addCriterion("jddw is null");
            return (Criteria) this;
        }

        public Criteria andJddwIsNotNull() {
            addCriterion("jddw is not null");
            return (Criteria) this;
        }

        public Criteria andJddwEqualTo(String value) {
            addCriterion("jddw =", value, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwNotEqualTo(String value) {
            addCriterion("jddw <>", value, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwGreaterThan(String value) {
            addCriterion("jddw >", value, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwGreaterThanOrEqualTo(String value) {
            addCriterion("jddw >=", value, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwLessThan(String value) {
            addCriterion("jddw <", value, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwLessThanOrEqualTo(String value) {
            addCriterion("jddw <=", value, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwLike(String value) {
            addCriterion("jddw like", value, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwNotLike(String value) {
            addCriterion("jddw not like", value, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwIn(List<String> values) {
            addCriterion("jddw in", values, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwNotIn(List<String> values) {
            addCriterion("jddw not in", values, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwBetween(String value1, String value2) {
            addCriterion("jddw between", value1, value2, "jddw");
            return (Criteria) this;
        }

        public Criteria andJddwNotBetween(String value1, String value2) {
            addCriterion("jddw not between", value1, value2, "jddw");
            return (Criteria) this;
        }

        public Criteria andHthIsNull() {
            addCriterion("hth is null");
            return (Criteria) this;
        }

        public Criteria andHthIsNotNull() {
            addCriterion("hth is not null");
            return (Criteria) this;
        }

        public Criteria andHthEqualTo(String value) {
            addCriterion("hth =", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotEqualTo(String value) {
            addCriterion("hth <>", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthGreaterThan(String value) {
            addCriterion("hth >", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthGreaterThanOrEqualTo(String value) {
            addCriterion("hth >=", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthLessThan(String value) {
            addCriterion("hth <", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthLessThanOrEqualTo(String value) {
            addCriterion("hth <=", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthLike(String value) {
            addCriterion("hth like", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotLike(String value) {
            addCriterion("hth not like", value, "hth");
            return (Criteria) this;
        }

        public Criteria andHthIn(List<String> values) {
            addCriterion("hth in", values, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotIn(List<String> values) {
            addCriterion("hth not in", values, "hth");
            return (Criteria) this;
        }

        public Criteria andHthBetween(String value1, String value2) {
            addCriterion("hth between", value1, value2, "hth");
            return (Criteria) this;
        }

        public Criteria andHthNotBetween(String value1, String value2) {
            addCriterion("hth not between", value1, value2, "hth");
            return (Criteria) this;
        }

        public Criteria andKssjIsNull() {
            addCriterion("kssj is null");
            return (Criteria) this;
        }

        public Criteria andKssjIsNotNull() {
            addCriterion("kssj is not null");
            return (Criteria) this;
        }

        public Criteria andKssjEqualTo(String value) {
            addCriterion("kssj =", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotEqualTo(String value) {
            addCriterion("kssj <>", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjGreaterThan(String value) {
            addCriterion("kssj >", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjGreaterThanOrEqualTo(String value) {
            addCriterion("kssj >=", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjLessThan(String value) {
            addCriterion("kssj <", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjLessThanOrEqualTo(String value) {
            addCriterion("kssj <=", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjLike(String value) {
            addCriterion("kssj like", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotLike(String value) {
            addCriterion("kssj not like", value, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjIn(List<String> values) {
            addCriterion("kssj in", values, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotIn(List<String> values) {
            addCriterion("kssj not in", values, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjBetween(String value1, String value2) {
            addCriterion("kssj between", value1, value2, "kssj");
            return (Criteria) this;
        }

        public Criteria andKssjNotBetween(String value1, String value2) {
            addCriterion("kssj not between", value1, value2, "kssj");
            return (Criteria) this;
        }

        public Criteria andJssjIsNull() {
            addCriterion("jssj is null");
            return (Criteria) this;
        }

        public Criteria andJssjIsNotNull() {
            addCriterion("jssj is not null");
            return (Criteria) this;
        }

        public Criteria andJssjEqualTo(String value) {
            addCriterion("jssj =", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotEqualTo(String value) {
            addCriterion("jssj <>", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjGreaterThan(String value) {
            addCriterion("jssj >", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjGreaterThanOrEqualTo(String value) {
            addCriterion("jssj >=", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLessThan(String value) {
            addCriterion("jssj <", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLessThanOrEqualTo(String value) {
            addCriterion("jssj <=", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLike(String value) {
            addCriterion("jssj like", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotLike(String value) {
            addCriterion("jssj not like", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjIn(List<String> values) {
            addCriterion("jssj in", values, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotIn(List<String> values) {
            addCriterion("jssj not in", values, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjBetween(String value1, String value2) {
            addCriterion("jssj between", value1, value2, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotBetween(String value1, String value2) {
            addCriterion("jssj not between", value1, value2, "jssj");
            return (Criteria) this;
        }

        public Criteria andSbztIsNull() {
            addCriterion("sbzt is null");
            return (Criteria) this;
        }

        public Criteria andSbztIsNotNull() {
            addCriterion("sbzt is not null");
            return (Criteria) this;
        }

        public Criteria andSbztEqualTo(String value) {
            addCriterion("sbzt =", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotEqualTo(String value) {
            addCriterion("sbzt <>", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThan(String value) {
            addCriterion("sbzt >", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThanOrEqualTo(String value) {
            addCriterion("sbzt >=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThan(String value) {
            addCriterion("sbzt <", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThanOrEqualTo(String value) {
            addCriterion("sbzt <=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLike(String value) {
            addCriterion("sbzt like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotLike(String value) {
            addCriterion("sbzt not like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztIn(List<String> values) {
            addCriterion("sbzt in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotIn(List<String> values) {
            addCriterion("sbzt not in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztBetween(String value1, String value2) {
            addCriterion("sbzt between", value1, value2, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotBetween(String value1, String value2) {
            addCriterion("sbzt not between", value1, value2, "sbzt");
            return (Criteria) this;
        }

        public Criteria andPsdjIsNull() {
            addCriterion("psdj is null");
            return (Criteria) this;
        }

        public Criteria andPsdjIsNotNull() {
            addCriterion("psdj is not null");
            return (Criteria) this;
        }

        public Criteria andPsdjEqualTo(String value) {
            addCriterion("psdj =", value, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjNotEqualTo(String value) {
            addCriterion("psdj <>", value, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjGreaterThan(String value) {
            addCriterion("psdj >", value, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjGreaterThanOrEqualTo(String value) {
            addCriterion("psdj >=", value, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjLessThan(String value) {
            addCriterion("psdj <", value, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjLessThanOrEqualTo(String value) {
            addCriterion("psdj <=", value, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjLike(String value) {
            addCriterion("psdj like", value, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjNotLike(String value) {
            addCriterion("psdj not like", value, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjIn(List<String> values) {
            addCriterion("psdj in", values, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjNotIn(List<String> values) {
            addCriterion("psdj not in", values, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjBetween(String value1, String value2) {
            addCriterion("psdj between", value1, value2, "psdj");
            return (Criteria) this;
        }

        public Criteria andPsdjNotBetween(String value1, String value2) {
            addCriterion("psdj not between", value1, value2, "psdj");
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
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andDefine1IsNull() {
            addCriterion("define1 is null");
            return (Criteria) this;
        }

        public Criteria andDefine1IsNotNull() {
            addCriterion("define1 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine1EqualTo(String value) {
            addCriterion("define1 =", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotEqualTo(String value) {
            addCriterion("define1 <>", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1GreaterThan(String value) {
            addCriterion("define1 >", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1GreaterThanOrEqualTo(String value) {
            addCriterion("define1 >=", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1LessThan(String value) {
            addCriterion("define1 <", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1LessThanOrEqualTo(String value) {
            addCriterion("define1 <=", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1Like(String value) {
            addCriterion("define1 like", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotLike(String value) {
            addCriterion("define1 not like", value, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1In(List<String> values) {
            addCriterion("define1 in", values, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotIn(List<String> values) {
            addCriterion("define1 not in", values, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1Between(String value1, String value2) {
            addCriterion("define1 between", value1, value2, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine1NotBetween(String value1, String value2) {
            addCriterion("define1 not between", value1, value2, "define1");
            return (Criteria) this;
        }

        public Criteria andDefine2IsNull() {
            addCriterion("define2 is null");
            return (Criteria) this;
        }

        public Criteria andDefine2IsNotNull() {
            addCriterion("define2 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine2EqualTo(String value) {
            addCriterion("define2 =", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotEqualTo(String value) {
            addCriterion("define2 <>", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2GreaterThan(String value) {
            addCriterion("define2 >", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2GreaterThanOrEqualTo(String value) {
            addCriterion("define2 >=", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2LessThan(String value) {
            addCriterion("define2 <", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2LessThanOrEqualTo(String value) {
            addCriterion("define2 <=", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2Like(String value) {
            addCriterion("define2 like", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotLike(String value) {
            addCriterion("define2 not like", value, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2In(List<String> values) {
            addCriterion("define2 in", values, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotIn(List<String> values) {
            addCriterion("define2 not in", values, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2Between(String value1, String value2) {
            addCriterion("define2 between", value1, value2, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine2NotBetween(String value1, String value2) {
            addCriterion("define2 not between", value1, value2, "define2");
            return (Criteria) this;
        }

        public Criteria andDefine3IsNull() {
            addCriterion("define3 is null");
            return (Criteria) this;
        }

        public Criteria andDefine3IsNotNull() {
            addCriterion("define3 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine3EqualTo(String value) {
            addCriterion("define3 =", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotEqualTo(String value) {
            addCriterion("define3 <>", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3GreaterThan(String value) {
            addCriterion("define3 >", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3GreaterThanOrEqualTo(String value) {
            addCriterion("define3 >=", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3LessThan(String value) {
            addCriterion("define3 <", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3LessThanOrEqualTo(String value) {
            addCriterion("define3 <=", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3Like(String value) {
            addCriterion("define3 like", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotLike(String value) {
            addCriterion("define3 not like", value, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3In(List<String> values) {
            addCriterion("define3 in", values, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotIn(List<String> values) {
            addCriterion("define3 not in", values, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3Between(String value1, String value2) {
            addCriterion("define3 between", value1, value2, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine3NotBetween(String value1, String value2) {
            addCriterion("define3 not between", value1, value2, "define3");
            return (Criteria) this;
        }

        public Criteria andDefine4IsNull() {
            addCriterion("define4 is null");
            return (Criteria) this;
        }

        public Criteria andDefine4IsNotNull() {
            addCriterion("define4 is not null");
            return (Criteria) this;
        }

        public Criteria andDefine4EqualTo(String value) {
            addCriterion("define4 =", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotEqualTo(String value) {
            addCriterion("define4 <>", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4GreaterThan(String value) {
            addCriterion("define4 >", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4GreaterThanOrEqualTo(String value) {
            addCriterion("define4 >=", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4LessThan(String value) {
            addCriterion("define4 <", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4LessThanOrEqualTo(String value) {
            addCriterion("define4 <=", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4Like(String value) {
            addCriterion("define4 like", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotLike(String value) {
            addCriterion("define4 not like", value, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4In(List<String> values) {
            addCriterion("define4 in", values, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotIn(List<String> values) {
            addCriterion("define4 not in", values, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4Between(String value1, String value2) {
            addCriterion("define4 between", value1, value2, "define4");
            return (Criteria) this;
        }

        public Criteria andDefine4NotBetween(String value1, String value2) {
            addCriterion("define4 not between", value1, value2, "define4");
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