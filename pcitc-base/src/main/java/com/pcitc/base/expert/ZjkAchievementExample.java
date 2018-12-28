package com.pcitc.base.expert;


import java.util.ArrayList;
import java.util.List;

public class ZjkAchievementExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ZjkAchievementExample() {
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

        public Criteria andAchievementNameIsNull() {
            addCriterion("achievement_name is null");
            return (Criteria) this;
        }

        public Criteria andAchievementNameIsNotNull() {
            addCriterion("achievement_name is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementNameEqualTo(String value) {
            addCriterion("achievement_name =", value, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameNotEqualTo(String value) {
            addCriterion("achievement_name <>", value, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameGreaterThan(String value) {
            addCriterion("achievement_name >", value, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameGreaterThanOrEqualTo(String value) {
            addCriterion("achievement_name >=", value, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameLessThan(String value) {
            addCriterion("achievement_name <", value, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameLessThanOrEqualTo(String value) {
            addCriterion("achievement_name <=", value, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameLike(String value) {
            addCriterion("achievement_name like", value, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameNotLike(String value) {
            addCriterion("achievement_name not like", value, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameIn(List<String> values) {
            addCriterion("achievement_name in", values, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameNotIn(List<String> values) {
            addCriterion("achievement_name not in", values, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameBetween(String value1, String value2) {
            addCriterion("achievement_name between", value1, value2, "achievementName");
            return (Criteria) this;
        }

        public Criteria andAchievementNameNotBetween(String value1, String value2) {
            addCriterion("achievement_name not between", value1, value2, "achievementName");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleIsNull() {
            addCriterion("finish_people is null");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleIsNotNull() {
            addCriterion("finish_people is not null");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleEqualTo(String value) {
            addCriterion("finish_people =", value, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleNotEqualTo(String value) {
            addCriterion("finish_people <>", value, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleGreaterThan(String value) {
            addCriterion("finish_people >", value, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("finish_people >=", value, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleLessThan(String value) {
            addCriterion("finish_people <", value, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleLessThanOrEqualTo(String value) {
            addCriterion("finish_people <=", value, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleLike(String value) {
            addCriterion("finish_people like", value, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleNotLike(String value) {
            addCriterion("finish_people not like", value, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleIn(List<String> values) {
            addCriterion("finish_people in", values, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleNotIn(List<String> values) {
            addCriterion("finish_people not in", values, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleBetween(String value1, String value2) {
            addCriterion("finish_people between", value1, value2, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andFinishPeopleNotBetween(String value1, String value2) {
            addCriterion("finish_people not between", value1, value2, "finishPeople");
            return (Criteria) this;
        }

        public Criteria andIndustryIdIsNull() {
            addCriterion("industry_id is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIdIsNotNull() {
            addCriterion("industry_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryIdEqualTo(String value) {
            addCriterion("industry_id =", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotEqualTo(String value) {
            addCriterion("industry_id <>", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdGreaterThan(String value) {
            addCriterion("industry_id >", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdGreaterThanOrEqualTo(String value) {
            addCriterion("industry_id >=", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdLessThan(String value) {
            addCriterion("industry_id <", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdLessThanOrEqualTo(String value) {
            addCriterion("industry_id <=", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdLike(String value) {
            addCriterion("industry_id like", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotLike(String value) {
            addCriterion("industry_id not like", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdIn(List<String> values) {
            addCriterion("industry_id in", values, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotIn(List<String> values) {
            addCriterion("industry_id not in", values, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdBetween(String value1, String value2) {
            addCriterion("industry_id between", value1, value2, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotBetween(String value1, String value2) {
            addCriterion("industry_id not between", value1, value2, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIsNull() {
            addCriterion("industry_name is null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIsNotNull() {
            addCriterion("industry_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEqualTo(String value) {
            addCriterion("industry_name =", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotEqualTo(String value) {
            addCriterion("industry_name <>", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameGreaterThan(String value) {
            addCriterion("industry_name >", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameGreaterThanOrEqualTo(String value) {
            addCriterion("industry_name >=", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLessThan(String value) {
            addCriterion("industry_name <", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLessThanOrEqualTo(String value) {
            addCriterion("industry_name <=", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLike(String value) {
            addCriterion("industry_name like", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotLike(String value) {
            addCriterion("industry_name not like", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIn(List<String> values) {
            addCriterion("industry_name in", values, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotIn(List<String> values) {
            addCriterion("industry_name not in", values, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameBetween(String value1, String value2) {
            addCriterion("industry_name between", value1, value2, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotBetween(String value1, String value2) {
            addCriterion("industry_name not between", value1, value2, "industryName");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysIsNull() {
            addCriterion("achievement_keys is null");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysIsNotNull() {
            addCriterion("achievement_keys is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysEqualTo(String value) {
            addCriterion("achievement_keys =", value, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysNotEqualTo(String value) {
            addCriterion("achievement_keys <>", value, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysGreaterThan(String value) {
            addCriterion("achievement_keys >", value, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysGreaterThanOrEqualTo(String value) {
            addCriterion("achievement_keys >=", value, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysLessThan(String value) {
            addCriterion("achievement_keys <", value, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysLessThanOrEqualTo(String value) {
            addCriterion("achievement_keys <=", value, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysLike(String value) {
            addCriterion("achievement_keys like", value, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysNotLike(String value) {
            addCriterion("achievement_keys not like", value, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysIn(List<String> values) {
            addCriterion("achievement_keys in", values, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysNotIn(List<String> values) {
            addCriterion("achievement_keys not in", values, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysBetween(String value1, String value2) {
            addCriterion("achievement_keys between", value1, value2, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andAchievementKeysNotBetween(String value1, String value2) {
            addCriterion("achievement_keys not between", value1, value2, "achievementKeys");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(String value) {
            addCriterion("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(String value) {
            addCriterion("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(String value) {
            addCriterion("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(String value) {
            addCriterion("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(String value) {
            addCriterion("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(String value) {
            addCriterion("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLike(String value) {
            addCriterion("publish_date like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotLike(String value) {
            addCriterion("publish_date not like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<String> values) {
            addCriterion("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<String> values) {
            addCriterion("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(String value1, String value2) {
            addCriterion("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(String value1, String value2) {
            addCriterion("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andAchievementDescIsNull() {
            addCriterion("achievement_desc is null");
            return (Criteria) this;
        }

        public Criteria andAchievementDescIsNotNull() {
            addCriterion("achievement_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementDescEqualTo(String value) {
            addCriterion("achievement_desc =", value, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescNotEqualTo(String value) {
            addCriterion("achievement_desc <>", value, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescGreaterThan(String value) {
            addCriterion("achievement_desc >", value, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescGreaterThanOrEqualTo(String value) {
            addCriterion("achievement_desc >=", value, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescLessThan(String value) {
            addCriterion("achievement_desc <", value, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescLessThanOrEqualTo(String value) {
            addCriterion("achievement_desc <=", value, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescLike(String value) {
            addCriterion("achievement_desc like", value, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescNotLike(String value) {
            addCriterion("achievement_desc not like", value, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescIn(List<String> values) {
            addCriterion("achievement_desc in", values, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescNotIn(List<String> values) {
            addCriterion("achievement_desc not in", values, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescBetween(String value1, String value2) {
            addCriterion("achievement_desc between", value1, value2, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementDescNotBetween(String value1, String value2) {
            addCriterion("achievement_desc not between", value1, value2, "achievementDesc");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelIsNull() {
            addCriterion("achievement_level is null");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelIsNotNull() {
            addCriterion("achievement_level is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelEqualTo(String value) {
            addCriterion("achievement_level =", value, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelNotEqualTo(String value) {
            addCriterion("achievement_level <>", value, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelGreaterThan(String value) {
            addCriterion("achievement_level >", value, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelGreaterThanOrEqualTo(String value) {
            addCriterion("achievement_level >=", value, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelLessThan(String value) {
            addCriterion("achievement_level <", value, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelLessThanOrEqualTo(String value) {
            addCriterion("achievement_level <=", value, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelLike(String value) {
            addCriterion("achievement_level like", value, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelNotLike(String value) {
            addCriterion("achievement_level not like", value, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelIn(List<String> values) {
            addCriterion("achievement_level in", values, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelNotIn(List<String> values) {
            addCriterion("achievement_level not in", values, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelBetween(String value1, String value2) {
            addCriterion("achievement_level between", value1, value2, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementLevelNotBetween(String value1, String value2) {
            addCriterion("achievement_level not between", value1, value2, "achievementLevel");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeIsNull() {
            addCriterion("achievement_type is null");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeIsNotNull() {
            addCriterion("achievement_type is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeEqualTo(String value) {
            addCriterion("achievement_type =", value, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeNotEqualTo(String value) {
            addCriterion("achievement_type <>", value, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeGreaterThan(String value) {
            addCriterion("achievement_type >", value, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeGreaterThanOrEqualTo(String value) {
            addCriterion("achievement_type >=", value, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeLessThan(String value) {
            addCriterion("achievement_type <", value, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeLessThanOrEqualTo(String value) {
            addCriterion("achievement_type <=", value, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeLike(String value) {
            addCriterion("achievement_type like", value, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeNotLike(String value) {
            addCriterion("achievement_type not like", value, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeIn(List<String> values) {
            addCriterion("achievement_type in", values, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeNotIn(List<String> values) {
            addCriterion("achievement_type not in", values, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeBetween(String value1, String value2) {
            addCriterion("achievement_type between", value1, value2, "achievementType");
            return (Criteria) this;
        }

        public Criteria andAchievementTypeNotBetween(String value1, String value2) {
            addCriterion("achievement_type not between", value1, value2, "achievementType");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameIsNull() {
            addCriterion("owner_contract_name is null");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameIsNotNull() {
            addCriterion("owner_contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameEqualTo(String value) {
            addCriterion("owner_contract_name =", value, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameNotEqualTo(String value) {
            addCriterion("owner_contract_name <>", value, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameGreaterThan(String value) {
            addCriterion("owner_contract_name >", value, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("owner_contract_name >=", value, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameLessThan(String value) {
            addCriterion("owner_contract_name <", value, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameLessThanOrEqualTo(String value) {
            addCriterion("owner_contract_name <=", value, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameLike(String value) {
            addCriterion("owner_contract_name like", value, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameNotLike(String value) {
            addCriterion("owner_contract_name not like", value, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameIn(List<String> values) {
            addCriterion("owner_contract_name in", values, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameNotIn(List<String> values) {
            addCriterion("owner_contract_name not in", values, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameBetween(String value1, String value2) {
            addCriterion("owner_contract_name between", value1, value2, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractNameNotBetween(String value1, String value2) {
            addCriterion("owner_contract_name not between", value1, value2, "ownerContractName");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdIsNull() {
            addCriterion("owner_contract_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdIsNotNull() {
            addCriterion("owner_contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdEqualTo(String value) {
            addCriterion("owner_contract_id =", value, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdNotEqualTo(String value) {
            addCriterion("owner_contract_id <>", value, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdGreaterThan(String value) {
            addCriterion("owner_contract_id >", value, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdGreaterThanOrEqualTo(String value) {
            addCriterion("owner_contract_id >=", value, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdLessThan(String value) {
            addCriterion("owner_contract_id <", value, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdLessThanOrEqualTo(String value) {
            addCriterion("owner_contract_id <=", value, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdLike(String value) {
            addCriterion("owner_contract_id like", value, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdNotLike(String value) {
            addCriterion("owner_contract_id not like", value, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdIn(List<String> values) {
            addCriterion("owner_contract_id in", values, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdNotIn(List<String> values) {
            addCriterion("owner_contract_id not in", values, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdBetween(String value1, String value2) {
            addCriterion("owner_contract_id between", value1, value2, "ownerContractId");
            return (Criteria) this;
        }

        public Criteria andOwnerContractIdNotBetween(String value1, String value2) {
            addCriterion("owner_contract_id not between", value1, value2, "ownerContractId");
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