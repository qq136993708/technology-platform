package com.pcitc.base.system;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

public class IndexOutProjectInfoExample {

protected String orderByClause;

protected boolean distinct;

protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public IndexOutProjectInfoExample() {
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
                            public Criteria andTfmTypeIdIsNull() {
                            addCriterion("tfm_type_id is null");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdIsNotNull() {
                            addCriterion("tfm_type_id is not null");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdEqualTo(String value) {
                            addCriterion("tfm_type_id =", value, "tfmTypeId");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdNotEqualTo(String value) {
                            addCriterion("tfm_type_id <>", value, "tfmTypeId");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdGreaterThan(String value) {
                            addCriterion("tfm_type_id >", value, "tfmTypeId");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdGreaterThanOrEqualTo(String value) {
                            addCriterion("tfm_type_id >=", value, "tfmTypeId");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdLessThan(String value) {
                            addCriterion("tfm_type_id <", value, "tfmTypeId");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdLessThanOrEqualTo(String value) {
                            addCriterion("tfm_type_id <=", value, "tfmTypeId");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdLike(String value) {
                            addCriterion("tfm_type_id like", value, "tfmTypeId");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdNotLike(String value) {
                            addCriterion("tfm_type_id not like", value, "tfmTypeId");
                            return (Criteria) this;
                            }

                            public Criteria andTfmTypeIdIn(List<String> values) {
                                addCriterion("tfm_type_id in", values, "tfmTypeId");
                                return (Criteria) this;
                                }

                                public Criteria andTfmTypeIdNotIn(List<String> values) {
                                    addCriterion("tfm_type_id not in", values, "tfmTypeId");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTfmTypeIdBetween(String value1, String value2) {
                                    addCriterion("tfm_type_id between", value1, value2, "tfmTypeId");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTfmTypeIdNotBetween(String value1, String value2) {
                                    addCriterion("tfm_type_id not between", value1, value2, "tfmTypeId");
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
                            public Criteria andXmjbIsNull() {
                            addCriterion("xmjb is null");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbIsNotNull() {
                            addCriterion("xmjb is not null");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbEqualTo(String value) {
                            addCriterion("xmjb =", value, "xmjb");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbNotEqualTo(String value) {
                            addCriterion("xmjb <>", value, "xmjb");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbGreaterThan(String value) {
                            addCriterion("xmjb >", value, "xmjb");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbGreaterThanOrEqualTo(String value) {
                            addCriterion("xmjb >=", value, "xmjb");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbLessThan(String value) {
                            addCriterion("xmjb <", value, "xmjb");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbLessThanOrEqualTo(String value) {
                            addCriterion("xmjb <=", value, "xmjb");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbLike(String value) {
                            addCriterion("xmjb like", value, "xmjb");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbNotLike(String value) {
                            addCriterion("xmjb not like", value, "xmjb");
                            return (Criteria) this;
                            }

                            public Criteria andXmjbIn(List<String> values) {
                                addCriterion("xmjb in", values, "xmjb");
                                return (Criteria) this;
                                }

                                public Criteria andXmjbNotIn(List<String> values) {
                                    addCriterion("xmjb not in", values, "xmjb");
                                    return (Criteria) this;
                                    }

                                    public Criteria andXmjbBetween(String value1, String value2) {
                                    addCriterion("xmjb between", value1, value2, "xmjb");
                                    return (Criteria) this;
                                    }

                                    public Criteria andXmjbNotBetween(String value1, String value2) {
                                    addCriterion("xmjb not between", value1, value2, "xmjb");
                                    return (Criteria) this;
                                    }
                            public Criteria andYsndIsNull() {
                            addCriterion("ysnd is null");
                            return (Criteria) this;
                            }

                            public Criteria andYsndIsNotNull() {
                            addCriterion("ysnd is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYsndEqualTo(String value) {
                            addCriterion("ysnd =", value, "ysnd");
                            return (Criteria) this;
                            }

                            public Criteria andYsndNotEqualTo(String value) {
                            addCriterion("ysnd <>", value, "ysnd");
                            return (Criteria) this;
                            }

                            public Criteria andYsndGreaterThan(String value) {
                            addCriterion("ysnd >", value, "ysnd");
                            return (Criteria) this;
                            }

                            public Criteria andYsndGreaterThanOrEqualTo(String value) {
                            addCriterion("ysnd >=", value, "ysnd");
                            return (Criteria) this;
                            }

                            public Criteria andYsndLessThan(String value) {
                            addCriterion("ysnd <", value, "ysnd");
                            return (Criteria) this;
                            }

                            public Criteria andYsndLessThanOrEqualTo(String value) {
                            addCriterion("ysnd <=", value, "ysnd");
                            return (Criteria) this;
                            }

                            public Criteria andYsndLike(String value) {
                            addCriterion("ysnd like", value, "ysnd");
                            return (Criteria) this;
                            }

                            public Criteria andYsndNotLike(String value) {
                            addCriterion("ysnd not like", value, "ysnd");
                            return (Criteria) this;
                            }

                            public Criteria andYsndIn(List<String> values) {
                                addCriterion("ysnd in", values, "ysnd");
                                return (Criteria) this;
                                }

                                public Criteria andYsndNotIn(List<String> values) {
                                    addCriterion("ysnd not in", values, "ysnd");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYsndBetween(String value1, String value2) {
                                    addCriterion("ysnd between", value1, value2, "ysnd");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYsndNotBetween(String value1, String value2) {
                                    addCriterion("ysnd not between", value1, value2, "ysnd");
                                    return (Criteria) this;
                                    }
                            public Criteria andYshfIsNull() {
                            addCriterion("yshf is null");
                            return (Criteria) this;
                            }

                            public Criteria andYshfIsNotNull() {
                            addCriterion("yshf is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYshfEqualTo(String value) {
                            addCriterion("yshf =", value, "yshf");
                            return (Criteria) this;
                            }

                            public Criteria andYshfNotEqualTo(String value) {
                            addCriterion("yshf <>", value, "yshf");
                            return (Criteria) this;
                            }

                            public Criteria andYshfGreaterThan(String value) {
                            addCriterion("yshf >", value, "yshf");
                            return (Criteria) this;
                            }

                            public Criteria andYshfGreaterThanOrEqualTo(String value) {
                            addCriterion("yshf >=", value, "yshf");
                            return (Criteria) this;
                            }

                            public Criteria andYshfLessThan(String value) {
                            addCriterion("yshf <", value, "yshf");
                            return (Criteria) this;
                            }

                            public Criteria andYshfLessThanOrEqualTo(String value) {
                            addCriterion("yshf <=", value, "yshf");
                            return (Criteria) this;
                            }

                            public Criteria andYshfLike(String value) {
                            addCriterion("yshf like", value, "yshf");
                            return (Criteria) this;
                            }

                            public Criteria andYshfNotLike(String value) {
                            addCriterion("yshf not like", value, "yshf");
                            return (Criteria) this;
                            }

                            public Criteria andYshfIn(List<String> values) {
                                addCriterion("yshf in", values, "yshf");
                                return (Criteria) this;
                                }

                                public Criteria andYshfNotIn(List<String> values) {
                                    addCriterion("yshf not in", values, "yshf");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYshfBetween(String value1, String value2) {
                                    addCriterion("yshf between", value1, value2, "yshf");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYshfNotBetween(String value1, String value2) {
                                    addCriterion("yshf not between", value1, value2, "yshf");
                                    return (Criteria) this;
                                    }
                            public Criteria andYsxdIsNull() {
                            addCriterion("ysxd is null");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdIsNotNull() {
                            addCriterion("ysxd is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdEqualTo(String value) {
                            addCriterion("ysxd =", value, "ysxd");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdNotEqualTo(String value) {
                            addCriterion("ysxd <>", value, "ysxd");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdGreaterThan(String value) {
                            addCriterion("ysxd >", value, "ysxd");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdGreaterThanOrEqualTo(String value) {
                            addCriterion("ysxd >=", value, "ysxd");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdLessThan(String value) {
                            addCriterion("ysxd <", value, "ysxd");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdLessThanOrEqualTo(String value) {
                            addCriterion("ysxd <=", value, "ysxd");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdLike(String value) {
                            addCriterion("ysxd like", value, "ysxd");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdNotLike(String value) {
                            addCriterion("ysxd not like", value, "ysxd");
                            return (Criteria) this;
                            }

                            public Criteria andYsxdIn(List<String> values) {
                                addCriterion("ysxd in", values, "ysxd");
                                return (Criteria) this;
                                }

                                public Criteria andYsxdNotIn(List<String> values) {
                                    addCriterion("ysxd not in", values, "ysxd");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYsxdBetween(String value1, String value2) {
                                    addCriterion("ysxd between", value1, value2, "ysxd");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYsxdNotBetween(String value1, String value2) {
                                    addCriterion("ysxd not between", value1, value2, "ysxd");
                                    return (Criteria) this;
                                    }
                            public Criteria andYszbxjeIsNull() {
                            addCriterion("yszbxje is null");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeIsNotNull() {
                            addCriterion("yszbxje is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeEqualTo(String value) {
                            addCriterion("yszbxje =", value, "yszbxje");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeNotEqualTo(String value) {
                            addCriterion("yszbxje <>", value, "yszbxje");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeGreaterThan(String value) {
                            addCriterion("yszbxje >", value, "yszbxje");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeGreaterThanOrEqualTo(String value) {
                            addCriterion("yszbxje >=", value, "yszbxje");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeLessThan(String value) {
                            addCriterion("yszbxje <", value, "yszbxje");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeLessThanOrEqualTo(String value) {
                            addCriterion("yszbxje <=", value, "yszbxje");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeLike(String value) {
                            addCriterion("yszbxje like", value, "yszbxje");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeNotLike(String value) {
                            addCriterion("yszbxje not like", value, "yszbxje");
                            return (Criteria) this;
                            }

                            public Criteria andYszbxjeIn(List<String> values) {
                                addCriterion("yszbxje in", values, "yszbxje");
                                return (Criteria) this;
                                }

                                public Criteria andYszbxjeNotIn(List<String> values) {
                                    addCriterion("yszbxje not in", values, "yszbxje");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYszbxjeBetween(String value1, String value2) {
                                    addCriterion("yszbxje between", value1, value2, "yszbxje");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYszbxjeNotBetween(String value1, String value2) {
                                    addCriterion("yszbxje not between", value1, value2, "yszbxje");
                                    return (Criteria) this;
                                    }
                            public Criteria andYsfyxjeIsNull() {
                            addCriterion("ysfyxje is null");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeIsNotNull() {
                            addCriterion("ysfyxje is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeEqualTo(String value) {
                            addCriterion("ysfyxje =", value, "ysfyxje");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeNotEqualTo(String value) {
                            addCriterion("ysfyxje <>", value, "ysfyxje");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeGreaterThan(String value) {
                            addCriterion("ysfyxje >", value, "ysfyxje");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeGreaterThanOrEqualTo(String value) {
                            addCriterion("ysfyxje >=", value, "ysfyxje");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeLessThan(String value) {
                            addCriterion("ysfyxje <", value, "ysfyxje");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeLessThanOrEqualTo(String value) {
                            addCriterion("ysfyxje <=", value, "ysfyxje");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeLike(String value) {
                            addCriterion("ysfyxje like", value, "ysfyxje");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeNotLike(String value) {
                            addCriterion("ysfyxje not like", value, "ysfyxje");
                            return (Criteria) this;
                            }

                            public Criteria andYsfyxjeIn(List<String> values) {
                                addCriterion("ysfyxje in", values, "ysfyxje");
                                return (Criteria) this;
                                }

                                public Criteria andYsfyxjeNotIn(List<String> values) {
                                    addCriterion("ysfyxje not in", values, "ysfyxje");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYsfyxjeBetween(String value1, String value2) {
                                    addCriterion("ysfyxje between", value1, value2, "ysfyxje");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYsfyxjeNotBetween(String value1, String value2) {
                                    addCriterion("ysfyxje not between", value1, value2, "ysfyxje");
                                    return (Criteria) this;
                                    }
                            public Criteria andYsjeIsNull() {
                            addCriterion("ysje is null");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeIsNotNull() {
                            addCriterion("ysje is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeEqualTo(String value) {
                            addCriterion("ysje =", value, "ysje");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeNotEqualTo(String value) {
                            addCriterion("ysje <>", value, "ysje");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeGreaterThan(String value) {
                            addCriterion("ysje >", value, "ysje");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeGreaterThanOrEqualTo(String value) {
                            addCriterion("ysje >=", value, "ysje");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeLessThan(String value) {
                            addCriterion("ysje <", value, "ysje");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeLessThanOrEqualTo(String value) {
                            addCriterion("ysje <=", value, "ysje");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeLike(String value) {
                            addCriterion("ysje like", value, "ysje");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeNotLike(String value) {
                            addCriterion("ysje not like", value, "ysje");
                            return (Criteria) this;
                            }

                            public Criteria andYsjeIn(List<String> values) {
                                addCriterion("ysje in", values, "ysje");
                                return (Criteria) this;
                                }

                                public Criteria andYsjeNotIn(List<String> values) {
                                    addCriterion("ysje not in", values, "ysje");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYsjeBetween(String value1, String value2) {
                                    addCriterion("ysje between", value1, value2, "ysje");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYsjeNotBetween(String value1, String value2) {
                                    addCriterion("ysje not between", value1, value2, "ysje");
                                    return (Criteria) this;
                                    }
                            public Criteria andJfIsNull() {
                            addCriterion("jf is null");
                            return (Criteria) this;
                            }

                            public Criteria andJfIsNotNull() {
                            addCriterion("jf is not null");
                            return (Criteria) this;
                            }

                            public Criteria andJfEqualTo(String value) {
                            addCriterion("jf =", value, "jf");
                            return (Criteria) this;
                            }

                            public Criteria andJfNotEqualTo(String value) {
                            addCriterion("jf <>", value, "jf");
                            return (Criteria) this;
                            }

                            public Criteria andJfGreaterThan(String value) {
                            addCriterion("jf >", value, "jf");
                            return (Criteria) this;
                            }

                            public Criteria andJfGreaterThanOrEqualTo(String value) {
                            addCriterion("jf >=", value, "jf");
                            return (Criteria) this;
                            }

                            public Criteria andJfLessThan(String value) {
                            addCriterion("jf <", value, "jf");
                            return (Criteria) this;
                            }

                            public Criteria andJfLessThanOrEqualTo(String value) {
                            addCriterion("jf <=", value, "jf");
                            return (Criteria) this;
                            }

                            public Criteria andJfLike(String value) {
                            addCriterion("jf like", value, "jf");
                            return (Criteria) this;
                            }

                            public Criteria andJfNotLike(String value) {
                            addCriterion("jf not like", value, "jf");
                            return (Criteria) this;
                            }

                            public Criteria andJfIn(List<String> values) {
                                addCriterion("jf in", values, "jf");
                                return (Criteria) this;
                                }

                                public Criteria andJfNotIn(List<String> values) {
                                    addCriterion("jf not in", values, "jf");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJfBetween(String value1, String value2) {
                                    addCriterion("jf between", value1, value2, "jf");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJfNotBetween(String value1, String value2) {
                                    addCriterion("jf not between", value1, value2, "jf");
                                    return (Criteria) this;
                                    }
                            public Criteria andFwdxbmIsNull() {
                            addCriterion("fwdxbm is null");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmIsNotNull() {
                            addCriterion("fwdxbm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmEqualTo(String value) {
                            addCriterion("fwdxbm =", value, "fwdxbm");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmNotEqualTo(String value) {
                            addCriterion("fwdxbm <>", value, "fwdxbm");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmGreaterThan(String value) {
                            addCriterion("fwdxbm >", value, "fwdxbm");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmGreaterThanOrEqualTo(String value) {
                            addCriterion("fwdxbm >=", value, "fwdxbm");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmLessThan(String value) {
                            addCriterion("fwdxbm <", value, "fwdxbm");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmLessThanOrEqualTo(String value) {
                            addCriterion("fwdxbm <=", value, "fwdxbm");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmLike(String value) {
                            addCriterion("fwdxbm like", value, "fwdxbm");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmNotLike(String value) {
                            addCriterion("fwdxbm not like", value, "fwdxbm");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxbmIn(List<String> values) {
                                addCriterion("fwdxbm in", values, "fwdxbm");
                                return (Criteria) this;
                                }

                                public Criteria andFwdxbmNotIn(List<String> values) {
                                    addCriterion("fwdxbm not in", values, "fwdxbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFwdxbmBetween(String value1, String value2) {
                                    addCriterion("fwdxbm between", value1, value2, "fwdxbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFwdxbmNotBetween(String value1, String value2) {
                                    addCriterion("fwdxbm not between", value1, value2, "fwdxbm");
                                    return (Criteria) this;
                                    }
                            public Criteria andFwdxIsNull() {
                            addCriterion("fwdx is null");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxIsNotNull() {
                            addCriterion("fwdx is not null");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxEqualTo(String value) {
                            addCriterion("fwdx =", value, "fwdx");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxNotEqualTo(String value) {
                            addCriterion("fwdx <>", value, "fwdx");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxGreaterThan(String value) {
                            addCriterion("fwdx >", value, "fwdx");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxGreaterThanOrEqualTo(String value) {
                            addCriterion("fwdx >=", value, "fwdx");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxLessThan(String value) {
                            addCriterion("fwdx <", value, "fwdx");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxLessThanOrEqualTo(String value) {
                            addCriterion("fwdx <=", value, "fwdx");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxLike(String value) {
                            addCriterion("fwdx like", value, "fwdx");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxNotLike(String value) {
                            addCriterion("fwdx not like", value, "fwdx");
                            return (Criteria) this;
                            }

                            public Criteria andFwdxIn(List<String> values) {
                                addCriterion("fwdx in", values, "fwdx");
                                return (Criteria) this;
                                }

                                public Criteria andFwdxNotIn(List<String> values) {
                                    addCriterion("fwdx not in", values, "fwdx");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFwdxBetween(String value1, String value2) {
                                    addCriterion("fwdx between", value1, value2, "fwdx");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFwdxNotBetween(String value1, String value2) {
                                    addCriterion("fwdx not between", value1, value2, "fwdx");
                                    return (Criteria) this;
                                    }
                            public Criteria andZylbbmIsNull() {
                            addCriterion("zylbbm is null");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmIsNotNull() {
                            addCriterion("zylbbm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmEqualTo(String value) {
                            addCriterion("zylbbm =", value, "zylbbm");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmNotEqualTo(String value) {
                            addCriterion("zylbbm <>", value, "zylbbm");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmGreaterThan(String value) {
                            addCriterion("zylbbm >", value, "zylbbm");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmGreaterThanOrEqualTo(String value) {
                            addCriterion("zylbbm >=", value, "zylbbm");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmLessThan(String value) {
                            addCriterion("zylbbm <", value, "zylbbm");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmLessThanOrEqualTo(String value) {
                            addCriterion("zylbbm <=", value, "zylbbm");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmLike(String value) {
                            addCriterion("zylbbm like", value, "zylbbm");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmNotLike(String value) {
                            addCriterion("zylbbm not like", value, "zylbbm");
                            return (Criteria) this;
                            }

                            public Criteria andZylbbmIn(List<String> values) {
                                addCriterion("zylbbm in", values, "zylbbm");
                                return (Criteria) this;
                                }

                                public Criteria andZylbbmNotIn(List<String> values) {
                                    addCriterion("zylbbm not in", values, "zylbbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZylbbmBetween(String value1, String value2) {
                                    addCriterion("zylbbm between", value1, value2, "zylbbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZylbbmNotBetween(String value1, String value2) {
                                    addCriterion("zylbbm not between", value1, value2, "zylbbm");
                                    return (Criteria) this;
                                    }
                            public Criteria andZylbIsNull() {
                            addCriterion("zylb is null");
                            return (Criteria) this;
                            }

                            public Criteria andZylbIsNotNull() {
                            addCriterion("zylb is not null");
                            return (Criteria) this;
                            }

                            public Criteria andZylbEqualTo(String value) {
                            addCriterion("zylb =", value, "zylb");
                            return (Criteria) this;
                            }

                            public Criteria andZylbNotEqualTo(String value) {
                            addCriterion("zylb <>", value, "zylb");
                            return (Criteria) this;
                            }

                            public Criteria andZylbGreaterThan(String value) {
                            addCriterion("zylb >", value, "zylb");
                            return (Criteria) this;
                            }

                            public Criteria andZylbGreaterThanOrEqualTo(String value) {
                            addCriterion("zylb >=", value, "zylb");
                            return (Criteria) this;
                            }

                            public Criteria andZylbLessThan(String value) {
                            addCriterion("zylb <", value, "zylb");
                            return (Criteria) this;
                            }

                            public Criteria andZylbLessThanOrEqualTo(String value) {
                            addCriterion("zylb <=", value, "zylb");
                            return (Criteria) this;
                            }

                            public Criteria andZylbLike(String value) {
                            addCriterion("zylb like", value, "zylb");
                            return (Criteria) this;
                            }

                            public Criteria andZylbNotLike(String value) {
                            addCriterion("zylb not like", value, "zylb");
                            return (Criteria) this;
                            }

                            public Criteria andZylbIn(List<String> values) {
                                addCriterion("zylb in", values, "zylb");
                                return (Criteria) this;
                                }

                                public Criteria andZylbNotIn(List<String> values) {
                                    addCriterion("zylb not in", values, "zylb");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZylbBetween(String value1, String value2) {
                                    addCriterion("zylb between", value1, value2, "zylb");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZylbNotBetween(String value1, String value2) {
                                    addCriterion("zylb not between", value1, value2, "zylb");
                                    return (Criteria) this;
                                    }
                            public Criteria andFzdwbmIsNull() {
                            addCriterion("fzdwbm is null");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmIsNotNull() {
                            addCriterion("fzdwbm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmEqualTo(String value) {
                            addCriterion("fzdwbm =", value, "fzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmNotEqualTo(String value) {
                            addCriterion("fzdwbm <>", value, "fzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmGreaterThan(String value) {
                            addCriterion("fzdwbm >", value, "fzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmGreaterThanOrEqualTo(String value) {
                            addCriterion("fzdwbm >=", value, "fzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmLessThan(String value) {
                            addCriterion("fzdwbm <", value, "fzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmLessThanOrEqualTo(String value) {
                            addCriterion("fzdwbm <=", value, "fzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmLike(String value) {
                            addCriterion("fzdwbm like", value, "fzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmNotLike(String value) {
                            addCriterion("fzdwbm not like", value, "fzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwbmIn(List<String> values) {
                                addCriterion("fzdwbm in", values, "fzdwbm");
                                return (Criteria) this;
                                }

                                public Criteria andFzdwbmNotIn(List<String> values) {
                                    addCriterion("fzdwbm not in", values, "fzdwbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzdwbmBetween(String value1, String value2) {
                                    addCriterion("fzdwbm between", value1, value2, "fzdwbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzdwbmNotBetween(String value1, String value2) {
                                    addCriterion("fzdwbm not between", value1, value2, "fzdwbm");
                                    return (Criteria) this;
                                    }
                            public Criteria andFzdwIsNull() {
                            addCriterion("fzdw is null");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwIsNotNull() {
                            addCriterion("fzdw is not null");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwEqualTo(String value) {
                            addCriterion("fzdw =", value, "fzdw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwNotEqualTo(String value) {
                            addCriterion("fzdw <>", value, "fzdw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwGreaterThan(String value) {
                            addCriterion("fzdw >", value, "fzdw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwGreaterThanOrEqualTo(String value) {
                            addCriterion("fzdw >=", value, "fzdw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwLessThan(String value) {
                            addCriterion("fzdw <", value, "fzdw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwLessThanOrEqualTo(String value) {
                            addCriterion("fzdw <=", value, "fzdw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwLike(String value) {
                            addCriterion("fzdw like", value, "fzdw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwNotLike(String value) {
                            addCriterion("fzdw not like", value, "fzdw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwIn(List<String> values) {
                                addCriterion("fzdw in", values, "fzdw");
                                return (Criteria) this;
                                }

                                public Criteria andFzdwNotIn(List<String> values) {
                                    addCriterion("fzdw not in", values, "fzdw");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzdwBetween(String value1, String value2) {
                                    addCriterion("fzdw between", value1, value2, "fzdw");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzdwNotBetween(String value1, String value2) {
                                    addCriterion("fzdw not between", value1, value2, "fzdw");
                                    return (Criteria) this;
                                    }
                            public Criteria andJtfzdwbmIsNull() {
                            addCriterion("jtfzdwbm is null");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmIsNotNull() {
                            addCriterion("jtfzdwbm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmEqualTo(String value) {
                            addCriterion("jtfzdwbm =", value, "jtfzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmNotEqualTo(String value) {
                            addCriterion("jtfzdwbm <>", value, "jtfzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmGreaterThan(String value) {
                            addCriterion("jtfzdwbm >", value, "jtfzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmGreaterThanOrEqualTo(String value) {
                            addCriterion("jtfzdwbm >=", value, "jtfzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmLessThan(String value) {
                            addCriterion("jtfzdwbm <", value, "jtfzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmLessThanOrEqualTo(String value) {
                            addCriterion("jtfzdwbm <=", value, "jtfzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmLike(String value) {
                            addCriterion("jtfzdwbm like", value, "jtfzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmNotLike(String value) {
                            addCriterion("jtfzdwbm not like", value, "jtfzdwbm");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwbmIn(List<String> values) {
                                addCriterion("jtfzdwbm in", values, "jtfzdwbm");
                                return (Criteria) this;
                                }

                                public Criteria andJtfzdwbmNotIn(List<String> values) {
                                    addCriterion("jtfzdwbm not in", values, "jtfzdwbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJtfzdwbmBetween(String value1, String value2) {
                                    addCriterion("jtfzdwbm between", value1, value2, "jtfzdwbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJtfzdwbmNotBetween(String value1, String value2) {
                                    addCriterion("jtfzdwbm not between", value1, value2, "jtfzdwbm");
                                    return (Criteria) this;
                                    }
                            public Criteria andJtfzdwIsNull() {
                            addCriterion("jtfzdw is null");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwIsNotNull() {
                            addCriterion("jtfzdw is not null");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwEqualTo(String value) {
                            addCriterion("jtfzdw =", value, "jtfzdw");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwNotEqualTo(String value) {
                            addCriterion("jtfzdw <>", value, "jtfzdw");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwGreaterThan(String value) {
                            addCriterion("jtfzdw >", value, "jtfzdw");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwGreaterThanOrEqualTo(String value) {
                            addCriterion("jtfzdw >=", value, "jtfzdw");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwLessThan(String value) {
                            addCriterion("jtfzdw <", value, "jtfzdw");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwLessThanOrEqualTo(String value) {
                            addCriterion("jtfzdw <=", value, "jtfzdw");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwLike(String value) {
                            addCriterion("jtfzdw like", value, "jtfzdw");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwNotLike(String value) {
                            addCriterion("jtfzdw not like", value, "jtfzdw");
                            return (Criteria) this;
                            }

                            public Criteria andJtfzdwIn(List<String> values) {
                                addCriterion("jtfzdw in", values, "jtfzdw");
                                return (Criteria) this;
                                }

                                public Criteria andJtfzdwNotIn(List<String> values) {
                                    addCriterion("jtfzdw not in", values, "jtfzdw");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJtfzdwBetween(String value1, String value2) {
                                    addCriterion("jtfzdw between", value1, value2, "jtfzdw");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJtfzdwNotBetween(String value1, String value2) {
                                    addCriterion("jtfzdw not between", value1, value2, "jtfzdw");
                                    return (Criteria) this;
                                    }
                            public Criteria andFzryxIsNull() {
                            addCriterion("fzryx is null");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxIsNotNull() {
                            addCriterion("fzryx is not null");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxEqualTo(String value) {
                            addCriterion("fzryx =", value, "fzryx");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxNotEqualTo(String value) {
                            addCriterion("fzryx <>", value, "fzryx");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxGreaterThan(String value) {
                            addCriterion("fzryx >", value, "fzryx");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxGreaterThanOrEqualTo(String value) {
                            addCriterion("fzryx >=", value, "fzryx");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxLessThan(String value) {
                            addCriterion("fzryx <", value, "fzryx");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxLessThanOrEqualTo(String value) {
                            addCriterion("fzryx <=", value, "fzryx");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxLike(String value) {
                            addCriterion("fzryx like", value, "fzryx");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxNotLike(String value) {
                            addCriterion("fzryx not like", value, "fzryx");
                            return (Criteria) this;
                            }

                            public Criteria andFzryxIn(List<String> values) {
                                addCriterion("fzryx in", values, "fzryx");
                                return (Criteria) this;
                                }

                                public Criteria andFzryxNotIn(List<String> values) {
                                    addCriterion("fzryx not in", values, "fzryx");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzryxBetween(String value1, String value2) {
                                    addCriterion("fzryx between", value1, value2, "fzryx");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzryxNotBetween(String value1, String value2) {
                                    addCriterion("fzryx not between", value1, value2, "fzryx");
                                    return (Criteria) this;
                                    }
                            public Criteria andFzrdhIsNull() {
                            addCriterion("fzrdh is null");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhIsNotNull() {
                            addCriterion("fzrdh is not null");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhEqualTo(String value) {
                            addCriterion("fzrdh =", value, "fzrdh");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhNotEqualTo(String value) {
                            addCriterion("fzrdh <>", value, "fzrdh");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhGreaterThan(String value) {
                            addCriterion("fzrdh >", value, "fzrdh");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhGreaterThanOrEqualTo(String value) {
                            addCriterion("fzrdh >=", value, "fzrdh");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhLessThan(String value) {
                            addCriterion("fzrdh <", value, "fzrdh");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhLessThanOrEqualTo(String value) {
                            addCriterion("fzrdh <=", value, "fzrdh");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhLike(String value) {
                            addCriterion("fzrdh like", value, "fzrdh");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhNotLike(String value) {
                            addCriterion("fzrdh not like", value, "fzrdh");
                            return (Criteria) this;
                            }

                            public Criteria andFzrdhIn(List<String> values) {
                                addCriterion("fzrdh in", values, "fzrdh");
                                return (Criteria) this;
                                }

                                public Criteria andFzrdhNotIn(List<String> values) {
                                    addCriterion("fzrdh not in", values, "fzrdh");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzrdhBetween(String value1, String value2) {
                                    addCriterion("fzrdh between", value1, value2, "fzrdh");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzrdhNotBetween(String value1, String value2) {
                                    addCriterion("fzrdh not between", value1, value2, "fzrdh");
                                    return (Criteria) this;
                                    }
                            public Criteria andFzrxmIsNull() {
                            addCriterion("fzrxm is null");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmIsNotNull() {
                            addCriterion("fzrxm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmEqualTo(String value) {
                            addCriterion("fzrxm =", value, "fzrxm");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmNotEqualTo(String value) {
                            addCriterion("fzrxm <>", value, "fzrxm");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmGreaterThan(String value) {
                            addCriterion("fzrxm >", value, "fzrxm");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmGreaterThanOrEqualTo(String value) {
                            addCriterion("fzrxm >=", value, "fzrxm");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmLessThan(String value) {
                            addCriterion("fzrxm <", value, "fzrxm");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmLessThanOrEqualTo(String value) {
                            addCriterion("fzrxm <=", value, "fzrxm");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmLike(String value) {
                            addCriterion("fzrxm like", value, "fzrxm");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmNotLike(String value) {
                            addCriterion("fzrxm not like", value, "fzrxm");
                            return (Criteria) this;
                            }

                            public Criteria andFzrxmIn(List<String> values) {
                                addCriterion("fzrxm in", values, "fzrxm");
                                return (Criteria) this;
                                }

                                public Criteria andFzrxmNotIn(List<String> values) {
                                    addCriterion("fzrxm not in", values, "fzrxm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzrxmBetween(String value1, String value2) {
                                    addCriterion("fzrxm between", value1, value2, "fzrxm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzrxmNotBetween(String value1, String value2) {
                                    addCriterion("fzrxm not between", value1, value2, "fzrxm");
                                    return (Criteria) this;
                                    }
                            public Criteria andLxrdhIsNull() {
                            addCriterion("lxrdh is null");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhIsNotNull() {
                            addCriterion("lxrdh is not null");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhEqualTo(String value) {
                            addCriterion("lxrdh =", value, "lxrdh");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhNotEqualTo(String value) {
                            addCriterion("lxrdh <>", value, "lxrdh");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhGreaterThan(String value) {
                            addCriterion("lxrdh >", value, "lxrdh");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhGreaterThanOrEqualTo(String value) {
                            addCriterion("lxrdh >=", value, "lxrdh");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhLessThan(String value) {
                            addCriterion("lxrdh <", value, "lxrdh");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhLessThanOrEqualTo(String value) {
                            addCriterion("lxrdh <=", value, "lxrdh");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhLike(String value) {
                            addCriterion("lxrdh like", value, "lxrdh");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhNotLike(String value) {
                            addCriterion("lxrdh not like", value, "lxrdh");
                            return (Criteria) this;
                            }

                            public Criteria andLxrdhIn(List<String> values) {
                                addCriterion("lxrdh in", values, "lxrdh");
                                return (Criteria) this;
                                }

                                public Criteria andLxrdhNotIn(List<String> values) {
                                    addCriterion("lxrdh not in", values, "lxrdh");
                                    return (Criteria) this;
                                    }

                                    public Criteria andLxrdhBetween(String value1, String value2) {
                                    addCriterion("lxrdh between", value1, value2, "lxrdh");
                                    return (Criteria) this;
                                    }

                                    public Criteria andLxrdhNotBetween(String value1, String value2) {
                                    addCriterion("lxrdh not between", value1, value2, "lxrdh");
                                    return (Criteria) this;
                                    }
                            public Criteria andLxryxIsNull() {
                            addCriterion("lxryx is null");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxIsNotNull() {
                            addCriterion("lxryx is not null");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxEqualTo(String value) {
                            addCriterion("lxryx =", value, "lxryx");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxNotEqualTo(String value) {
                            addCriterion("lxryx <>", value, "lxryx");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxGreaterThan(String value) {
                            addCriterion("lxryx >", value, "lxryx");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxGreaterThanOrEqualTo(String value) {
                            addCriterion("lxryx >=", value, "lxryx");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxLessThan(String value) {
                            addCriterion("lxryx <", value, "lxryx");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxLessThanOrEqualTo(String value) {
                            addCriterion("lxryx <=", value, "lxryx");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxLike(String value) {
                            addCriterion("lxryx like", value, "lxryx");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxNotLike(String value) {
                            addCriterion("lxryx not like", value, "lxryx");
                            return (Criteria) this;
                            }

                            public Criteria andLxryxIn(List<String> values) {
                                addCriterion("lxryx in", values, "lxryx");
                                return (Criteria) this;
                                }

                                public Criteria andLxryxNotIn(List<String> values) {
                                    addCriterion("lxryx not in", values, "lxryx");
                                    return (Criteria) this;
                                    }

                                    public Criteria andLxryxBetween(String value1, String value2) {
                                    addCriterion("lxryx between", value1, value2, "lxryx");
                                    return (Criteria) this;
                                    }

                                    public Criteria andLxryxNotBetween(String value1, String value2) {
                                    addCriterion("lxryx not between", value1, value2, "lxryx");
                                    return (Criteria) this;
                                    }
                            public Criteria andLxrxmIsNull() {
                            addCriterion("lxrxm is null");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmIsNotNull() {
                            addCriterion("lxrxm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmEqualTo(String value) {
                            addCriterion("lxrxm =", value, "lxrxm");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmNotEqualTo(String value) {
                            addCriterion("lxrxm <>", value, "lxrxm");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmGreaterThan(String value) {
                            addCriterion("lxrxm >", value, "lxrxm");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmGreaterThanOrEqualTo(String value) {
                            addCriterion("lxrxm >=", value, "lxrxm");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmLessThan(String value) {
                            addCriterion("lxrxm <", value, "lxrxm");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmLessThanOrEqualTo(String value) {
                            addCriterion("lxrxm <=", value, "lxrxm");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmLike(String value) {
                            addCriterion("lxrxm like", value, "lxrxm");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmNotLike(String value) {
                            addCriterion("lxrxm not like", value, "lxrxm");
                            return (Criteria) this;
                            }

                            public Criteria andLxrxmIn(List<String> values) {
                                addCriterion("lxrxm in", values, "lxrxm");
                                return (Criteria) this;
                                }

                                public Criteria andLxrxmNotIn(List<String> values) {
                                    addCriterion("lxrxm not in", values, "lxrxm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andLxrxmBetween(String value1, String value2) {
                                    addCriterion("lxrxm between", value1, value2, "lxrxm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andLxrxmNotBetween(String value1, String value2) {
                                    addCriterion("lxrxm not between", value1, value2, "lxrxm");
                                    return (Criteria) this;
                                    }
                            public Criteria andJssxxmIsNull() {
                            addCriterion("jssxxm is null");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmIsNotNull() {
                            addCriterion("jssxxm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmEqualTo(String value) {
                            addCriterion("jssxxm =", value, "jssxxm");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmNotEqualTo(String value) {
                            addCriterion("jssxxm <>", value, "jssxxm");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmGreaterThan(String value) {
                            addCriterion("jssxxm >", value, "jssxxm");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmGreaterThanOrEqualTo(String value) {
                            addCriterion("jssxxm >=", value, "jssxxm");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmLessThan(String value) {
                            addCriterion("jssxxm <", value, "jssxxm");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmLessThanOrEqualTo(String value) {
                            addCriterion("jssxxm <=", value, "jssxxm");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmLike(String value) {
                            addCriterion("jssxxm like", value, "jssxxm");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmNotLike(String value) {
                            addCriterion("jssxxm not like", value, "jssxxm");
                            return (Criteria) this;
                            }

                            public Criteria andJssxxmIn(List<String> values) {
                                addCriterion("jssxxm in", values, "jssxxm");
                                return (Criteria) this;
                                }

                                public Criteria andJssxxmNotIn(List<String> values) {
                                    addCriterion("jssxxm not in", values, "jssxxm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJssxxmBetween(String value1, String value2) {
                                    addCriterion("jssxxm between", value1, value2, "jssxxm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJssxxmNotBetween(String value1, String value2) {
                                    addCriterion("jssxxm not between", value1, value2, "jssxxm");
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
                            public Criteria andYjsjIsNull() {
                            addCriterion("yjsj is null");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjIsNotNull() {
                            addCriterion("yjsj is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjEqualTo(String value) {
                            addCriterion("yjsj =", value, "yjsj");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjNotEqualTo(String value) {
                            addCriterion("yjsj <>", value, "yjsj");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjGreaterThan(String value) {
                            addCriterion("yjsj >", value, "yjsj");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjGreaterThanOrEqualTo(String value) {
                            addCriterion("yjsj >=", value, "yjsj");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjLessThan(String value) {
                            addCriterion("yjsj <", value, "yjsj");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjLessThanOrEqualTo(String value) {
                            addCriterion("yjsj <=", value, "yjsj");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjLike(String value) {
                            addCriterion("yjsj like", value, "yjsj");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjNotLike(String value) {
                            addCriterion("yjsj not like", value, "yjsj");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjIn(List<String> values) {
                                addCriterion("yjsj in", values, "yjsj");
                                return (Criteria) this;
                                }

                                public Criteria andYjsjNotIn(List<String> values) {
                                    addCriterion("yjsj not in", values, "yjsj");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjsjBetween(String value1, String value2) {
                                    addCriterion("yjsj between", value1, value2, "yjsj");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjsjNotBetween(String value1, String value2) {
                                    addCriterion("yjsj not between", value1, value2, "yjsj");
                                    return (Criteria) this;
                                    }
                            public Criteria andZylyIsNull() {
                            addCriterion("zyly is null");
                            return (Criteria) this;
                            }

                            public Criteria andZylyIsNotNull() {
                            addCriterion("zyly is not null");
                            return (Criteria) this;
                            }

                            public Criteria andZylyEqualTo(String value) {
                            addCriterion("zyly =", value, "zyly");
                            return (Criteria) this;
                            }

                            public Criteria andZylyNotEqualTo(String value) {
                            addCriterion("zyly <>", value, "zyly");
                            return (Criteria) this;
                            }

                            public Criteria andZylyGreaterThan(String value) {
                            addCriterion("zyly >", value, "zyly");
                            return (Criteria) this;
                            }

                            public Criteria andZylyGreaterThanOrEqualTo(String value) {
                            addCriterion("zyly >=", value, "zyly");
                            return (Criteria) this;
                            }

                            public Criteria andZylyLessThan(String value) {
                            addCriterion("zyly <", value, "zyly");
                            return (Criteria) this;
                            }

                            public Criteria andZylyLessThanOrEqualTo(String value) {
                            addCriterion("zyly <=", value, "zyly");
                            return (Criteria) this;
                            }

                            public Criteria andZylyLike(String value) {
                            addCriterion("zyly like", value, "zyly");
                            return (Criteria) this;
                            }

                            public Criteria andZylyNotLike(String value) {
                            addCriterion("zyly not like", value, "zyly");
                            return (Criteria) this;
                            }

                            public Criteria andZylyIn(List<String> values) {
                                addCriterion("zyly in", values, "zyly");
                                return (Criteria) this;
                                }

                                public Criteria andZylyNotIn(List<String> values) {
                                    addCriterion("zyly not in", values, "zyly");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZylyBetween(String value1, String value2) {
                                    addCriterion("zyly between", value1, value2, "zyly");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZylyNotBetween(String value1, String value2) {
                                    addCriterion("zyly not between", value1, value2, "zyly");
                                    return (Criteria) this;
                                    }
                            public Criteria andZysxIsNull() {
                            addCriterion("zysx is null");
                            return (Criteria) this;
                            }

                            public Criteria andZysxIsNotNull() {
                            addCriterion("zysx is not null");
                            return (Criteria) this;
                            }

                            public Criteria andZysxEqualTo(String value) {
                            addCriterion("zysx =", value, "zysx");
                            return (Criteria) this;
                            }

                            public Criteria andZysxNotEqualTo(String value) {
                            addCriterion("zysx <>", value, "zysx");
                            return (Criteria) this;
                            }

                            public Criteria andZysxGreaterThan(String value) {
                            addCriterion("zysx >", value, "zysx");
                            return (Criteria) this;
                            }

                            public Criteria andZysxGreaterThanOrEqualTo(String value) {
                            addCriterion("zysx >=", value, "zysx");
                            return (Criteria) this;
                            }

                            public Criteria andZysxLessThan(String value) {
                            addCriterion("zysx <", value, "zysx");
                            return (Criteria) this;
                            }

                            public Criteria andZysxLessThanOrEqualTo(String value) {
                            addCriterion("zysx <=", value, "zysx");
                            return (Criteria) this;
                            }

                            public Criteria andZysxLike(String value) {
                            addCriterion("zysx like", value, "zysx");
                            return (Criteria) this;
                            }

                            public Criteria andZysxNotLike(String value) {
                            addCriterion("zysx not like", value, "zysx");
                            return (Criteria) this;
                            }

                            public Criteria andZysxIn(List<String> values) {
                                addCriterion("zysx in", values, "zysx");
                                return (Criteria) this;
                                }

                                public Criteria andZysxNotIn(List<String> values) {
                                    addCriterion("zysx not in", values, "zysx");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZysxBetween(String value1, String value2) {
                                    addCriterion("zysx between", value1, value2, "zysx");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZysxNotBetween(String value1, String value2) {
                                    addCriterion("zysx not between", value1, value2, "zysx");
                                    return (Criteria) this;
                                    }
                            public Criteria andSjidIsNull() {
                            addCriterion("sjid is null");
                            return (Criteria) this;
                            }

                            public Criteria andSjidIsNotNull() {
                            addCriterion("sjid is not null");
                            return (Criteria) this;
                            }

                            public Criteria andSjidEqualTo(String value) {
                            addCriterion("sjid =", value, "sjid");
                            return (Criteria) this;
                            }

                            public Criteria andSjidNotEqualTo(String value) {
                            addCriterion("sjid <>", value, "sjid");
                            return (Criteria) this;
                            }

                            public Criteria andSjidGreaterThan(String value) {
                            addCriterion("sjid >", value, "sjid");
                            return (Criteria) this;
                            }

                            public Criteria andSjidGreaterThanOrEqualTo(String value) {
                            addCriterion("sjid >=", value, "sjid");
                            return (Criteria) this;
                            }

                            public Criteria andSjidLessThan(String value) {
                            addCriterion("sjid <", value, "sjid");
                            return (Criteria) this;
                            }

                            public Criteria andSjidLessThanOrEqualTo(String value) {
                            addCriterion("sjid <=", value, "sjid");
                            return (Criteria) this;
                            }

                            public Criteria andSjidLike(String value) {
                            addCriterion("sjid like", value, "sjid");
                            return (Criteria) this;
                            }

                            public Criteria andSjidNotLike(String value) {
                            addCriterion("sjid not like", value, "sjid");
                            return (Criteria) this;
                            }

                            public Criteria andSjidIn(List<String> values) {
                                addCriterion("sjid in", values, "sjid");
                                return (Criteria) this;
                                }

                                public Criteria andSjidNotIn(List<String> values) {
                                    addCriterion("sjid not in", values, "sjid");
                                    return (Criteria) this;
                                    }

                                    public Criteria andSjidBetween(String value1, String value2) {
                                    addCriterion("sjid between", value1, value2, "sjid");
                                    return (Criteria) this;
                                    }

                                    public Criteria andSjidNotBetween(String value1, String value2) {
                                    addCriterion("sjid not between", value1, value2, "sjid");
                                    return (Criteria) this;
                                    }
                            public Criteria andLxbjIsNull() {
                            addCriterion("lxbj is null");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjIsNotNull() {
                            addCriterion("lxbj is not null");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjEqualTo(String value) {
                            addCriterion("lxbj =", value, "lxbj");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjNotEqualTo(String value) {
                            addCriterion("lxbj <>", value, "lxbj");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjGreaterThan(String value) {
                            addCriterion("lxbj >", value, "lxbj");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjGreaterThanOrEqualTo(String value) {
                            addCriterion("lxbj >=", value, "lxbj");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjLessThan(String value) {
                            addCriterion("lxbj <", value, "lxbj");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjLessThanOrEqualTo(String value) {
                            addCriterion("lxbj <=", value, "lxbj");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjLike(String value) {
                            addCriterion("lxbj like", value, "lxbj");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjNotLike(String value) {
                            addCriterion("lxbj not like", value, "lxbj");
                            return (Criteria) this;
                            }

                            public Criteria andLxbjIn(List<String> values) {
                                addCriterion("lxbj in", values, "lxbj");
                                return (Criteria) this;
                                }

                                public Criteria andLxbjNotIn(List<String> values) {
                                    addCriterion("lxbj not in", values, "lxbj");
                                    return (Criteria) this;
                                    }

                                    public Criteria andLxbjBetween(String value1, String value2) {
                                    addCriterion("lxbj between", value1, value2, "lxbj");
                                    return (Criteria) this;
                                    }

                                    public Criteria andLxbjNotBetween(String value1, String value2) {
                                    addCriterion("lxbj not between", value1, value2, "lxbj");
                                    return (Criteria) this;
                                    }
                            public Criteria andYjnrIsNull() {
                            addCriterion("yjnr is null");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrIsNotNull() {
                            addCriterion("yjnr is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrEqualTo(String value) {
                            addCriterion("yjnr =", value, "yjnr");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrNotEqualTo(String value) {
                            addCriterion("yjnr <>", value, "yjnr");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrGreaterThan(String value) {
                            addCriterion("yjnr >", value, "yjnr");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrGreaterThanOrEqualTo(String value) {
                            addCriterion("yjnr >=", value, "yjnr");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrLessThan(String value) {
                            addCriterion("yjnr <", value, "yjnr");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrLessThanOrEqualTo(String value) {
                            addCriterion("yjnr <=", value, "yjnr");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrLike(String value) {
                            addCriterion("yjnr like", value, "yjnr");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrNotLike(String value) {
                            addCriterion("yjnr not like", value, "yjnr");
                            return (Criteria) this;
                            }

                            public Criteria andYjnrIn(List<String> values) {
                                addCriterion("yjnr in", values, "yjnr");
                                return (Criteria) this;
                                }

                                public Criteria andYjnrNotIn(List<String> values) {
                                    addCriterion("yjnr not in", values, "yjnr");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjnrBetween(String value1, String value2) {
                                    addCriterion("yjnr between", value1, value2, "yjnr");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjnrNotBetween(String value1, String value2) {
                                    addCriterion("yjnr not between", value1, value2, "yjnr");
                                    return (Criteria) this;
                                    }
                            public Criteria andJdapIsNull() {
                            addCriterion("jdap is null");
                            return (Criteria) this;
                            }

                            public Criteria andJdapIsNotNull() {
                            addCriterion("jdap is not null");
                            return (Criteria) this;
                            }

                            public Criteria andJdapEqualTo(String value) {
                            addCriterion("jdap =", value, "jdap");
                            return (Criteria) this;
                            }

                            public Criteria andJdapNotEqualTo(String value) {
                            addCriterion("jdap <>", value, "jdap");
                            return (Criteria) this;
                            }

                            public Criteria andJdapGreaterThan(String value) {
                            addCriterion("jdap >", value, "jdap");
                            return (Criteria) this;
                            }

                            public Criteria andJdapGreaterThanOrEqualTo(String value) {
                            addCriterion("jdap >=", value, "jdap");
                            return (Criteria) this;
                            }

                            public Criteria andJdapLessThan(String value) {
                            addCriterion("jdap <", value, "jdap");
                            return (Criteria) this;
                            }

                            public Criteria andJdapLessThanOrEqualTo(String value) {
                            addCriterion("jdap <=", value, "jdap");
                            return (Criteria) this;
                            }

                            public Criteria andJdapLike(String value) {
                            addCriterion("jdap like", value, "jdap");
                            return (Criteria) this;
                            }

                            public Criteria andJdapNotLike(String value) {
                            addCriterion("jdap not like", value, "jdap");
                            return (Criteria) this;
                            }

                            public Criteria andJdapIn(List<String> values) {
                                addCriterion("jdap in", values, "jdap");
                                return (Criteria) this;
                                }

                                public Criteria andJdapNotIn(List<String> values) {
                                    addCriterion("jdap not in", values, "jdap");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJdapBetween(String value1, String value2) {
                                    addCriterion("jdap between", value1, value2, "jdap");
                                    return (Criteria) this;
                                    }

                                    public Criteria andJdapNotBetween(String value1, String value2) {
                                    addCriterion("jdap not between", value1, value2, "jdap");
                                    return (Criteria) this;
                                    }
                            public Criteria andYjmbIsNull() {
                            addCriterion("yjmb is null");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbIsNotNull() {
                            addCriterion("yjmb is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbEqualTo(String value) {
                            addCriterion("yjmb =", value, "yjmb");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbNotEqualTo(String value) {
                            addCriterion("yjmb <>", value, "yjmb");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbGreaterThan(String value) {
                            addCriterion("yjmb >", value, "yjmb");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbGreaterThanOrEqualTo(String value) {
                            addCriterion("yjmb >=", value, "yjmb");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbLessThan(String value) {
                            addCriterion("yjmb <", value, "yjmb");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbLessThanOrEqualTo(String value) {
                            addCriterion("yjmb <=", value, "yjmb");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbLike(String value) {
                            addCriterion("yjmb like", value, "yjmb");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbNotLike(String value) {
                            addCriterion("yjmb not like", value, "yjmb");
                            return (Criteria) this;
                            }

                            public Criteria andYjmbIn(List<String> values) {
                                addCriterion("yjmb in", values, "yjmb");
                                return (Criteria) this;
                                }

                                public Criteria andYjmbNotIn(List<String> values) {
                                    addCriterion("yjmb not in", values, "yjmb");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjmbBetween(String value1, String value2) {
                                    addCriterion("yjmb between", value1, value2, "yjmb");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjmbNotBetween(String value1, String value2) {
                                    addCriterion("yjmb not between", value1, value2, "yjmb");
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
                            public Criteria andCreatePersonIsNull() {
                            addCriterion("create_person is null");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonIsNotNull() {
                            addCriterion("create_person is not null");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonEqualTo(String value) {
                            addCriterion("create_person =", value, "createPerson");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonNotEqualTo(String value) {
                            addCriterion("create_person <>", value, "createPerson");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonGreaterThan(String value) {
                            addCriterion("create_person >", value, "createPerson");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonGreaterThanOrEqualTo(String value) {
                            addCriterion("create_person >=", value, "createPerson");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonLessThan(String value) {
                            addCriterion("create_person <", value, "createPerson");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonLessThanOrEqualTo(String value) {
                            addCriterion("create_person <=", value, "createPerson");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonLike(String value) {
                            addCriterion("create_person like", value, "createPerson");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonNotLike(String value) {
                            addCriterion("create_person not like", value, "createPerson");
                            return (Criteria) this;
                            }

                            public Criteria andCreatePersonIn(List<String> values) {
                                addCriterion("create_person in", values, "createPerson");
                                return (Criteria) this;
                                }

                                public Criteria andCreatePersonNotIn(List<String> values) {
                                    addCriterion("create_person not in", values, "createPerson");
                                    return (Criteria) this;
                                    }

                                    public Criteria andCreatePersonBetween(String value1, String value2) {
                                    addCriterion("create_person between", value1, value2, "createPerson");
                                    return (Criteria) this;
                                    }

                                    public Criteria andCreatePersonNotBetween(String value1, String value2) {
                                    addCriterion("create_person not between", value1, value2, "createPerson");
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
                            public Criteria andProjectIdIsNull() {
                            addCriterion("project_id is null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdIsNotNull() {
                            addCriterion("project_id is not null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdEqualTo(String value) {
                            addCriterion("project_id =", value, "projectId");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdNotEqualTo(String value) {
                            addCriterion("project_id <>", value, "projectId");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdGreaterThan(String value) {
                            addCriterion("project_id >", value, "projectId");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
                            addCriterion("project_id >=", value, "projectId");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdLessThan(String value) {
                            addCriterion("project_id <", value, "projectId");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdLessThanOrEqualTo(String value) {
                            addCriterion("project_id <=", value, "projectId");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdLike(String value) {
                            addCriterion("project_id like", value, "projectId");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdNotLike(String value) {
                            addCriterion("project_id not like", value, "projectId");
                            return (Criteria) this;
                            }

                            public Criteria andProjectIdIn(List<String> values) {
                                addCriterion("project_id in", values, "projectId");
                                return (Criteria) this;
                                }

                                public Criteria andProjectIdNotIn(List<String> values) {
                                    addCriterion("project_id not in", values, "projectId");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectIdBetween(String value1, String value2) {
                                    addCriterion("project_id between", value1, value2, "projectId");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectIdNotBetween(String value1, String value2) {
                                    addCriterion("project_id not between", value1, value2, "projectId");
                                    return (Criteria) this;
                                    }
                            public Criteria andParentProjectIdIsNull() {
                            addCriterion("parent_project_id is null");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdIsNotNull() {
                            addCriterion("parent_project_id is not null");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdEqualTo(String value) {
                            addCriterion("parent_project_id =", value, "parentProjectId");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdNotEqualTo(String value) {
                            addCriterion("parent_project_id <>", value, "parentProjectId");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdGreaterThan(String value) {
                            addCriterion("parent_project_id >", value, "parentProjectId");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdGreaterThanOrEqualTo(String value) {
                            addCriterion("parent_project_id >=", value, "parentProjectId");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdLessThan(String value) {
                            addCriterion("parent_project_id <", value, "parentProjectId");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdLessThanOrEqualTo(String value) {
                            addCriterion("parent_project_id <=", value, "parentProjectId");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdLike(String value) {
                            addCriterion("parent_project_id like", value, "parentProjectId");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdNotLike(String value) {
                            addCriterion("parent_project_id not like", value, "parentProjectId");
                            return (Criteria) this;
                            }

                            public Criteria andParentProjectIdIn(List<String> values) {
                                addCriterion("parent_project_id in", values, "parentProjectId");
                                return (Criteria) this;
                                }

                                public Criteria andParentProjectIdNotIn(List<String> values) {
                                    addCriterion("parent_project_id not in", values, "parentProjectId");
                                    return (Criteria) this;
                                    }

                                    public Criteria andParentProjectIdBetween(String value1, String value2) {
                                    addCriterion("parent_project_id between", value1, value2, "parentProjectId");
                                    return (Criteria) this;
                                    }

                                    public Criteria andParentProjectIdNotBetween(String value1, String value2) {
                                    addCriterion("parent_project_id not between", value1, value2, "parentProjectId");
                                    return (Criteria) this;
                                    }
                            public Criteria andProjectTypeIsNull() {
                            addCriterion("project_type is null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeIsNotNull() {
                            addCriterion("project_type is not null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeEqualTo(String value) {
                            addCriterion("project_type =", value, "projectType");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeNotEqualTo(String value) {
                            addCriterion("project_type <>", value, "projectType");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeGreaterThan(String value) {
                            addCriterion("project_type >", value, "projectType");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
                            addCriterion("project_type >=", value, "projectType");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeLessThan(String value) {
                            addCriterion("project_type <", value, "projectType");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeLessThanOrEqualTo(String value) {
                            addCriterion("project_type <=", value, "projectType");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeLike(String value) {
                            addCriterion("project_type like", value, "projectType");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeNotLike(String value) {
                            addCriterion("project_type not like", value, "projectType");
                            return (Criteria) this;
                            }

                            public Criteria andProjectTypeIn(List<String> values) {
                                addCriterion("project_type in", values, "projectType");
                                return (Criteria) this;
                                }

                                public Criteria andProjectTypeNotIn(List<String> values) {
                                    addCriterion("project_type not in", values, "projectType");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectTypeBetween(String value1, String value2) {
                                    addCriterion("project_type between", value1, value2, "projectType");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectTypeNotBetween(String value1, String value2) {
                                    addCriterion("project_type not between", value1, value2, "projectType");
                                    return (Criteria) this;
                                    }
                            public Criteria andErpProjectCodeIsNull() {
                            addCriterion("erp_project_code is null");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeIsNotNull() {
                            addCriterion("erp_project_code is not null");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeEqualTo(String value) {
                            addCriterion("erp_project_code =", value, "erpProjectCode");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeNotEqualTo(String value) {
                            addCriterion("erp_project_code <>", value, "erpProjectCode");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeGreaterThan(String value) {
                            addCriterion("erp_project_code >", value, "erpProjectCode");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeGreaterThanOrEqualTo(String value) {
                            addCriterion("erp_project_code >=", value, "erpProjectCode");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeLessThan(String value) {
                            addCriterion("erp_project_code <", value, "erpProjectCode");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeLessThanOrEqualTo(String value) {
                            addCriterion("erp_project_code <=", value, "erpProjectCode");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeLike(String value) {
                            addCriterion("erp_project_code like", value, "erpProjectCode");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeNotLike(String value) {
                            addCriterion("erp_project_code not like", value, "erpProjectCode");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectCodeIn(List<String> values) {
                                addCriterion("erp_project_code in", values, "erpProjectCode");
                                return (Criteria) this;
                                }

                                public Criteria andErpProjectCodeNotIn(List<String> values) {
                                    addCriterion("erp_project_code not in", values, "erpProjectCode");
                                    return (Criteria) this;
                                    }

                                    public Criteria andErpProjectCodeBetween(String value1, String value2) {
                                    addCriterion("erp_project_code between", value1, value2, "erpProjectCode");
                                    return (Criteria) this;
                                    }

                                    public Criteria andErpProjectCodeNotBetween(String value1, String value2) {
                                    addCriterion("erp_project_code not between", value1, value2, "erpProjectCode");
                                    return (Criteria) this;
                                    }
                            public Criteria andErpProjectNameIsNull() {
                            addCriterion("erp_project_name is null");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameIsNotNull() {
                            addCriterion("erp_project_name is not null");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameEqualTo(String value) {
                            addCriterion("erp_project_name =", value, "erpProjectName");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameNotEqualTo(String value) {
                            addCriterion("erp_project_name <>", value, "erpProjectName");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameGreaterThan(String value) {
                            addCriterion("erp_project_name >", value, "erpProjectName");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameGreaterThanOrEqualTo(String value) {
                            addCriterion("erp_project_name >=", value, "erpProjectName");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameLessThan(String value) {
                            addCriterion("erp_project_name <", value, "erpProjectName");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameLessThanOrEqualTo(String value) {
                            addCriterion("erp_project_name <=", value, "erpProjectName");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameLike(String value) {
                            addCriterion("erp_project_name like", value, "erpProjectName");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameNotLike(String value) {
                            addCriterion("erp_project_name not like", value, "erpProjectName");
                            return (Criteria) this;
                            }

                            public Criteria andErpProjectNameIn(List<String> values) {
                                addCriterion("erp_project_name in", values, "erpProjectName");
                                return (Criteria) this;
                                }

                                public Criteria andErpProjectNameNotIn(List<String> values) {
                                    addCriterion("erp_project_name not in", values, "erpProjectName");
                                    return (Criteria) this;
                                    }

                                    public Criteria andErpProjectNameBetween(String value1, String value2) {
                                    addCriterion("erp_project_name between", value1, value2, "erpProjectName");
                                    return (Criteria) this;
                                    }

                                    public Criteria andErpProjectNameNotBetween(String value1, String value2) {
                                    addCriterion("erp_project_name not between", value1, value2, "erpProjectName");
                                    return (Criteria) this;
                                    }
                            public Criteria andProjectScopeIsNull() {
                            addCriterion("project_scope is null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeIsNotNull() {
                            addCriterion("project_scope is not null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeEqualTo(String value) {
                            addCriterion("project_scope =", value, "projectScope");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeNotEqualTo(String value) {
                            addCriterion("project_scope <>", value, "projectScope");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeGreaterThan(String value) {
                            addCriterion("project_scope >", value, "projectScope");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeGreaterThanOrEqualTo(String value) {
                            addCriterion("project_scope >=", value, "projectScope");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeLessThan(String value) {
                            addCriterion("project_scope <", value, "projectScope");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeLessThanOrEqualTo(String value) {
                            addCriterion("project_scope <=", value, "projectScope");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeLike(String value) {
                            addCriterion("project_scope like", value, "projectScope");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeNotLike(String value) {
                            addCriterion("project_scope not like", value, "projectScope");
                            return (Criteria) this;
                            }

                            public Criteria andProjectScopeIn(List<String> values) {
                                addCriterion("project_scope in", values, "projectScope");
                                return (Criteria) this;
                                }

                                public Criteria andProjectScopeNotIn(List<String> values) {
                                    addCriterion("project_scope not in", values, "projectScope");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectScopeBetween(String value1, String value2) {
                                    addCriterion("project_scope between", value1, value2, "projectScope");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectScopeNotBetween(String value1, String value2) {
                                    addCriterion("project_scope not between", value1, value2, "projectScope");
                                    return (Criteria) this;
                                    }
                            public Criteria andProjectLevelIsNull() {
                            addCriterion("project_level is null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelIsNotNull() {
                            addCriterion("project_level is not null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelEqualTo(String value) {
                            addCriterion("project_level =", value, "projectLevel");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelNotEqualTo(String value) {
                            addCriterion("project_level <>", value, "projectLevel");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelGreaterThan(String value) {
                            addCriterion("project_level >", value, "projectLevel");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelGreaterThanOrEqualTo(String value) {
                            addCriterion("project_level >=", value, "projectLevel");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelLessThan(String value) {
                            addCriterion("project_level <", value, "projectLevel");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelLessThanOrEqualTo(String value) {
                            addCriterion("project_level <=", value, "projectLevel");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelLike(String value) {
                            addCriterion("project_level like", value, "projectLevel");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelNotLike(String value) {
                            addCriterion("project_level not like", value, "projectLevel");
                            return (Criteria) this;
                            }

                            public Criteria andProjectLevelIn(List<String> values) {
                                addCriterion("project_level in", values, "projectLevel");
                                return (Criteria) this;
                                }

                                public Criteria andProjectLevelNotIn(List<String> values) {
                                    addCriterion("project_level not in", values, "projectLevel");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectLevelBetween(String value1, String value2) {
                                    addCriterion("project_level between", value1, value2, "projectLevel");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectLevelNotBetween(String value1, String value2) {
                                    addCriterion("project_level not between", value1, value2, "projectLevel");
                                    return (Criteria) this;
                                    }
                            public Criteria andProjectPropertyIsNull() {
                            addCriterion("project_property is null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyIsNotNull() {
                            addCriterion("project_property is not null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyEqualTo(String value) {
                            addCriterion("project_property =", value, "projectProperty");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyNotEqualTo(String value) {
                            addCriterion("project_property <>", value, "projectProperty");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyGreaterThan(String value) {
                            addCriterion("project_property >", value, "projectProperty");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyGreaterThanOrEqualTo(String value) {
                            addCriterion("project_property >=", value, "projectProperty");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyLessThan(String value) {
                            addCriterion("project_property <", value, "projectProperty");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyLessThanOrEqualTo(String value) {
                            addCriterion("project_property <=", value, "projectProperty");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyLike(String value) {
                            addCriterion("project_property like", value, "projectProperty");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyNotLike(String value) {
                            addCriterion("project_property not like", value, "projectProperty");
                            return (Criteria) this;
                            }

                            public Criteria andProjectPropertyIn(List<String> values) {
                                addCriterion("project_property in", values, "projectProperty");
                                return (Criteria) this;
                                }

                                public Criteria andProjectPropertyNotIn(List<String> values) {
                                    addCriterion("project_property not in", values, "projectProperty");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectPropertyBetween(String value1, String value2) {
                                    addCriterion("project_property between", value1, value2, "projectProperty");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectPropertyNotBetween(String value1, String value2) {
                                    addCriterion("project_property not between", value1, value2, "projectProperty");
                                    return (Criteria) this;
                                    }
                            public Criteria andProjectAbcIsNull() {
                            addCriterion("project_abc is null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcIsNotNull() {
                            addCriterion("project_abc is not null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcEqualTo(String value) {
                            addCriterion("project_abc =", value, "projectAbc");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcNotEqualTo(String value) {
                            addCriterion("project_abc <>", value, "projectAbc");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcGreaterThan(String value) {
                            addCriterion("project_abc >", value, "projectAbc");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcGreaterThanOrEqualTo(String value) {
                            addCriterion("project_abc >=", value, "projectAbc");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcLessThan(String value) {
                            addCriterion("project_abc <", value, "projectAbc");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcLessThanOrEqualTo(String value) {
                            addCriterion("project_abc <=", value, "projectAbc");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcLike(String value) {
                            addCriterion("project_abc like", value, "projectAbc");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcNotLike(String value) {
                            addCriterion("project_abc not like", value, "projectAbc");
                            return (Criteria) this;
                            }

                            public Criteria andProjectAbcIn(List<String> values) {
                                addCriterion("project_abc in", values, "projectAbc");
                                return (Criteria) this;
                                }

                                public Criteria andProjectAbcNotIn(List<String> values) {
                                    addCriterion("project_abc not in", values, "projectAbc");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectAbcBetween(String value1, String value2) {
                                    addCriterion("project_abc between", value1, value2, "projectAbc");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectAbcNotBetween(String value1, String value2) {
                                    addCriterion("project_abc not between", value1, value2, "projectAbc");
                                    return (Criteria) this;
                                    }
                            public Criteria andProjectSourceIsNull() {
                            addCriterion("project_source is null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceIsNotNull() {
                            addCriterion("project_source is not null");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceEqualTo(String value) {
                            addCriterion("project_source =", value, "projectSource");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceNotEqualTo(String value) {
                            addCriterion("project_source <>", value, "projectSource");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceGreaterThan(String value) {
                            addCriterion("project_source >", value, "projectSource");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceGreaterThanOrEqualTo(String value) {
                            addCriterion("project_source >=", value, "projectSource");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceLessThan(String value) {
                            addCriterion("project_source <", value, "projectSource");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceLessThanOrEqualTo(String value) {
                            addCriterion("project_source <=", value, "projectSource");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceLike(String value) {
                            addCriterion("project_source like", value, "projectSource");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceNotLike(String value) {
                            addCriterion("project_source not like", value, "projectSource");
                            return (Criteria) this;
                            }

                            public Criteria andProjectSourceIn(List<String> values) {
                                addCriterion("project_source in", values, "projectSource");
                                return (Criteria) this;
                                }

                                public Criteria andProjectSourceNotIn(List<String> values) {
                                    addCriterion("project_source not in", values, "projectSource");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectSourceBetween(String value1, String value2) {
                                    addCriterion("project_source between", value1, value2, "projectSource");
                                    return (Criteria) this;
                                    }

                                    public Criteria andProjectSourceNotBetween(String value1, String value2) {
                                    addCriterion("project_source not between", value1, value2, "projectSource");
                                    return (Criteria) this;
                                    }
                            public Criteria andYjsjksIsNull() {
                            addCriterion("yjsjks is null");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksIsNotNull() {
                            addCriterion("yjsjks is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksEqualTo(String value) {
                            addCriterion("yjsjks =", value, "yjsjks");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksNotEqualTo(String value) {
                            addCriterion("yjsjks <>", value, "yjsjks");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksGreaterThan(String value) {
                            addCriterion("yjsjks >", value, "yjsjks");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksGreaterThanOrEqualTo(String value) {
                            addCriterion("yjsjks >=", value, "yjsjks");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksLessThan(String value) {
                            addCriterion("yjsjks <", value, "yjsjks");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksLessThanOrEqualTo(String value) {
                            addCriterion("yjsjks <=", value, "yjsjks");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksLike(String value) {
                            addCriterion("yjsjks like", value, "yjsjks");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksNotLike(String value) {
                            addCriterion("yjsjks not like", value, "yjsjks");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjksIn(List<String> values) {
                                addCriterion("yjsjks in", values, "yjsjks");
                                return (Criteria) this;
                                }

                                public Criteria andYjsjksNotIn(List<String> values) {
                                    addCriterion("yjsjks not in", values, "yjsjks");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjsjksBetween(String value1, String value2) {
                                    addCriterion("yjsjks between", value1, value2, "yjsjks");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjsjksNotBetween(String value1, String value2) {
                                    addCriterion("yjsjks not between", value1, value2, "yjsjks");
                                    return (Criteria) this;
                                    }
                            public Criteria andYjsjjsIsNull() {
                            addCriterion("yjsjjs is null");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsIsNotNull() {
                            addCriterion("yjsjjs is not null");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsEqualTo(String value) {
                            addCriterion("yjsjjs =", value, "yjsjjs");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsNotEqualTo(String value) {
                            addCriterion("yjsjjs <>", value, "yjsjjs");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsGreaterThan(String value) {
                            addCriterion("yjsjjs >", value, "yjsjjs");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsGreaterThanOrEqualTo(String value) {
                            addCriterion("yjsjjs >=", value, "yjsjjs");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsLessThan(String value) {
                            addCriterion("yjsjjs <", value, "yjsjjs");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsLessThanOrEqualTo(String value) {
                            addCriterion("yjsjjs <=", value, "yjsjjs");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsLike(String value) {
                            addCriterion("yjsjjs like", value, "yjsjjs");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsNotLike(String value) {
                            addCriterion("yjsjjs not like", value, "yjsjjs");
                            return (Criteria) this;
                            }

                            public Criteria andYjsjjsIn(List<String> values) {
                                addCriterion("yjsjjs in", values, "yjsjjs");
                                return (Criteria) this;
                                }

                                public Criteria andYjsjjsNotIn(List<String> values) {
                                    addCriterion("yjsjjs not in", values, "yjsjjs");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjsjjsBetween(String value1, String value2) {
                                    addCriterion("yjsjjs between", value1, value2, "yjsjjs");
                                    return (Criteria) this;
                                    }

                                    public Criteria andYjsjjsNotBetween(String value1, String value2) {
                                    addCriterion("yjsjjs not between", value1, value2, "yjsjjs");
                                    return (Criteria) this;
                                    }
                            public Criteria andXmlbbmIsNull() {
                            addCriterion("xmlbbm is null");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmIsNotNull() {
                            addCriterion("xmlbbm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmEqualTo(String value) {
                            addCriterion("xmlbbm =", value, "xmlbbm");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmNotEqualTo(String value) {
                            addCriterion("xmlbbm <>", value, "xmlbbm");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmGreaterThan(String value) {
                            addCriterion("xmlbbm >", value, "xmlbbm");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmGreaterThanOrEqualTo(String value) {
                            addCriterion("xmlbbm >=", value, "xmlbbm");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmLessThan(String value) {
                            addCriterion("xmlbbm <", value, "xmlbbm");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmLessThanOrEqualTo(String value) {
                            addCriterion("xmlbbm <=", value, "xmlbbm");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmLike(String value) {
                            addCriterion("xmlbbm like", value, "xmlbbm");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmNotLike(String value) {
                            addCriterion("xmlbbm not like", value, "xmlbbm");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbbmIn(List<String> values) {
                                addCriterion("xmlbbm in", values, "xmlbbm");
                                return (Criteria) this;
                                }

                                public Criteria andXmlbbmNotIn(List<String> values) {
                                    addCriterion("xmlbbm not in", values, "xmlbbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andXmlbbmBetween(String value1, String value2) {
                                    addCriterion("xmlbbm between", value1, value2, "xmlbbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andXmlbbmNotBetween(String value1, String value2) {
                                    addCriterion("xmlbbm not between", value1, value2, "xmlbbm");
                                    return (Criteria) this;
                                    }
                            public Criteria andXmlbmcIsNull() {
                            addCriterion("xmlbmc is null");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcIsNotNull() {
                            addCriterion("xmlbmc is not null");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcEqualTo(String value) {
                            addCriterion("xmlbmc =", value, "xmlbmc");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcNotEqualTo(String value) {
                            addCriterion("xmlbmc <>", value, "xmlbmc");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcGreaterThan(String value) {
                            addCriterion("xmlbmc >", value, "xmlbmc");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcGreaterThanOrEqualTo(String value) {
                            addCriterion("xmlbmc >=", value, "xmlbmc");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcLessThan(String value) {
                            addCriterion("xmlbmc <", value, "xmlbmc");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcLessThanOrEqualTo(String value) {
                            addCriterion("xmlbmc <=", value, "xmlbmc");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcLike(String value) {
                            addCriterion("xmlbmc like", value, "xmlbmc");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcNotLike(String value) {
                            addCriterion("xmlbmc not like", value, "xmlbmc");
                            return (Criteria) this;
                            }

                            public Criteria andXmlbmcIn(List<String> values) {
                                addCriterion("xmlbmc in", values, "xmlbmc");
                                return (Criteria) this;
                                }

                                public Criteria andXmlbmcNotIn(List<String> values) {
                                    addCriterion("xmlbmc not in", values, "xmlbmc");
                                    return (Criteria) this;
                                    }

                                    public Criteria andXmlbmcBetween(String value1, String value2) {
                                    addCriterion("xmlbmc between", value1, value2, "xmlbmc");
                                    return (Criteria) this;
                                    }

                                    public Criteria andXmlbmcNotBetween(String value1, String value2) {
                                    addCriterion("xmlbmc not between", value1, value2, "xmlbmc");
                                    return (Criteria) this;
                                    }
                            public Criteria andGsbmmcIsNull() {
                            addCriterion("gsbmmc is null");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcIsNotNull() {
                            addCriterion("gsbmmc is not null");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcEqualTo(String value) {
                            addCriterion("gsbmmc =", value, "gsbmmc");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcNotEqualTo(String value) {
                            addCriterion("gsbmmc <>", value, "gsbmmc");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcGreaterThan(String value) {
                            addCriterion("gsbmmc >", value, "gsbmmc");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcGreaterThanOrEqualTo(String value) {
                            addCriterion("gsbmmc >=", value, "gsbmmc");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcLessThan(String value) {
                            addCriterion("gsbmmc <", value, "gsbmmc");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcLessThanOrEqualTo(String value) {
                            addCriterion("gsbmmc <=", value, "gsbmmc");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcLike(String value) {
                            addCriterion("gsbmmc like", value, "gsbmmc");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcNotLike(String value) {
                            addCriterion("gsbmmc not like", value, "gsbmmc");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmmcIn(List<String> values) {
                                addCriterion("gsbmmc in", values, "gsbmmc");
                                return (Criteria) this;
                                }

                                public Criteria andGsbmmcNotIn(List<String> values) {
                                    addCriterion("gsbmmc not in", values, "gsbmmc");
                                    return (Criteria) this;
                                    }

                                    public Criteria andGsbmmcBetween(String value1, String value2) {
                                    addCriterion("gsbmmc between", value1, value2, "gsbmmc");
                                    return (Criteria) this;
                                    }

                                    public Criteria andGsbmmcNotBetween(String value1, String value2) {
                                    addCriterion("gsbmmc not between", value1, value2, "gsbmmc");
                                    return (Criteria) this;
                                    }
                            public Criteria andGsbmbmIsNull() {
                            addCriterion("gsbmbm is null");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmIsNotNull() {
                            addCriterion("gsbmbm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmEqualTo(String value) {
                            addCriterion("gsbmbm =", value, "gsbmbm");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmNotEqualTo(String value) {
                            addCriterion("gsbmbm <>", value, "gsbmbm");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmGreaterThan(String value) {
                            addCriterion("gsbmbm >", value, "gsbmbm");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmGreaterThanOrEqualTo(String value) {
                            addCriterion("gsbmbm >=", value, "gsbmbm");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmLessThan(String value) {
                            addCriterion("gsbmbm <", value, "gsbmbm");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmLessThanOrEqualTo(String value) {
                            addCriterion("gsbmbm <=", value, "gsbmbm");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmLike(String value) {
                            addCriterion("gsbmbm like", value, "gsbmbm");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmNotLike(String value) {
                            addCriterion("gsbmbm not like", value, "gsbmbm");
                            return (Criteria) this;
                            }

                            public Criteria andGsbmbmIn(List<String> values) {
                                addCriterion("gsbmbm in", values, "gsbmbm");
                                return (Criteria) this;
                                }

                                public Criteria andGsbmbmNotIn(List<String> values) {
                                    addCriterion("gsbmbm not in", values, "gsbmbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andGsbmbmBetween(String value1, String value2) {
                                    addCriterion("gsbmbm between", value1, value2, "gsbmbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andGsbmbmNotBetween(String value1, String value2) {
                                    addCriterion("gsbmbm not between", value1, value2, "gsbmbm");
                                    return (Criteria) this;
                                    }
                            public Criteria andZycmcIsNull() {
                            addCriterion("zycmc is null");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcIsNotNull() {
                            addCriterion("zycmc is not null");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcEqualTo(String value) {
                            addCriterion("zycmc =", value, "zycmc");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcNotEqualTo(String value) {
                            addCriterion("zycmc <>", value, "zycmc");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcGreaterThan(String value) {
                            addCriterion("zycmc >", value, "zycmc");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcGreaterThanOrEqualTo(String value) {
                            addCriterion("zycmc >=", value, "zycmc");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcLessThan(String value) {
                            addCriterion("zycmc <", value, "zycmc");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcLessThanOrEqualTo(String value) {
                            addCriterion("zycmc <=", value, "zycmc");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcLike(String value) {
                            addCriterion("zycmc like", value, "zycmc");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcNotLike(String value) {
                            addCriterion("zycmc not like", value, "zycmc");
                            return (Criteria) this;
                            }

                            public Criteria andZycmcIn(List<String> values) {
                                addCriterion("zycmc in", values, "zycmc");
                                return (Criteria) this;
                                }

                                public Criteria andZycmcNotIn(List<String> values) {
                                    addCriterion("zycmc not in", values, "zycmc");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZycmcBetween(String value1, String value2) {
                                    addCriterion("zycmc between", value1, value2, "zycmc");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZycmcNotBetween(String value1, String value2) {
                                    addCriterion("zycmc not between", value1, value2, "zycmc");
                                    return (Criteria) this;
                                    }
                            public Criteria andZycbmIsNull() {
                            addCriterion("zycbm is null");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmIsNotNull() {
                            addCriterion("zycbm is not null");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmEqualTo(String value) {
                            addCriterion("zycbm =", value, "zycbm");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmNotEqualTo(String value) {
                            addCriterion("zycbm <>", value, "zycbm");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmGreaterThan(String value) {
                            addCriterion("zycbm >", value, "zycbm");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmGreaterThanOrEqualTo(String value) {
                            addCriterion("zycbm >=", value, "zycbm");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmLessThan(String value) {
                            addCriterion("zycbm <", value, "zycbm");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmLessThanOrEqualTo(String value) {
                            addCriterion("zycbm <=", value, "zycbm");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmLike(String value) {
                            addCriterion("zycbm like", value, "zycbm");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmNotLike(String value) {
                            addCriterion("zycbm not like", value, "zycbm");
                            return (Criteria) this;
                            }

                            public Criteria andZycbmIn(List<String> values) {
                                addCriterion("zycbm in", values, "zycbm");
                                return (Criteria) this;
                                }

                                public Criteria andZycbmNotIn(List<String> values) {
                                    addCriterion("zycbm not in", values, "zycbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZycbmBetween(String value1, String value2) {
                                    addCriterion("zycbm between", value1, value2, "zycbm");
                                    return (Criteria) this;
                                    }

                                    public Criteria andZycbmNotBetween(String value1, String value2) {
                                    addCriterion("zycbm not between", value1, value2, "zycbm");
                                    return (Criteria) this;
                                    }
                            public Criteria andFzdwunitcwIsNull() {
                            addCriterion("fzdwunitcw is null");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwIsNotNull() {
                            addCriterion("fzdwunitcw is not null");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwEqualTo(String value) {
                            addCriterion("fzdwunitcw =", value, "fzdwunitcw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwNotEqualTo(String value) {
                            addCriterion("fzdwunitcw <>", value, "fzdwunitcw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwGreaterThan(String value) {
                            addCriterion("fzdwunitcw >", value, "fzdwunitcw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwGreaterThanOrEqualTo(String value) {
                            addCriterion("fzdwunitcw >=", value, "fzdwunitcw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwLessThan(String value) {
                            addCriterion("fzdwunitcw <", value, "fzdwunitcw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwLessThanOrEqualTo(String value) {
                            addCriterion("fzdwunitcw <=", value, "fzdwunitcw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwLike(String value) {
                            addCriterion("fzdwunitcw like", value, "fzdwunitcw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwNotLike(String value) {
                            addCriterion("fzdwunitcw not like", value, "fzdwunitcw");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitcwIn(List<String> values) {
                                addCriterion("fzdwunitcw in", values, "fzdwunitcw");
                                return (Criteria) this;
                                }

                                public Criteria andFzdwunitcwNotIn(List<String> values) {
                                    addCriterion("fzdwunitcw not in", values, "fzdwunitcw");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzdwunitcwBetween(String value1, String value2) {
                                    addCriterion("fzdwunitcw between", value1, value2, "fzdwunitcw");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzdwunitcwNotBetween(String value1, String value2) {
                                    addCriterion("fzdwunitcw not between", value1, value2, "fzdwunitcw");
                                    return (Criteria) this;
                                    }
                            public Criteria andFzdwunitIsNull() {
                            addCriterion("fzdwunit is null");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitIsNotNull() {
                            addCriterion("fzdwunit is not null");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitEqualTo(String value) {
                            addCriterion("fzdwunit =", value, "fzdwunit");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitNotEqualTo(String value) {
                            addCriterion("fzdwunit <>", value, "fzdwunit");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitGreaterThan(String value) {
                            addCriterion("fzdwunit >", value, "fzdwunit");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitGreaterThanOrEqualTo(String value) {
                            addCriterion("fzdwunit >=", value, "fzdwunit");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitLessThan(String value) {
                            addCriterion("fzdwunit <", value, "fzdwunit");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitLessThanOrEqualTo(String value) {
                            addCriterion("fzdwunit <=", value, "fzdwunit");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitLike(String value) {
                            addCriterion("fzdwunit like", value, "fzdwunit");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitNotLike(String value) {
                            addCriterion("fzdwunit not like", value, "fzdwunit");
                            return (Criteria) this;
                            }

                            public Criteria andFzdwunitIn(List<String> values) {
                                addCriterion("fzdwunit in", values, "fzdwunit");
                                return (Criteria) this;
                                }

                                public Criteria andFzdwunitNotIn(List<String> values) {
                                    addCriterion("fzdwunit not in", values, "fzdwunit");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzdwunitBetween(String value1, String value2) {
                                    addCriterion("fzdwunit between", value1, value2, "fzdwunit");
                                    return (Criteria) this;
                                    }

                                    public Criteria andFzdwunitNotBetween(String value1, String value2) {
                                    addCriterion("fzdwunit not between", value1, value2, "fzdwunit");
                                    return (Criteria) this;
                                    }
                            public Criteria andTypeFlagIsNull() {
                            addCriterion("type_flag is null");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagIsNotNull() {
                            addCriterion("type_flag is not null");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagEqualTo(String value) {
                            addCriterion("type_flag =", value, "typeFlag");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagNotEqualTo(String value) {
                            addCriterion("type_flag <>", value, "typeFlag");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagGreaterThan(String value) {
                            addCriterion("type_flag >", value, "typeFlag");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagGreaterThanOrEqualTo(String value) {
                            addCriterion("type_flag >=", value, "typeFlag");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagLessThan(String value) {
                            addCriterion("type_flag <", value, "typeFlag");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagLessThanOrEqualTo(String value) {
                            addCriterion("type_flag <=", value, "typeFlag");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagLike(String value) {
                            addCriterion("type_flag like", value, "typeFlag");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagNotLike(String value) {
                            addCriterion("type_flag not like", value, "typeFlag");
                            return (Criteria) this;
                            }

                            public Criteria andTypeFlagIn(List<String> values) {
                                addCriterion("type_flag in", values, "typeFlag");
                                return (Criteria) this;
                                }

                                public Criteria andTypeFlagNotIn(List<String> values) {
                                    addCriterion("type_flag not in", values, "typeFlag");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTypeFlagBetween(String value1, String value2) {
                                    addCriterion("type_flag between", value1, value2, "typeFlag");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTypeFlagNotBetween(String value1, String value2) {
                                    addCriterion("type_flag not between", value1, value2, "typeFlag");
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
                            public Criteria andDefine5IsNull() {
                            addCriterion("define5 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5IsNotNull() {
                            addCriterion("define5 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5EqualTo(String value) {
                            addCriterion("define5 =", value, "define5");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5NotEqualTo(String value) {
                            addCriterion("define5 <>", value, "define5");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5GreaterThan(String value) {
                            addCriterion("define5 >", value, "define5");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5GreaterThanOrEqualTo(String value) {
                            addCriterion("define5 >=", value, "define5");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5LessThan(String value) {
                            addCriterion("define5 <", value, "define5");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5LessThanOrEqualTo(String value) {
                            addCriterion("define5 <=", value, "define5");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5Like(String value) {
                            addCriterion("define5 like", value, "define5");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5NotLike(String value) {
                            addCriterion("define5 not like", value, "define5");
                            return (Criteria) this;
                            }

                            public Criteria andDefine5In(List<String> values) {
                                addCriterion("define5 in", values, "define5");
                                return (Criteria) this;
                                }

                                public Criteria andDefine5NotIn(List<String> values) {
                                    addCriterion("define5 not in", values, "define5");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine5Between(String value1, String value2) {
                                    addCriterion("define5 between", value1, value2, "define5");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine5NotBetween(String value1, String value2) {
                                    addCriterion("define5 not between", value1, value2, "define5");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine6IsNull() {
                            addCriterion("define6 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6IsNotNull() {
                            addCriterion("define6 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6EqualTo(String value) {
                            addCriterion("define6 =", value, "define6");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6NotEqualTo(String value) {
                            addCriterion("define6 <>", value, "define6");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6GreaterThan(String value) {
                            addCriterion("define6 >", value, "define6");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6GreaterThanOrEqualTo(String value) {
                            addCriterion("define6 >=", value, "define6");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6LessThan(String value) {
                            addCriterion("define6 <", value, "define6");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6LessThanOrEqualTo(String value) {
                            addCriterion("define6 <=", value, "define6");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6Like(String value) {
                            addCriterion("define6 like", value, "define6");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6NotLike(String value) {
                            addCriterion("define6 not like", value, "define6");
                            return (Criteria) this;
                            }

                            public Criteria andDefine6In(List<String> values) {
                                addCriterion("define6 in", values, "define6");
                                return (Criteria) this;
                                }

                                public Criteria andDefine6NotIn(List<String> values) {
                                    addCriterion("define6 not in", values, "define6");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine6Between(String value1, String value2) {
                                    addCriterion("define6 between", value1, value2, "define6");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine6NotBetween(String value1, String value2) {
                                    addCriterion("define6 not between", value1, value2, "define6");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine7IsNull() {
                            addCriterion("define7 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7IsNotNull() {
                            addCriterion("define7 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7EqualTo(String value) {
                            addCriterion("define7 =", value, "define7");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7NotEqualTo(String value) {
                            addCriterion("define7 <>", value, "define7");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7GreaterThan(String value) {
                            addCriterion("define7 >", value, "define7");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7GreaterThanOrEqualTo(String value) {
                            addCriterion("define7 >=", value, "define7");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7LessThan(String value) {
                            addCriterion("define7 <", value, "define7");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7LessThanOrEqualTo(String value) {
                            addCriterion("define7 <=", value, "define7");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7Like(String value) {
                            addCriterion("define7 like", value, "define7");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7NotLike(String value) {
                            addCriterion("define7 not like", value, "define7");
                            return (Criteria) this;
                            }

                            public Criteria andDefine7In(List<String> values) {
                                addCriterion("define7 in", values, "define7");
                                return (Criteria) this;
                                }

                                public Criteria andDefine7NotIn(List<String> values) {
                                    addCriterion("define7 not in", values, "define7");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine7Between(String value1, String value2) {
                                    addCriterion("define7 between", value1, value2, "define7");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine7NotBetween(String value1, String value2) {
                                    addCriterion("define7 not between", value1, value2, "define7");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine8IsNull() {
                            addCriterion("define8 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8IsNotNull() {
                            addCriterion("define8 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8EqualTo(String value) {
                            addCriterion("define8 =", value, "define8");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8NotEqualTo(String value) {
                            addCriterion("define8 <>", value, "define8");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8GreaterThan(String value) {
                            addCriterion("define8 >", value, "define8");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8GreaterThanOrEqualTo(String value) {
                            addCriterion("define8 >=", value, "define8");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8LessThan(String value) {
                            addCriterion("define8 <", value, "define8");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8LessThanOrEqualTo(String value) {
                            addCriterion("define8 <=", value, "define8");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8Like(String value) {
                            addCriterion("define8 like", value, "define8");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8NotLike(String value) {
                            addCriterion("define8 not like", value, "define8");
                            return (Criteria) this;
                            }

                            public Criteria andDefine8In(List<String> values) {
                                addCriterion("define8 in", values, "define8");
                                return (Criteria) this;
                                }

                                public Criteria andDefine8NotIn(List<String> values) {
                                    addCriterion("define8 not in", values, "define8");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine8Between(String value1, String value2) {
                                    addCriterion("define8 between", value1, value2, "define8");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine8NotBetween(String value1, String value2) {
                                    addCriterion("define8 not between", value1, value2, "define8");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine9IsNull() {
                            addCriterion("define9 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9IsNotNull() {
                            addCriterion("define9 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9EqualTo(String value) {
                            addCriterion("define9 =", value, "define9");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9NotEqualTo(String value) {
                            addCriterion("define9 <>", value, "define9");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9GreaterThan(String value) {
                            addCriterion("define9 >", value, "define9");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9GreaterThanOrEqualTo(String value) {
                            addCriterion("define9 >=", value, "define9");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9LessThan(String value) {
                            addCriterion("define9 <", value, "define9");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9LessThanOrEqualTo(String value) {
                            addCriterion("define9 <=", value, "define9");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9Like(String value) {
                            addCriterion("define9 like", value, "define9");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9NotLike(String value) {
                            addCriterion("define9 not like", value, "define9");
                            return (Criteria) this;
                            }

                            public Criteria andDefine9In(List<String> values) {
                                addCriterion("define9 in", values, "define9");
                                return (Criteria) this;
                                }

                                public Criteria andDefine9NotIn(List<String> values) {
                                    addCriterion("define9 not in", values, "define9");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine9Between(String value1, String value2) {
                                    addCriterion("define9 between", value1, value2, "define9");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine9NotBetween(String value1, String value2) {
                                    addCriterion("define9 not between", value1, value2, "define9");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine10IsNull() {
                            addCriterion("define10 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10IsNotNull() {
                            addCriterion("define10 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10EqualTo(String value) {
                            addCriterion("define10 =", value, "define10");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10NotEqualTo(String value) {
                            addCriterion("define10 <>", value, "define10");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10GreaterThan(String value) {
                            addCriterion("define10 >", value, "define10");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10GreaterThanOrEqualTo(String value) {
                            addCriterion("define10 >=", value, "define10");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10LessThan(String value) {
                            addCriterion("define10 <", value, "define10");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10LessThanOrEqualTo(String value) {
                            addCriterion("define10 <=", value, "define10");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10Like(String value) {
                            addCriterion("define10 like", value, "define10");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10NotLike(String value) {
                            addCriterion("define10 not like", value, "define10");
                            return (Criteria) this;
                            }

                            public Criteria andDefine10In(List<String> values) {
                                addCriterion("define10 in", values, "define10");
                                return (Criteria) this;
                                }

                                public Criteria andDefine10NotIn(List<String> values) {
                                    addCriterion("define10 not in", values, "define10");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine10Between(String value1, String value2) {
                                    addCriterion("define10 between", value1, value2, "define10");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine10NotBetween(String value1, String value2) {
                                    addCriterion("define10 not between", value1, value2, "define10");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine11IsNull() {
                            addCriterion("define11 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11IsNotNull() {
                            addCriterion("define11 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11EqualTo(String value) {
                            addCriterion("define11 =", value, "define11");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11NotEqualTo(String value) {
                            addCriterion("define11 <>", value, "define11");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11GreaterThan(String value) {
                            addCriterion("define11 >", value, "define11");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11GreaterThanOrEqualTo(String value) {
                            addCriterion("define11 >=", value, "define11");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11LessThan(String value) {
                            addCriterion("define11 <", value, "define11");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11LessThanOrEqualTo(String value) {
                            addCriterion("define11 <=", value, "define11");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11Like(String value) {
                            addCriterion("define11 like", value, "define11");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11NotLike(String value) {
                            addCriterion("define11 not like", value, "define11");
                            return (Criteria) this;
                            }

                            public Criteria andDefine11In(List<String> values) {
                                addCriterion("define11 in", values, "define11");
                                return (Criteria) this;
                                }

                                public Criteria andDefine11NotIn(List<String> values) {
                                    addCriterion("define11 not in", values, "define11");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine11Between(String value1, String value2) {
                                    addCriterion("define11 between", value1, value2, "define11");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine11NotBetween(String value1, String value2) {
                                    addCriterion("define11 not between", value1, value2, "define11");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine12IsNull() {
                            addCriterion("define12 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12IsNotNull() {
                            addCriterion("define12 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12EqualTo(String value) {
                            addCriterion("define12 =", value, "define12");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12NotEqualTo(String value) {
                            addCriterion("define12 <>", value, "define12");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12GreaterThan(String value) {
                            addCriterion("define12 >", value, "define12");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12GreaterThanOrEqualTo(String value) {
                            addCriterion("define12 >=", value, "define12");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12LessThan(String value) {
                            addCriterion("define12 <", value, "define12");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12LessThanOrEqualTo(String value) {
                            addCriterion("define12 <=", value, "define12");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12Like(String value) {
                            addCriterion("define12 like", value, "define12");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12NotLike(String value) {
                            addCriterion("define12 not like", value, "define12");
                            return (Criteria) this;
                            }

                            public Criteria andDefine12In(List<String> values) {
                                addCriterion("define12 in", values, "define12");
                                return (Criteria) this;
                                }

                                public Criteria andDefine12NotIn(List<String> values) {
                                    addCriterion("define12 not in", values, "define12");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine12Between(String value1, String value2) {
                                    addCriterion("define12 between", value1, value2, "define12");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine12NotBetween(String value1, String value2) {
                                    addCriterion("define12 not between", value1, value2, "define12");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine13IsNull() {
                            addCriterion("define13 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13IsNotNull() {
                            addCriterion("define13 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13EqualTo(String value) {
                            addCriterion("define13 =", value, "define13");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13NotEqualTo(String value) {
                            addCriterion("define13 <>", value, "define13");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13GreaterThan(String value) {
                            addCriterion("define13 >", value, "define13");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13GreaterThanOrEqualTo(String value) {
                            addCriterion("define13 >=", value, "define13");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13LessThan(String value) {
                            addCriterion("define13 <", value, "define13");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13LessThanOrEqualTo(String value) {
                            addCriterion("define13 <=", value, "define13");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13Like(String value) {
                            addCriterion("define13 like", value, "define13");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13NotLike(String value) {
                            addCriterion("define13 not like", value, "define13");
                            return (Criteria) this;
                            }

                            public Criteria andDefine13In(List<String> values) {
                                addCriterion("define13 in", values, "define13");
                                return (Criteria) this;
                                }

                                public Criteria andDefine13NotIn(List<String> values) {
                                    addCriterion("define13 not in", values, "define13");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine13Between(String value1, String value2) {
                                    addCriterion("define13 between", value1, value2, "define13");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine13NotBetween(String value1, String value2) {
                                    addCriterion("define13 not between", value1, value2, "define13");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine14IsNull() {
                            addCriterion("define14 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14IsNotNull() {
                            addCriterion("define14 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14EqualTo(String value) {
                            addCriterion("define14 =", value, "define14");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14NotEqualTo(String value) {
                            addCriterion("define14 <>", value, "define14");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14GreaterThan(String value) {
                            addCriterion("define14 >", value, "define14");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14GreaterThanOrEqualTo(String value) {
                            addCriterion("define14 >=", value, "define14");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14LessThan(String value) {
                            addCriterion("define14 <", value, "define14");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14LessThanOrEqualTo(String value) {
                            addCriterion("define14 <=", value, "define14");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14Like(String value) {
                            addCriterion("define14 like", value, "define14");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14NotLike(String value) {
                            addCriterion("define14 not like", value, "define14");
                            return (Criteria) this;
                            }

                            public Criteria andDefine14In(List<String> values) {
                                addCriterion("define14 in", values, "define14");
                                return (Criteria) this;
                                }

                                public Criteria andDefine14NotIn(List<String> values) {
                                    addCriterion("define14 not in", values, "define14");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine14Between(String value1, String value2) {
                                    addCriterion("define14 between", value1, value2, "define14");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine14NotBetween(String value1, String value2) {
                                    addCriterion("define14 not between", value1, value2, "define14");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine15IsNull() {
                            addCriterion("define15 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15IsNotNull() {
                            addCriterion("define15 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15EqualTo(String value) {
                            addCriterion("define15 =", value, "define15");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15NotEqualTo(String value) {
                            addCriterion("define15 <>", value, "define15");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15GreaterThan(String value) {
                            addCriterion("define15 >", value, "define15");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15GreaterThanOrEqualTo(String value) {
                            addCriterion("define15 >=", value, "define15");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15LessThan(String value) {
                            addCriterion("define15 <", value, "define15");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15LessThanOrEqualTo(String value) {
                            addCriterion("define15 <=", value, "define15");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15Like(String value) {
                            addCriterion("define15 like", value, "define15");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15NotLike(String value) {
                            addCriterion("define15 not like", value, "define15");
                            return (Criteria) this;
                            }

                            public Criteria andDefine15In(List<String> values) {
                                addCriterion("define15 in", values, "define15");
                                return (Criteria) this;
                                }

                                public Criteria andDefine15NotIn(List<String> values) {
                                    addCriterion("define15 not in", values, "define15");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine15Between(String value1, String value2) {
                                    addCriterion("define15 between", value1, value2, "define15");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine15NotBetween(String value1, String value2) {
                                    addCriterion("define15 not between", value1, value2, "define15");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine16IsNull() {
                            addCriterion("define16 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16IsNotNull() {
                            addCriterion("define16 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16EqualTo(String value) {
                            addCriterion("define16 =", value, "define16");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16NotEqualTo(String value) {
                            addCriterion("define16 <>", value, "define16");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16GreaterThan(String value) {
                            addCriterion("define16 >", value, "define16");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16GreaterThanOrEqualTo(String value) {
                            addCriterion("define16 >=", value, "define16");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16LessThan(String value) {
                            addCriterion("define16 <", value, "define16");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16LessThanOrEqualTo(String value) {
                            addCriterion("define16 <=", value, "define16");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16Like(String value) {
                            addCriterion("define16 like", value, "define16");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16NotLike(String value) {
                            addCriterion("define16 not like", value, "define16");
                            return (Criteria) this;
                            }

                            public Criteria andDefine16In(List<String> values) {
                                addCriterion("define16 in", values, "define16");
                                return (Criteria) this;
                                }

                                public Criteria andDefine16NotIn(List<String> values) {
                                    addCriterion("define16 not in", values, "define16");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine16Between(String value1, String value2) {
                                    addCriterion("define16 between", value1, value2, "define16");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine16NotBetween(String value1, String value2) {
                                    addCriterion("define16 not between", value1, value2, "define16");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine17IsNull() {
                            addCriterion("define17 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17IsNotNull() {
                            addCriterion("define17 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17EqualTo(String value) {
                            addCriterion("define17 =", value, "define17");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17NotEqualTo(String value) {
                            addCriterion("define17 <>", value, "define17");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17GreaterThan(String value) {
                            addCriterion("define17 >", value, "define17");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17GreaterThanOrEqualTo(String value) {
                            addCriterion("define17 >=", value, "define17");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17LessThan(String value) {
                            addCriterion("define17 <", value, "define17");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17LessThanOrEqualTo(String value) {
                            addCriterion("define17 <=", value, "define17");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17Like(String value) {
                            addCriterion("define17 like", value, "define17");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17NotLike(String value) {
                            addCriterion("define17 not like", value, "define17");
                            return (Criteria) this;
                            }

                            public Criteria andDefine17In(List<String> values) {
                                addCriterion("define17 in", values, "define17");
                                return (Criteria) this;
                                }

                                public Criteria andDefine17NotIn(List<String> values) {
                                    addCriterion("define17 not in", values, "define17");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine17Between(String value1, String value2) {
                                    addCriterion("define17 between", value1, value2, "define17");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine17NotBetween(String value1, String value2) {
                                    addCriterion("define17 not between", value1, value2, "define17");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine18IsNull() {
                            addCriterion("define18 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18IsNotNull() {
                            addCriterion("define18 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18EqualTo(String value) {
                            addCriterion("define18 =", value, "define18");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18NotEqualTo(String value) {
                            addCriterion("define18 <>", value, "define18");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18GreaterThan(String value) {
                            addCriterion("define18 >", value, "define18");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18GreaterThanOrEqualTo(String value) {
                            addCriterion("define18 >=", value, "define18");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18LessThan(String value) {
                            addCriterion("define18 <", value, "define18");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18LessThanOrEqualTo(String value) {
                            addCriterion("define18 <=", value, "define18");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18Like(String value) {
                            addCriterion("define18 like", value, "define18");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18NotLike(String value) {
                            addCriterion("define18 not like", value, "define18");
                            return (Criteria) this;
                            }

                            public Criteria andDefine18In(List<String> values) {
                                addCriterion("define18 in", values, "define18");
                                return (Criteria) this;
                                }

                                public Criteria andDefine18NotIn(List<String> values) {
                                    addCriterion("define18 not in", values, "define18");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine18Between(String value1, String value2) {
                                    addCriterion("define18 between", value1, value2, "define18");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine18NotBetween(String value1, String value2) {
                                    addCriterion("define18 not between", value1, value2, "define18");
                                    return (Criteria) this;
                                    }
                            public Criteria andDefine19IsNull() {
                            addCriterion("define19 is null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19IsNotNull() {
                            addCriterion("define19 is not null");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19EqualTo(String value) {
                            addCriterion("define19 =", value, "define19");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19NotEqualTo(String value) {
                            addCriterion("define19 <>", value, "define19");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19GreaterThan(String value) {
                            addCriterion("define19 >", value, "define19");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19GreaterThanOrEqualTo(String value) {
                            addCriterion("define19 >=", value, "define19");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19LessThan(String value) {
                            addCriterion("define19 <", value, "define19");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19LessThanOrEqualTo(String value) {
                            addCriterion("define19 <=", value, "define19");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19Like(String value) {
                            addCriterion("define19 like", value, "define19");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19NotLike(String value) {
                            addCriterion("define19 not like", value, "define19");
                            return (Criteria) this;
                            }

                            public Criteria andDefine19In(List<String> values) {
                                addCriterion("define19 in", values, "define19");
                                return (Criteria) this;
                                }

                                public Criteria andDefine19NotIn(List<String> values) {
                                    addCriterion("define19 not in", values, "define19");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine19Between(String value1, String value2) {
                                    addCriterion("define19 between", value1, value2, "define19");
                                    return (Criteria) this;
                                    }

                                    public Criteria andDefine19NotBetween(String value1, String value2) {
                                    addCriterion("define19 not between", value1, value2, "define19");
                                    return (Criteria) this;
                                    }
                            public Criteria andTypeCodeIsNull() {
                            addCriterion("type_code is null");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeIsNotNull() {
                            addCriterion("type_code is not null");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeEqualTo(String value) {
                            addCriterion("type_code =", value, "typeCode");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeNotEqualTo(String value) {
                            addCriterion("type_code <>", value, "typeCode");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeGreaterThan(String value) {
                            addCriterion("type_code >", value, "typeCode");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
                            addCriterion("type_code >=", value, "typeCode");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeLessThan(String value) {
                            addCriterion("type_code <", value, "typeCode");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeLessThanOrEqualTo(String value) {
                            addCriterion("type_code <=", value, "typeCode");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeLike(String value) {
                            addCriterion("type_code like", value, "typeCode");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeNotLike(String value) {
                            addCriterion("type_code not like", value, "typeCode");
                            return (Criteria) this;
                            }

                            public Criteria andTypeCodeIn(List<String> values) {
                                addCriterion("type_code in", values, "typeCode");
                                return (Criteria) this;
                                }

                                public Criteria andTypeCodeNotIn(List<String> values) {
                                    addCriterion("type_code not in", values, "typeCode");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTypeCodeBetween(String value1, String value2) {
                                    addCriterion("type_code between", value1, value2, "typeCode");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTypeCodeNotBetween(String value1, String value2) {
                                    addCriterion("type_code not between", value1, value2, "typeCode");
                                    return (Criteria) this;
                                    }
                            public Criteria andTypeNameIsNull() {
                            addCriterion("type_name is null");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameIsNotNull() {
                            addCriterion("type_name is not null");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameEqualTo(String value) {
                            addCriterion("type_name =", value, "typeName");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameNotEqualTo(String value) {
                            addCriterion("type_name <>", value, "typeName");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameGreaterThan(String value) {
                            addCriterion("type_name >", value, "typeName");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
                            addCriterion("type_name >=", value, "typeName");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameLessThan(String value) {
                            addCriterion("type_name <", value, "typeName");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameLessThanOrEqualTo(String value) {
                            addCriterion("type_name <=", value, "typeName");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameLike(String value) {
                            addCriterion("type_name like", value, "typeName");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameNotLike(String value) {
                            addCriterion("type_name not like", value, "typeName");
                            return (Criteria) this;
                            }

                            public Criteria andTypeNameIn(List<String> values) {
                                addCriterion("type_name in", values, "typeName");
                                return (Criteria) this;
                                }

                                public Criteria andTypeNameNotIn(List<String> values) {
                                    addCriterion("type_name not in", values, "typeName");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTypeNameBetween(String value1, String value2) {
                                    addCriterion("type_name between", value1, value2, "typeName");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTypeNameNotBetween(String value1, String value2) {
                                    addCriterion("type_name not between", value1, value2, "typeName");
                                    return (Criteria) this;
                                    }
                            public Criteria andParentIdIsNull() {
                            addCriterion("parent_id is null");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdIsNotNull() {
                            addCriterion("parent_id is not null");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdEqualTo(String value) {
                            addCriterion("parent_id =", value, "parentId");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdNotEqualTo(String value) {
                            addCriterion("parent_id <>", value, "parentId");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdGreaterThan(String value) {
                            addCriterion("parent_id >", value, "parentId");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdGreaterThanOrEqualTo(String value) {
                            addCriterion("parent_id >=", value, "parentId");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdLessThan(String value) {
                            addCriterion("parent_id <", value, "parentId");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdLessThanOrEqualTo(String value) {
                            addCriterion("parent_id <=", value, "parentId");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdLike(String value) {
                            addCriterion("parent_id like", value, "parentId");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdNotLike(String value) {
                            addCriterion("parent_id not like", value, "parentId");
                            return (Criteria) this;
                            }

                            public Criteria andParentIdIn(List<String> values) {
                                addCriterion("parent_id in", values, "parentId");
                                return (Criteria) this;
                                }

                                public Criteria andParentIdNotIn(List<String> values) {
                                    addCriterion("parent_id not in", values, "parentId");
                                    return (Criteria) this;
                                    }

                                    public Criteria andParentIdBetween(String value1, String value2) {
                                    addCriterion("parent_id between", value1, value2, "parentId");
                                    return (Criteria) this;
                                    }

                                    public Criteria andParentIdNotBetween(String value1, String value2) {
                                    addCriterion("parent_id not between", value1, value2, "parentId");
                                    return (Criteria) this;
                                    }
                            public Criteria andParentCodeIsNull() {
                            addCriterion("parent_code is null");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeIsNotNull() {
                            addCriterion("parent_code is not null");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeEqualTo(String value) {
                            addCriterion("parent_code =", value, "parentCode");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeNotEqualTo(String value) {
                            addCriterion("parent_code <>", value, "parentCode");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeGreaterThan(String value) {
                            addCriterion("parent_code >", value, "parentCode");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
                            addCriterion("parent_code >=", value, "parentCode");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeLessThan(String value) {
                            addCriterion("parent_code <", value, "parentCode");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeLessThanOrEqualTo(String value) {
                            addCriterion("parent_code <=", value, "parentCode");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeLike(String value) {
                            addCriterion("parent_code like", value, "parentCode");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeNotLike(String value) {
                            addCriterion("parent_code not like", value, "parentCode");
                            return (Criteria) this;
                            }

                            public Criteria andParentCodeIn(List<String> values) {
                                addCriterion("parent_code in", values, "parentCode");
                                return (Criteria) this;
                                }

                                public Criteria andParentCodeNotIn(List<String> values) {
                                    addCriterion("parent_code not in", values, "parentCode");
                                    return (Criteria) this;
                                    }

                                    public Criteria andParentCodeBetween(String value1, String value2) {
                                    addCriterion("parent_code between", value1, value2, "parentCode");
                                    return (Criteria) this;
                                    }

                                    public Criteria andParentCodeNotBetween(String value1, String value2) {
                                    addCriterion("parent_code not between", value1, value2, "parentCode");
                                    return (Criteria) this;
                                    }
                            public Criteria andIsParentIsNull() {
                            addCriterion("is_parent is null");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentIsNotNull() {
                            addCriterion("is_parent is not null");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentEqualTo(String value) {
                            addCriterion("is_parent =", value, "isParent");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentNotEqualTo(String value) {
                            addCriterion("is_parent <>", value, "isParent");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentGreaterThan(String value) {
                            addCriterion("is_parent >", value, "isParent");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentGreaterThanOrEqualTo(String value) {
                            addCriterion("is_parent >=", value, "isParent");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentLessThan(String value) {
                            addCriterion("is_parent <", value, "isParent");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentLessThanOrEqualTo(String value) {
                            addCriterion("is_parent <=", value, "isParent");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentLike(String value) {
                            addCriterion("is_parent like", value, "isParent");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentNotLike(String value) {
                            addCriterion("is_parent not like", value, "isParent");
                            return (Criteria) this;
                            }

                            public Criteria andIsParentIn(List<String> values) {
                                addCriterion("is_parent in", values, "isParent");
                                return (Criteria) this;
                                }

                                public Criteria andIsParentNotIn(List<String> values) {
                                    addCriterion("is_parent not in", values, "isParent");
                                    return (Criteria) this;
                                    }

                                    public Criteria andIsParentBetween(String value1, String value2) {
                                    addCriterion("is_parent between", value1, value2, "isParent");
                                    return (Criteria) this;
                                    }

                                    public Criteria andIsParentNotBetween(String value1, String value2) {
                                    addCriterion("is_parent not between", value1, value2, "isParent");
                                    return (Criteria) this;
                                    }
                            public Criteria andTypeIndexIsNull() {
                            addCriterion("type_index is null");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexIsNotNull() {
                            addCriterion("type_index is not null");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexEqualTo(String value) {
                            addCriterion("type_index =", value, "typeIndex");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexNotEqualTo(String value) {
                            addCriterion("type_index <>", value, "typeIndex");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexGreaterThan(String value) {
                            addCriterion("type_index >", value, "typeIndex");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexGreaterThanOrEqualTo(String value) {
                            addCriterion("type_index >=", value, "typeIndex");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexLessThan(String value) {
                            addCriterion("type_index <", value, "typeIndex");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexLessThanOrEqualTo(String value) {
                            addCriterion("type_index <=", value, "typeIndex");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexLike(String value) {
                            addCriterion("type_index like", value, "typeIndex");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexNotLike(String value) {
                            addCriterion("type_index not like", value, "typeIndex");
                            return (Criteria) this;
                            }

                            public Criteria andTypeIndexIn(List<String> values) {
                                addCriterion("type_index in", values, "typeIndex");
                                return (Criteria) this;
                                }

                                public Criteria andTypeIndexNotIn(List<String> values) {
                                    addCriterion("type_index not in", values, "typeIndex");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTypeIndexBetween(String value1, String value2) {
                                    addCriterion("type_index between", value1, value2, "typeIndex");
                                    return (Criteria) this;
                                    }

                                    public Criteria andTypeIndexNotBetween(String value1, String value2) {
                                    addCriterion("type_index not between", value1, value2, "typeIndex");
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