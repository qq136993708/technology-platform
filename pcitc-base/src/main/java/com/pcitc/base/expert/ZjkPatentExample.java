package com.pcitc.base.expert;

import java.util.ArrayList;
import java.util.List;

public class ZjkPatentExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ZjkPatentExample() {
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

        public Criteria andExpertIdIsNull() {
            addCriterion("expert_id is null");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNotNull() {
            addCriterion("expert_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpertIdEqualTo(String value) {
            addCriterion("expert_id =", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotEqualTo(String value) {
            addCriterion("expert_id <>", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThan(String value) {
            addCriterion("expert_id >", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThanOrEqualTo(String value) {
            addCriterion("expert_id >=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThan(String value) {
            addCriterion("expert_id <", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThanOrEqualTo(String value) {
            addCriterion("expert_id <=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLike(String value) {
            addCriterion("expert_id like", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotLike(String value) {
            addCriterion("expert_id not like", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdIn(List<String> values) {
            addCriterion("expert_id in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotIn(List<String> values) {
            addCriterion("expert_id not in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdBetween(String value1, String value2) {
            addCriterion("expert_id between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotBetween(String value1, String value2) {
            addCriterion("expert_id not between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andPatentNameIsNull() {
            addCriterion("patent_name is null");
            return (Criteria) this;
        }

        public Criteria andPatentNameIsNotNull() {
            addCriterion("patent_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatentNameEqualTo(String value) {
            addCriterion("patent_name =", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameNotEqualTo(String value) {
            addCriterion("patent_name <>", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameGreaterThan(String value) {
            addCriterion("patent_name >", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameGreaterThanOrEqualTo(String value) {
            addCriterion("patent_name >=", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameLessThan(String value) {
            addCriterion("patent_name <", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameLessThanOrEqualTo(String value) {
            addCriterion("patent_name <=", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameLike(String value) {
            addCriterion("patent_name like", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameNotLike(String value) {
            addCriterion("patent_name not like", value, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameIn(List<String> values) {
            addCriterion("patent_name in", values, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameNotIn(List<String> values) {
            addCriterion("patent_name not in", values, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameBetween(String value1, String value2) {
            addCriterion("patent_name between", value1, value2, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentNameNotBetween(String value1, String value2) {
            addCriterion("patent_name not between", value1, value2, "patentName");
            return (Criteria) this;
        }

        public Criteria andPatentCodeIsNull() {
            addCriterion("patent_code is null");
            return (Criteria) this;
        }

        public Criteria andPatentCodeIsNotNull() {
            addCriterion("patent_code is not null");
            return (Criteria) this;
        }

        public Criteria andPatentCodeEqualTo(String value) {
            addCriterion("patent_code =", value, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeNotEqualTo(String value) {
            addCriterion("patent_code <>", value, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeGreaterThan(String value) {
            addCriterion("patent_code >", value, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("patent_code >=", value, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeLessThan(String value) {
            addCriterion("patent_code <", value, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeLessThanOrEqualTo(String value) {
            addCriterion("patent_code <=", value, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeLike(String value) {
            addCriterion("patent_code like", value, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeNotLike(String value) {
            addCriterion("patent_code not like", value, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeIn(List<String> values) {
            addCriterion("patent_code in", values, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeNotIn(List<String> values) {
            addCriterion("patent_code not in", values, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeBetween(String value1, String value2) {
            addCriterion("patent_code between", value1, value2, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentCodeNotBetween(String value1, String value2) {
            addCriterion("patent_code not between", value1, value2, "patentCode");
            return (Criteria) this;
        }

        public Criteria andPatentDescIsNull() {
            addCriterion("patent_desc is null");
            return (Criteria) this;
        }

        public Criteria andPatentDescIsNotNull() {
            addCriterion("patent_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPatentDescEqualTo(String value) {
            addCriterion("patent_desc =", value, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescNotEqualTo(String value) {
            addCriterion("patent_desc <>", value, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescGreaterThan(String value) {
            addCriterion("patent_desc >", value, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescGreaterThanOrEqualTo(String value) {
            addCriterion("patent_desc >=", value, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescLessThan(String value) {
            addCriterion("patent_desc <", value, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescLessThanOrEqualTo(String value) {
            addCriterion("patent_desc <=", value, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescLike(String value) {
            addCriterion("patent_desc like", value, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescNotLike(String value) {
            addCriterion("patent_desc not like", value, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescIn(List<String> values) {
            addCriterion("patent_desc in", values, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescNotIn(List<String> values) {
            addCriterion("patent_desc not in", values, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescBetween(String value1, String value2) {
            addCriterion("patent_desc between", value1, value2, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentDescNotBetween(String value1, String value2) {
            addCriterion("patent_desc not between", value1, value2, "patentDesc");
            return (Criteria) this;
        }

        public Criteria andPatentKeysIsNull() {
            addCriterion("patent_keys is null");
            return (Criteria) this;
        }

        public Criteria andPatentKeysIsNotNull() {
            addCriterion("patent_keys is not null");
            return (Criteria) this;
        }

        public Criteria andPatentKeysEqualTo(String value) {
            addCriterion("patent_keys =", value, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysNotEqualTo(String value) {
            addCriterion("patent_keys <>", value, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysGreaterThan(String value) {
            addCriterion("patent_keys >", value, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysGreaterThanOrEqualTo(String value) {
            addCriterion("patent_keys >=", value, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysLessThan(String value) {
            addCriterion("patent_keys <", value, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysLessThanOrEqualTo(String value) {
            addCriterion("patent_keys <=", value, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysLike(String value) {
            addCriterion("patent_keys like", value, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysNotLike(String value) {
            addCriterion("patent_keys not like", value, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysIn(List<String> values) {
            addCriterion("patent_keys in", values, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysNotIn(List<String> values) {
            addCriterion("patent_keys not in", values, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysBetween(String value1, String value2) {
            addCriterion("patent_keys between", value1, value2, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentKeysNotBetween(String value1, String value2) {
            addCriterion("patent_keys not between", value1, value2, "patentKeys");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameIsNull() {
            addCriterion("patente_people_name is null");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameIsNotNull() {
            addCriterion("patente_people_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameEqualTo(String value) {
            addCriterion("patente_people_name =", value, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameNotEqualTo(String value) {
            addCriterion("patente_people_name <>", value, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameGreaterThan(String value) {
            addCriterion("patente_people_name >", value, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameGreaterThanOrEqualTo(String value) {
            addCriterion("patente_people_name >=", value, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameLessThan(String value) {
            addCriterion("patente_people_name <", value, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameLessThanOrEqualTo(String value) {
            addCriterion("patente_people_name <=", value, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameLike(String value) {
            addCriterion("patente_people_name like", value, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameNotLike(String value) {
            addCriterion("patente_people_name not like", value, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameIn(List<String> values) {
            addCriterion("patente_people_name in", values, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameNotIn(List<String> values) {
            addCriterion("patente_people_name not in", values, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameBetween(String value1, String value2) {
            addCriterion("patente_people_name between", value1, value2, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleNameNotBetween(String value1, String value2) {
            addCriterion("patente_people_name not between", value1, value2, "patentePeopleName");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdIsNull() {
            addCriterion("patente_people_id is null");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdIsNotNull() {
            addCriterion("patente_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdEqualTo(String value) {
            addCriterion("patente_people_id =", value, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdNotEqualTo(String value) {
            addCriterion("patente_people_id <>", value, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdGreaterThan(String value) {
            addCriterion("patente_people_id >", value, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdGreaterThanOrEqualTo(String value) {
            addCriterion("patente_people_id >=", value, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdLessThan(String value) {
            addCriterion("patente_people_id <", value, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdLessThanOrEqualTo(String value) {
            addCriterion("patente_people_id <=", value, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdLike(String value) {
            addCriterion("patente_people_id like", value, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdNotLike(String value) {
            addCriterion("patente_people_id not like", value, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdIn(List<String> values) {
            addCriterion("patente_people_id in", values, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdNotIn(List<String> values) {
            addCriterion("patente_people_id not in", values, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdBetween(String value1, String value2) {
            addCriterion("patente_people_id between", value1, value2, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andPatentePeopleIdNotBetween(String value1, String value2) {
            addCriterion("patente_people_id not between", value1, value2, "patentePeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdIsNull() {
            addCriterion("invent_people_id is null");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdIsNotNull() {
            addCriterion("invent_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdEqualTo(String value) {
            addCriterion("invent_people_id =", value, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdNotEqualTo(String value) {
            addCriterion("invent_people_id <>", value, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdGreaterThan(String value) {
            addCriterion("invent_people_id >", value, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdGreaterThanOrEqualTo(String value) {
            addCriterion("invent_people_id >=", value, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdLessThan(String value) {
            addCriterion("invent_people_id <", value, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdLessThanOrEqualTo(String value) {
            addCriterion("invent_people_id <=", value, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdLike(String value) {
            addCriterion("invent_people_id like", value, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdNotLike(String value) {
            addCriterion("invent_people_id not like", value, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdIn(List<String> values) {
            addCriterion("invent_people_id in", values, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdNotIn(List<String> values) {
            addCriterion("invent_people_id not in", values, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdBetween(String value1, String value2) {
            addCriterion("invent_people_id between", value1, value2, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleIdNotBetween(String value1, String value2) {
            addCriterion("invent_people_id not between", value1, value2, "inventPeopleId");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameIsNull() {
            addCriterion("invent_people_name is null");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameIsNotNull() {
            addCriterion("invent_people_name is not null");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameEqualTo(String value) {
            addCriterion("invent_people_name =", value, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameNotEqualTo(String value) {
            addCriterion("invent_people_name <>", value, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameGreaterThan(String value) {
            addCriterion("invent_people_name >", value, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameGreaterThanOrEqualTo(String value) {
            addCriterion("invent_people_name >=", value, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameLessThan(String value) {
            addCriterion("invent_people_name <", value, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameLessThanOrEqualTo(String value) {
            addCriterion("invent_people_name <=", value, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameLike(String value) {
            addCriterion("invent_people_name like", value, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameNotLike(String value) {
            addCriterion("invent_people_name not like", value, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameIn(List<String> values) {
            addCriterion("invent_people_name in", values, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameNotIn(List<String> values) {
            addCriterion("invent_people_name not in", values, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameBetween(String value1, String value2) {
            addCriterion("invent_people_name between", value1, value2, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andInventPeopleNameNotBetween(String value1, String value2) {
            addCriterion("invent_people_name not between", value1, value2, "inventPeopleName");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleIsNull() {
            addCriterion("apply_people is null");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleIsNotNull() {
            addCriterion("apply_people is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleEqualTo(String value) {
            addCriterion("apply_people =", value, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleNotEqualTo(String value) {
            addCriterion("apply_people <>", value, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleGreaterThan(String value) {
            addCriterion("apply_people >", value, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("apply_people >=", value, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleLessThan(String value) {
            addCriterion("apply_people <", value, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleLessThanOrEqualTo(String value) {
            addCriterion("apply_people <=", value, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleLike(String value) {
            addCriterion("apply_people like", value, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleNotLike(String value) {
            addCriterion("apply_people not like", value, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleIn(List<String> values) {
            addCriterion("apply_people in", values, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleNotIn(List<String> values) {
            addCriterion("apply_people not in", values, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleBetween(String value1, String value2) {
            addCriterion("apply_people between", value1, value2, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andApplyPeopleNotBetween(String value1, String value2) {
            addCriterion("apply_people not between", value1, value2, "applyPeople");
            return (Criteria) this;
        }

        public Criteria andPublicDateIsNull() {
            addCriterion("public_date is null");
            return (Criteria) this;
        }

        public Criteria andPublicDateIsNotNull() {
            addCriterion("public_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublicDateEqualTo(String value) {
            addCriterion("public_date =", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotEqualTo(String value) {
            addCriterion("public_date <>", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateGreaterThan(String value) {
            addCriterion("public_date >", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateGreaterThanOrEqualTo(String value) {
            addCriterion("public_date >=", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateLessThan(String value) {
            addCriterion("public_date <", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateLessThanOrEqualTo(String value) {
            addCriterion("public_date <=", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateLike(String value) {
            addCriterion("public_date like", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotLike(String value) {
            addCriterion("public_date not like", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateIn(List<String> values) {
            addCriterion("public_date in", values, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotIn(List<String> values) {
            addCriterion("public_date not in", values, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateBetween(String value1, String value2) {
            addCriterion("public_date between", value1, value2, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotBetween(String value1, String value2) {
            addCriterion("public_date not between", value1, value2, "publicDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("apply_date is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(String value) {
            addCriterion("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(String value) {
            addCriterion("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(String value) {
            addCriterion("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(String value) {
            addCriterion("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(String value) {
            addCriterion("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(String value) {
            addCriterion("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLike(String value) {
            addCriterion("apply_date like", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotLike(String value) {
            addCriterion("apply_date not like", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<String> values) {
            addCriterion("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<String> values) {
            addCriterion("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(String value1, String value2) {
            addCriterion("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(String value1, String value2) {
            addCriterion("apply_date not between", value1, value2, "applyDate");
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

        public Criteria andOwnerTechTypeIsNull() {
            addCriterion("owner_tech_type is null");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeIsNotNull() {
            addCriterion("owner_tech_type is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeEqualTo(String value) {
            addCriterion("owner_tech_type =", value, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeNotEqualTo(String value) {
            addCriterion("owner_tech_type <>", value, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeGreaterThan(String value) {
            addCriterion("owner_tech_type >", value, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeGreaterThanOrEqualTo(String value) {
            addCriterion("owner_tech_type >=", value, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeLessThan(String value) {
            addCriterion("owner_tech_type <", value, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeLessThanOrEqualTo(String value) {
            addCriterion("owner_tech_type <=", value, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeLike(String value) {
            addCriterion("owner_tech_type like", value, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeNotLike(String value) {
            addCriterion("owner_tech_type not like", value, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeIn(List<String> values) {
            addCriterion("owner_tech_type in", values, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeNotIn(List<String> values) {
            addCriterion("owner_tech_type not in", values, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeBetween(String value1, String value2) {
            addCriterion("owner_tech_type between", value1, value2, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andOwnerTechTypeNotBetween(String value1, String value2) {
            addCriterion("owner_tech_type not between", value1, value2, "ownerTechType");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundIsNull() {
            addCriterion("patente_background is null");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundIsNotNull() {
            addCriterion("patente_background is not null");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundEqualTo(String value) {
            addCriterion("patente_background =", value, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundNotEqualTo(String value) {
            addCriterion("patente_background <>", value, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundGreaterThan(String value) {
            addCriterion("patente_background >", value, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("patente_background >=", value, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundLessThan(String value) {
            addCriterion("patente_background <", value, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundLessThanOrEqualTo(String value) {
            addCriterion("patente_background <=", value, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundLike(String value) {
            addCriterion("patente_background like", value, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundNotLike(String value) {
            addCriterion("patente_background not like", value, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundIn(List<String> values) {
            addCriterion("patente_background in", values, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundNotIn(List<String> values) {
            addCriterion("patente_background not in", values, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundBetween(String value1, String value2) {
            addCriterion("patente_background between", value1, value2, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andPatenteBackgroundNotBetween(String value1, String value2) {
            addCriterion("patente_background not between", value1, value2, "patenteBackground");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameIsNull() {
            addCriterion("owner_project_name is null");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameIsNotNull() {
            addCriterion("owner_project_name is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameEqualTo(String value) {
            addCriterion("owner_project_name =", value, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameNotEqualTo(String value) {
            addCriterion("owner_project_name <>", value, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameGreaterThan(String value) {
            addCriterion("owner_project_name >", value, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("owner_project_name >=", value, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameLessThan(String value) {
            addCriterion("owner_project_name <", value, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameLessThanOrEqualTo(String value) {
            addCriterion("owner_project_name <=", value, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameLike(String value) {
            addCriterion("owner_project_name like", value, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameNotLike(String value) {
            addCriterion("owner_project_name not like", value, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameIn(List<String> values) {
            addCriterion("owner_project_name in", values, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameNotIn(List<String> values) {
            addCriterion("owner_project_name not in", values, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameBetween(String value1, String value2) {
            addCriterion("owner_project_name between", value1, value2, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectNameNotBetween(String value1, String value2) {
            addCriterion("owner_project_name not between", value1, value2, "ownerProjectName");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityIsNull() {
            addCriterion("expert_nationality is null");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityIsNotNull() {
            addCriterion("expert_nationality is not null");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityEqualTo(String value) {
            addCriterion("expert_nationality =", value, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityNotEqualTo(String value) {
            addCriterion("expert_nationality <>", value, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityGreaterThan(String value) {
            addCriterion("expert_nationality >", value, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityGreaterThanOrEqualTo(String value) {
            addCriterion("expert_nationality >=", value, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityLessThan(String value) {
            addCriterion("expert_nationality <", value, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityLessThanOrEqualTo(String value) {
            addCriterion("expert_nationality <=", value, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityLike(String value) {
            addCriterion("expert_nationality like", value, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityNotLike(String value) {
            addCriterion("expert_nationality not like", value, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityIn(List<String> values) {
            addCriterion("expert_nationality in", values, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityNotIn(List<String> values) {
            addCriterion("expert_nationality not in", values, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityBetween(String value1, String value2) {
            addCriterion("expert_nationality between", value1, value2, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andExpertNationalityNotBetween(String value1, String value2) {
            addCriterion("expert_nationality not between", value1, value2, "expertNationality");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdIsNull() {
            addCriterion("owner_project_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdIsNotNull() {
            addCriterion("owner_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdEqualTo(String value) {
            addCriterion("owner_project_id =", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotEqualTo(String value) {
            addCriterion("owner_project_id <>", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdGreaterThan(String value) {
            addCriterion("owner_project_id >", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("owner_project_id >=", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdLessThan(String value) {
            addCriterion("owner_project_id <", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdLessThanOrEqualTo(String value) {
            addCriterion("owner_project_id <=", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdLike(String value) {
            addCriterion("owner_project_id like", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotLike(String value) {
            addCriterion("owner_project_id not like", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdIn(List<String> values) {
            addCriterion("owner_project_id in", values, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotIn(List<String> values) {
            addCriterion("owner_project_id not in", values, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdBetween(String value1, String value2) {
            addCriterion("owner_project_id between", value1, value2, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotBetween(String value1, String value2) {
            addCriterion("owner_project_id not between", value1, value2, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanIdIsNull() {
            addCriterion("compan_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanIdIsNotNull() {
            addCriterion("compan_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanIdEqualTo(String value) {
            addCriterion("compan_id =", value, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdNotEqualTo(String value) {
            addCriterion("compan_id <>", value, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdGreaterThan(String value) {
            addCriterion("compan_id >", value, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdGreaterThanOrEqualTo(String value) {
            addCriterion("compan_id >=", value, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdLessThan(String value) {
            addCriterion("compan_id <", value, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdLessThanOrEqualTo(String value) {
            addCriterion("compan_id <=", value, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdLike(String value) {
            addCriterion("compan_id like", value, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdNotLike(String value) {
            addCriterion("compan_id not like", value, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdIn(List<String> values) {
            addCriterion("compan_id in", values, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdNotIn(List<String> values) {
            addCriterion("compan_id not in", values, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdBetween(String value1, String value2) {
            addCriterion("compan_id between", value1, value2, "companId");
            return (Criteria) this;
        }

        public Criteria andCompanIdNotBetween(String value1, String value2) {
            addCriterion("compan_id not between", value1, value2, "companId");
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