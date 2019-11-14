package com.pcitc.base.expert;

import java.util.ArrayList;
import java.util.List;

public class ZjkExpertExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;
    
    private String key;
    
    

    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ZjkExpertExample() {
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

        public Criteria andExpertNameIsNull() {
            addCriterion("expert_name is null");
            return (Criteria) this;
        }

        public Criteria andExpertNameIsNotNull() {
            addCriterion("expert_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpertNameEqualTo(String value) {
            addCriterion("expert_name =", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotEqualTo(String value) {
            addCriterion("expert_name <>", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThan(String value) {
            addCriterion("expert_name >", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThanOrEqualTo(String value) {
            addCriterion("expert_name >=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThan(String value) {
            addCriterion("expert_name <", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThanOrEqualTo(String value) {
            addCriterion("expert_name <=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLike(String value) {
            addCriterion("expert_name like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotLike(String value) {
            addCriterion("expert_name not like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameIn(List<String> values) {
            addCriterion("expert_name in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotIn(List<String> values) {
            addCriterion("expert_name not in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameBetween(String value1, String value2) {
            addCriterion("expert_name between", value1, value2, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotBetween(String value1, String value2) {
            addCriterion("expert_name not between", value1, value2, "expertName");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
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

        public Criteria andUserDescIsNull() {
            addCriterion("user_desc is null");
            return (Criteria) this;
        }

        public Criteria andUserDescIsNotNull() {
            addCriterion("user_desc is not null");
            return (Criteria) this;
        }

        public Criteria andUserDescEqualTo(String value) {
            addCriterion("user_desc =", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotEqualTo(String value) {
            addCriterion("user_desc <>", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescGreaterThan(String value) {
            addCriterion("user_desc >", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescGreaterThanOrEqualTo(String value) {
            addCriterion("user_desc >=", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescLessThan(String value) {
            addCriterion("user_desc <", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescLessThanOrEqualTo(String value) {
            addCriterion("user_desc <=", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescLike(String value) {
            addCriterion("user_desc like", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotLike(String value) {
            addCriterion("user_desc not like", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescIn(List<String> values) {
            addCriterion("user_desc in", values, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotIn(List<String> values) {
            addCriterion("user_desc not in", values, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescBetween(String value1, String value2) {
            addCriterion("user_desc between", value1, value2, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotBetween(String value1, String value2) {
            addCriterion("user_desc not between", value1, value2, "userDesc");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalIsNull() {
            addCriterion("expert_professinal is null");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalIsNotNull() {
            addCriterion("expert_professinal is not null");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalEqualTo(String value) {
            addCriterion("expert_professinal =", value, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalNotEqualTo(String value) {
            addCriterion("expert_professinal <>", value, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalGreaterThan(String value) {
            addCriterion("expert_professinal >", value, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalGreaterThanOrEqualTo(String value) {
            addCriterion("expert_professinal >=", value, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalLessThan(String value) {
            addCriterion("expert_professinal <", value, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalLessThanOrEqualTo(String value) {
            addCriterion("expert_professinal <=", value, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalLike(String value) {
            addCriterion("expert_professinal like", value, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalNotLike(String value) {
            addCriterion("expert_professinal not like", value, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalIn(List<String> values) {
            addCriterion("expert_professinal in", values, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalNotIn(List<String> values) {
            addCriterion("expert_professinal not in", values, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalBetween(String value1, String value2) {
            addCriterion("expert_professinal between", value1, value2, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andExpertProfessinalNotBetween(String value1, String value2) {
            addCriterion("expert_professinal not between", value1, value2, "expertProfessinal");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenIsNull() {
            addCriterion("age_between is null");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenIsNotNull() {
            addCriterion("age_between is not null");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenEqualTo(String value) {
            addCriterion("age_between =", value, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenNotEqualTo(String value) {
            addCriterion("age_between <>", value, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenGreaterThan(String value) {
            addCriterion("age_between >", value, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenGreaterThanOrEqualTo(String value) {
            addCriterion("age_between >=", value, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenLessThan(String value) {
            addCriterion("age_between <", value, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenLessThanOrEqualTo(String value) {
            addCriterion("age_between <=", value, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenLike(String value) {
            addCriterion("age_between like", value, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenNotLike(String value) {
            addCriterion("age_between not like", value, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenIn(List<String> values) {
            addCriterion("age_between in", values, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenNotIn(List<String> values) {
            addCriterion("age_between not in", values, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenBetween(String value1, String value2) {
            addCriterion("age_between between", value1, value2, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeBetweenNotBetween(String value1, String value2) {
            addCriterion("age_between not between", value1, value2, "ageBetween");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("age like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("age not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(String value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(String value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(String value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(String value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(String value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(String value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLike(String value) {
            addCriterion("birth_date like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotLike(String value) {
            addCriterion("birth_date not like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<String> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<String> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(String value1, String value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(String value1, String value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNull() {
            addCriterion("college is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("college is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("college =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("college <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("college >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("college >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("college <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("college <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("college like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("college not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("college in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("college not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("college between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("college not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andAmountCountIsNull() {
            addCriterion("amount_count is null");
            return (Criteria) this;
        }

        public Criteria andAmountCountIsNotNull() {
            addCriterion("amount_count is not null");
            return (Criteria) this;
        }

        public Criteria andAmountCountEqualTo(String value) {
            addCriterion("amount_count =", value, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountNotEqualTo(String value) {
            addCriterion("amount_count <>", value, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountGreaterThan(String value) {
            addCriterion("amount_count >", value, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountGreaterThanOrEqualTo(String value) {
            addCriterion("amount_count >=", value, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountLessThan(String value) {
            addCriterion("amount_count <", value, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountLessThanOrEqualTo(String value) {
            addCriterion("amount_count <=", value, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountLike(String value) {
            addCriterion("amount_count like", value, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountNotLike(String value) {
            addCriterion("amount_count not like", value, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountIn(List<String> values) {
            addCriterion("amount_count in", values, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountNotIn(List<String> values) {
            addCriterion("amount_count not in", values, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountBetween(String value1, String value2) {
            addCriterion("amount_count between", value1, value2, "amountCount");
            return (Criteria) this;
        }

        public Criteria andAmountCountNotBetween(String value1, String value2) {
            addCriterion("amount_count not between", value1, value2, "amountCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountIsNull() {
            addCriterion("patent_count is null");
            return (Criteria) this;
        }

        public Criteria andPatentCountIsNotNull() {
            addCriterion("patent_count is not null");
            return (Criteria) this;
        }

        public Criteria andPatentCountEqualTo(String value) {
            addCriterion("patent_count =", value, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountNotEqualTo(String value) {
            addCriterion("patent_count <>", value, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountGreaterThan(String value) {
            addCriterion("patent_count >", value, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountGreaterThanOrEqualTo(String value) {
            addCriterion("patent_count >=", value, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountLessThan(String value) {
            addCriterion("patent_count <", value, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountLessThanOrEqualTo(String value) {
            addCriterion("patent_count <=", value, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountLike(String value) {
            addCriterion("patent_count like", value, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountNotLike(String value) {
            addCriterion("patent_count not like", value, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountIn(List<String> values) {
            addCriterion("patent_count in", values, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountNotIn(List<String> values) {
            addCriterion("patent_count not in", values, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountBetween(String value1, String value2) {
            addCriterion("patent_count between", value1, value2, "patentCount");
            return (Criteria) this;
        }

        public Criteria andPatentCountNotBetween(String value1, String value2) {
            addCriterion("patent_count not between", value1, value2, "patentCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountIsNull() {
            addCriterion("project_count is null");
            return (Criteria) this;
        }

        public Criteria andProjectCountIsNotNull() {
            addCriterion("project_count is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCountEqualTo(String value) {
            addCriterion("project_count =", value, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountNotEqualTo(String value) {
            addCriterion("project_count <>", value, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountGreaterThan(String value) {
            addCriterion("project_count >", value, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountGreaterThanOrEqualTo(String value) {
            addCriterion("project_count >=", value, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountLessThan(String value) {
            addCriterion("project_count <", value, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountLessThanOrEqualTo(String value) {
            addCriterion("project_count <=", value, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountLike(String value) {
            addCriterion("project_count like", value, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountNotLike(String value) {
            addCriterion("project_count not like", value, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountIn(List<String> values) {
            addCriterion("project_count in", values, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountNotIn(List<String> values) {
            addCriterion("project_count not in", values, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountBetween(String value1, String value2) {
            addCriterion("project_count between", value1, value2, "projectCount");
            return (Criteria) this;
        }

        public Criteria andProjectCountNotBetween(String value1, String value2) {
            addCriterion("project_count not between", value1, value2, "projectCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountIsNull() {
            addCriterion("company_count is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCountIsNotNull() {
            addCriterion("company_count is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCountEqualTo(String value) {
            addCriterion("company_count =", value, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountNotEqualTo(String value) {
            addCriterion("company_count <>", value, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountGreaterThan(String value) {
            addCriterion("company_count >", value, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountGreaterThanOrEqualTo(String value) {
            addCriterion("company_count >=", value, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountLessThan(String value) {
            addCriterion("company_count <", value, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountLessThanOrEqualTo(String value) {
            addCriterion("company_count <=", value, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountLike(String value) {
            addCriterion("company_count like", value, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountNotLike(String value) {
            addCriterion("company_count not like", value, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountIn(List<String> values) {
            addCriterion("company_count in", values, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountNotIn(List<String> values) {
            addCriterion("company_count not in", values, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountBetween(String value1, String value2) {
            addCriterion("company_count between", value1, value2, "companyCount");
            return (Criteria) this;
        }

        public Criteria andCompanyCountNotBetween(String value1, String value2) {
            addCriterion("company_count not between", value1, value2, "companyCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountIsNull() {
            addCriterion("achievement_count is null");
            return (Criteria) this;
        }

        public Criteria andAchievementCountIsNotNull() {
            addCriterion("achievement_count is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementCountEqualTo(String value) {
            addCriterion("achievement_count =", value, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountNotEqualTo(String value) {
            addCriterion("achievement_count <>", value, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountGreaterThan(String value) {
            addCriterion("achievement_count >", value, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountGreaterThanOrEqualTo(String value) {
            addCriterion("achievement_count >=", value, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountLessThan(String value) {
            addCriterion("achievement_count <", value, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountLessThanOrEqualTo(String value) {
            addCriterion("achievement_count <=", value, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountLike(String value) {
            addCriterion("achievement_count like", value, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountNotLike(String value) {
            addCriterion("achievement_count not like", value, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountIn(List<String> values) {
            addCriterion("achievement_count in", values, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountNotIn(List<String> values) {
            addCriterion("achievement_count not in", values, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountBetween(String value1, String value2) {
            addCriterion("achievement_count between", value1, value2, "achievementCount");
            return (Criteria) this;
        }

        public Criteria andAchievementCountNotBetween(String value1, String value2) {
            addCriterion("achievement_count not between", value1, value2, "achievementCount");
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

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldIsNull() {
            addCriterion("expert_professional_field is null");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldIsNotNull() {
            addCriterion("expert_professional_field is not null");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldEqualTo(String value) {
            addCriterion("expert_professional_field =", value, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNotEqualTo(String value) {
            addCriterion("expert_professional_field <>", value, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldGreaterThan(String value) {
            addCriterion("expert_professional_field >", value, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldGreaterThanOrEqualTo(String value) {
            addCriterion("expert_professional_field >=", value, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldLessThan(String value) {
            addCriterion("expert_professional_field <", value, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldLessThanOrEqualTo(String value) {
            addCriterion("expert_professional_field <=", value, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldLike(String value) {
            addCriterion("expert_professional_field like", value, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNotLike(String value) {
            addCriterion("expert_professional_field not like", value, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldIn(List<String> values) {
            addCriterion("expert_professional_field in", values, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNotIn(List<String> values) {
            addCriterion("expert_professional_field not in", values, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldBetween(String value1, String value2) {
            addCriterion("expert_professional_field between", value1, value2, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNotBetween(String value1, String value2) {
            addCriterion("expert_professional_field not between", value1, value2, "expertProfessionalField");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameIsNull() {
            addCriterion("expert_professional_field_name is null");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameIsNotNull() {
            addCriterion("expert_professional_field_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameEqualTo(String value) {
            addCriterion("expert_professional_field_name =", value, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameNotEqualTo(String value) {
            addCriterion("expert_professional_field_name <>", value, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameGreaterThan(String value) {
            addCriterion("expert_professional_field_name >", value, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("expert_professional_field_name >=", value, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameLessThan(String value) {
            addCriterion("expert_professional_field_name <", value, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameLessThanOrEqualTo(String value) {
            addCriterion("expert_professional_field_name <=", value, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameLike(String value) {
            addCriterion("expert_professional_field_name like", value, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameNotLike(String value) {
            addCriterion("expert_professional_field_name not like", value, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameIn(List<String> values) {
            addCriterion("expert_professional_field_name in", values, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameNotIn(List<String> values) {
            addCriterion("expert_professional_field_name not in", values, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameBetween(String value1, String value2) {
            addCriterion("expert_professional_field_name between", value1, value2, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andExpertProfessionalFieldNameNotBetween(String value1, String value2) {
            addCriterion("expert_professional_field_name not between", value1, value2, "expertProfessionalFieldName");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("source_id like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("source_id not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(String value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(String value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(String value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(String value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(String value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLike(String value) {
            addCriterion("card_id like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotLike(String value) {
            addCriterion("card_id not like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<String> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<String> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(String value1, String value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(String value1, String value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andHeaderImgIsNull() {
            addCriterion("header_img is null");
            return (Criteria) this;
        }

        public Criteria andHeaderImgIsNotNull() {
            addCriterion("header_img is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderImgEqualTo(String value) {
            addCriterion("header_img =", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotEqualTo(String value) {
            addCriterion("header_img <>", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgGreaterThan(String value) {
            addCriterion("header_img >", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgGreaterThanOrEqualTo(String value) {
            addCriterion("header_img >=", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgLessThan(String value) {
            addCriterion("header_img <", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgLessThanOrEqualTo(String value) {
            addCriterion("header_img <=", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgLike(String value) {
            addCriterion("header_img like", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotLike(String value) {
            addCriterion("header_img not like", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgIn(List<String> values) {
            addCriterion("header_img in", values, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotIn(List<String> values) {
            addCriterion("header_img not in", values, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgBetween(String value1, String value2) {
            addCriterion("header_img between", value1, value2, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotBetween(String value1, String value2) {
            addCriterion("header_img not between", value1, value2, "headerImg");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameIsNull() {
            addCriterion("join_project_name is null");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameIsNotNull() {
            addCriterion("join_project_name is not null");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameEqualTo(String value) {
            addCriterion("join_project_name =", value, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameNotEqualTo(String value) {
            addCriterion("join_project_name <>", value, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameGreaterThan(String value) {
            addCriterion("join_project_name >", value, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("join_project_name >=", value, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameLessThan(String value) {
            addCriterion("join_project_name <", value, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameLessThanOrEqualTo(String value) {
            addCriterion("join_project_name <=", value, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameLike(String value) {
            addCriterion("join_project_name like", value, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameNotLike(String value) {
            addCriterion("join_project_name not like", value, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameIn(List<String> values) {
            addCriterion("join_project_name in", values, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameNotIn(List<String> values) {
            addCriterion("join_project_name not in", values, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameBetween(String value1, String value2) {
            addCriterion("join_project_name between", value1, value2, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectNameNotBetween(String value1, String value2) {
            addCriterion("join_project_name not between", value1, value2, "joinProjectName");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdIsNull() {
            addCriterion("join_project_id is null");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdIsNotNull() {
            addCriterion("join_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdEqualTo(String value) {
            addCriterion("join_project_id =", value, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdNotEqualTo(String value) {
            addCriterion("join_project_id <>", value, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdGreaterThan(String value) {
            addCriterion("join_project_id >", value, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("join_project_id >=", value, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdLessThan(String value) {
            addCriterion("join_project_id <", value, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdLessThanOrEqualTo(String value) {
            addCriterion("join_project_id <=", value, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdLike(String value) {
            addCriterion("join_project_id like", value, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdNotLike(String value) {
            addCriterion("join_project_id not like", value, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdIn(List<String> values) {
            addCriterion("join_project_id in", values, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdNotIn(List<String> values) {
            addCriterion("join_project_id not in", values, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdBetween(String value1, String value2) {
            addCriterion("join_project_id between", value1, value2, "joinProjectId");
            return (Criteria) this;
        }

        public Criteria andJoinProjectIdNotBetween(String value1, String value2) {
            addCriterion("join_project_id not between", value1, value2, "joinProjectId");
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

        public Criteria andFormCodeIsNull() {
            addCriterion("form_code is null");
            return (Criteria) this;
        }

        public Criteria andFormCodeIsNotNull() {
            addCriterion("form_code is not null");
            return (Criteria) this;
        }

        public Criteria andFormCodeEqualTo(String value) {
            addCriterion("form_code =", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeNotEqualTo(String value) {
            addCriterion("form_code <>", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeGreaterThan(String value) {
            addCriterion("form_code >", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeGreaterThanOrEqualTo(String value) {
            addCriterion("form_code >=", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeLessThan(String value) {
            addCriterion("form_code <", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeLessThanOrEqualTo(String value) {
            addCriterion("form_code <=", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeLike(String value) {
            addCriterion("form_code like", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeNotLike(String value) {
            addCriterion("form_code not like", value, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeIn(List<String> values) {
            addCriterion("form_code in", values, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeNotIn(List<String> values) {
            addCriterion("form_code not in", values, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeBetween(String value1, String value2) {
            addCriterion("form_code between", value1, value2, "formCode");
            return (Criteria) this;
        }

        public Criteria andFormCodeNotBetween(String value1, String value2) {
            addCriterion("form_code not between", value1, value2, "formCode");
            return (Criteria) this;
        }

        public Criteria andDataIndexIsNull() {
            addCriterion("data_index is null");
            return (Criteria) this;
        }

        public Criteria andDataIndexIsNotNull() {
            addCriterion("data_index is not null");
            return (Criteria) this;
        }

        public Criteria andDataIndexEqualTo(String value) {
            addCriterion("data_index =", value, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexNotEqualTo(String value) {
            addCriterion("data_index <>", value, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexGreaterThan(String value) {
            addCriterion("data_index >", value, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexGreaterThanOrEqualTo(String value) {
            addCriterion("data_index >=", value, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexLessThan(String value) {
            addCriterion("data_index <", value, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexLessThanOrEqualTo(String value) {
            addCriterion("data_index <=", value, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexLike(String value) {
            addCriterion("data_index like", value, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexNotLike(String value) {
            addCriterion("data_index not like", value, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexIn(List<String> values) {
            addCriterion("data_index in", values, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexNotIn(List<String> values) {
            addCriterion("data_index not in", values, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexBetween(String value1, String value2) {
            addCriterion("data_index between", value1, value2, "dataIndex");
            return (Criteria) this;
        }

        public Criteria andDataIndexNotBetween(String value1, String value2) {
            addCriterion("data_index not between", value1, value2, "dataIndex");
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

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("company_code like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("company_code not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceIsNull() {
            addCriterion("political_face is null");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceIsNotNull() {
            addCriterion("political_face is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceEqualTo(String value) {
            addCriterion("political_face =", value, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceNotEqualTo(String value) {
            addCriterion("political_face <>", value, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceGreaterThan(String value) {
            addCriterion("political_face >", value, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceGreaterThanOrEqualTo(String value) {
            addCriterion("political_face >=", value, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceLessThan(String value) {
            addCriterion("political_face <", value, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceLessThanOrEqualTo(String value) {
            addCriterion("political_face <=", value, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceLike(String value) {
            addCriterion("political_face like", value, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceNotLike(String value) {
            addCriterion("political_face not like", value, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceIn(List<String> values) {
            addCriterion("political_face in", values, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceNotIn(List<String> values) {
            addCriterion("political_face not in", values, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceBetween(String value1, String value2) {
            addCriterion("political_face between", value1, value2, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andPoliticalFaceNotBetween(String value1, String value2) {
            addCriterion("political_face not between", value1, value2, "politicalFace");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsIsNull() {
            addCriterion("unit_belongs is null");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsIsNotNull() {
            addCriterion("unit_belongs is not null");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsEqualTo(String value) {
            addCriterion("unit_belongs =", value, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsNotEqualTo(String value) {
            addCriterion("unit_belongs <>", value, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsGreaterThan(String value) {
            addCriterion("unit_belongs >", value, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsGreaterThanOrEqualTo(String value) {
            addCriterion("unit_belongs >=", value, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsLessThan(String value) {
            addCriterion("unit_belongs <", value, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsLessThanOrEqualTo(String value) {
            addCriterion("unit_belongs <=", value, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsLike(String value) {
            addCriterion("unit_belongs like", value, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsNotLike(String value) {
            addCriterion("unit_belongs not like", value, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsIn(List<String> values) {
            addCriterion("unit_belongs in", values, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsNotIn(List<String> values) {
            addCriterion("unit_belongs not in", values, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsBetween(String value1, String value2) {
            addCriterion("unit_belongs between", value1, value2, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andUnitBelongsNotBetween(String value1, String value2) {
            addCriterion("unit_belongs not between", value1, value2, "unitBelongs");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeIsNull() {
            addCriterion("professional_and_time is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeIsNotNull() {
            addCriterion("professional_and_time is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeEqualTo(String value) {
            addCriterion("professional_and_time =", value, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeNotEqualTo(String value) {
            addCriterion("professional_and_time <>", value, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeGreaterThan(String value) {
            addCriterion("professional_and_time >", value, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("professional_and_time >=", value, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeLessThan(String value) {
            addCriterion("professional_and_time <", value, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeLessThanOrEqualTo(String value) {
            addCriterion("professional_and_time <=", value, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeLike(String value) {
            addCriterion("professional_and_time like", value, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeNotLike(String value) {
            addCriterion("professional_and_time not like", value, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeIn(List<String> values) {
            addCriterion("professional_and_time in", values, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeNotIn(List<String> values) {
            addCriterion("professional_and_time not in", values, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeBetween(String value1, String value2) {
            addCriterion("professional_and_time between", value1, value2, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andProfessionalAndTimeNotBetween(String value1, String value2) {
            addCriterion("professional_and_time not between", value1, value2, "professionalAndTime");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesIsNull() {
            addCriterion("administrative_duties is null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesIsNotNull() {
            addCriterion("administrative_duties is not null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesEqualTo(String value) {
            addCriterion("administrative_duties =", value, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesNotEqualTo(String value) {
            addCriterion("administrative_duties <>", value, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesGreaterThan(String value) {
            addCriterion("administrative_duties >", value, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesGreaterThanOrEqualTo(String value) {
            addCriterion("administrative_duties >=", value, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesLessThan(String value) {
            addCriterion("administrative_duties <", value, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesLessThanOrEqualTo(String value) {
            addCriterion("administrative_duties <=", value, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesLike(String value) {
            addCriterion("administrative_duties like", value, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesNotLike(String value) {
            addCriterion("administrative_duties not like", value, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesIn(List<String> values) {
            addCriterion("administrative_duties in", values, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesNotIn(List<String> values) {
            addCriterion("administrative_duties not in", values, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesBetween(String value1, String value2) {
            addCriterion("administrative_duties between", value1, value2, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDutiesNotBetween(String value1, String value2) {
            addCriterion("administrative_duties not between", value1, value2, "administrativeDuties");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionIsNull() {
            addCriterion("technical_positiion is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionIsNotNull() {
            addCriterion("technical_positiion is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionEqualTo(String value) {
            addCriterion("technical_positiion =", value, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionNotEqualTo(String value) {
            addCriterion("technical_positiion <>", value, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionGreaterThan(String value) {
            addCriterion("technical_positiion >", value, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionGreaterThanOrEqualTo(String value) {
            addCriterion("technical_positiion >=", value, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionLessThan(String value) {
            addCriterion("technical_positiion <", value, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionLessThanOrEqualTo(String value) {
            addCriterion("technical_positiion <=", value, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionLike(String value) {
            addCriterion("technical_positiion like", value, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionNotLike(String value) {
            addCriterion("technical_positiion not like", value, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionIn(List<String> values) {
            addCriterion("technical_positiion in", values, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionNotIn(List<String> values) {
            addCriterion("technical_positiion not in", values, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionBetween(String value1, String value2) {
            addCriterion("technical_positiion between", value1, value2, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andTechnicalPositiionNotBetween(String value1, String value2) {
            addCriterion("technical_positiion not between", value1, value2, "technicalPositiion");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleIsNull() {
            addCriterion("awards_title is null");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleIsNotNull() {
            addCriterion("awards_title is not null");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleEqualTo(String value) {
            addCriterion("awards_title =", value, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleNotEqualTo(String value) {
            addCriterion("awards_title <>", value, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleGreaterThan(String value) {
            addCriterion("awards_title >", value, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("awards_title >=", value, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleLessThan(String value) {
            addCriterion("awards_title <", value, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleLessThanOrEqualTo(String value) {
            addCriterion("awards_title <=", value, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleLike(String value) {
            addCriterion("awards_title like", value, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleNotLike(String value) {
            addCriterion("awards_title not like", value, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleIn(List<String> values) {
            addCriterion("awards_title in", values, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleNotIn(List<String> values) {
            addCriterion("awards_title not in", values, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleBetween(String value1, String value2) {
            addCriterion("awards_title between", value1, value2, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andAwardsTitleNotBetween(String value1, String value2) {
            addCriterion("awards_title not between", value1, value2, "awardsTitle");
            return (Criteria) this;
        }

        public Criteria andBriefDescIsNull() {
            addCriterion("brief_desc is null");
            return (Criteria) this;
        }

        public Criteria andBriefDescIsNotNull() {
            addCriterion("brief_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBriefDescEqualTo(String value) {
            addCriterion("brief_desc =", value, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescNotEqualTo(String value) {
            addCriterion("brief_desc <>", value, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescGreaterThan(String value) {
            addCriterion("brief_desc >", value, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescGreaterThanOrEqualTo(String value) {
            addCriterion("brief_desc >=", value, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescLessThan(String value) {
            addCriterion("brief_desc <", value, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescLessThanOrEqualTo(String value) {
            addCriterion("brief_desc <=", value, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescLike(String value) {
            addCriterion("brief_desc like", value, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescNotLike(String value) {
            addCriterion("brief_desc not like", value, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescIn(List<String> values) {
            addCriterion("brief_desc in", values, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescNotIn(List<String> values) {
            addCriterion("brief_desc not in", values, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescBetween(String value1, String value2) {
            addCriterion("brief_desc between", value1, value2, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andBriefDescNotBetween(String value1, String value2) {
            addCriterion("brief_desc not between", value1, value2, "briefDesc");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginIsNull() {
            addCriterion("place_origin is null");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginIsNotNull() {
            addCriterion("place_origin is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginEqualTo(String value) {
            addCriterion("place_origin =", value, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginNotEqualTo(String value) {
            addCriterion("place_origin <>", value, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginGreaterThan(String value) {
            addCriterion("place_origin >", value, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginGreaterThanOrEqualTo(String value) {
            addCriterion("place_origin >=", value, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginLessThan(String value) {
            addCriterion("place_origin <", value, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginLessThanOrEqualTo(String value) {
            addCriterion("place_origin <=", value, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginLike(String value) {
            addCriterion("place_origin like", value, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginNotLike(String value) {
            addCriterion("place_origin not like", value, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginIn(List<String> values) {
            addCriterion("place_origin in", values, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginNotIn(List<String> values) {
            addCriterion("place_origin not in", values, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginBetween(String value1, String value2) {
            addCriterion("place_origin between", value1, value2, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andPlaceOriginNotBetween(String value1, String value2) {
            addCriterion("place_origin not between", value1, value2, "placeOrigin");
            return (Criteria) this;
        }

        public Criteria andTeamViewIsNull() {
            addCriterion("team_view is null");
            return (Criteria) this;
        }

        public Criteria andTeamViewIsNotNull() {
            addCriterion("team_view is not null");
            return (Criteria) this;
        }

        public Criteria andTeamViewEqualTo(String value) {
            addCriterion("team_view =", value, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewNotEqualTo(String value) {
            addCriterion("team_view <>", value, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewGreaterThan(String value) {
            addCriterion("team_view >", value, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewGreaterThanOrEqualTo(String value) {
            addCriterion("team_view >=", value, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewLessThan(String value) {
            addCriterion("team_view <", value, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewLessThanOrEqualTo(String value) {
            addCriterion("team_view <=", value, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewLike(String value) {
            addCriterion("team_view like", value, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewNotLike(String value) {
            addCriterion("team_view not like", value, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewIn(List<String> values) {
            addCriterion("team_view in", values, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewNotIn(List<String> values) {
            addCriterion("team_view not in", values, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewBetween(String value1, String value2) {
            addCriterion("team_view between", value1, value2, "teamView");
            return (Criteria) this;
        }

        public Criteria andTeamViewNotBetween(String value1, String value2) {
            addCriterion("team_view not between", value1, value2, "teamView");
            return (Criteria) this;
        }

        public Criteria andBak7IsNull() {
            addCriterion("bak7 is null");
            return (Criteria) this;
        }

        public Criteria andBak7IsNotNull() {
            addCriterion("bak7 is not null");
            return (Criteria) this;
        }

        public Criteria andBak7EqualTo(String value) {
            addCriterion("bak7 =", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotEqualTo(String value) {
            addCriterion("bak7 <>", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7GreaterThan(String value) {
            addCriterion("bak7 >", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7GreaterThanOrEqualTo(String value) {
            addCriterion("bak7 >=", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7LessThan(String value) {
            addCriterion("bak7 <", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7LessThanOrEqualTo(String value) {
            addCriterion("bak7 <=", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7Like(String value) {
            addCriterion("bak7 like", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotLike(String value) {
            addCriterion("bak7 not like", value, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7In(List<String> values) {
            addCriterion("bak7 in", values, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotIn(List<String> values) {
            addCriterion("bak7 not in", values, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7Between(String value1, String value2) {
            addCriterion("bak7 between", value1, value2, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak7NotBetween(String value1, String value2) {
            addCriterion("bak7 not between", value1, value2, "bak7");
            return (Criteria) this;
        }

        public Criteria andBak8IsNull() {
            addCriterion("bak8 is null");
            return (Criteria) this;
        }

        public Criteria andBak8IsNotNull() {
            addCriterion("bak8 is not null");
            return (Criteria) this;
        }

        public Criteria andBak8EqualTo(String value) {
            addCriterion("bak8 =", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotEqualTo(String value) {
            addCriterion("bak8 <>", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8GreaterThan(String value) {
            addCriterion("bak8 >", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8GreaterThanOrEqualTo(String value) {
            addCriterion("bak8 >=", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8LessThan(String value) {
            addCriterion("bak8 <", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8LessThanOrEqualTo(String value) {
            addCriterion("bak8 <=", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8Like(String value) {
            addCriterion("bak8 like", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotLike(String value) {
            addCriterion("bak8 not like", value, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8In(List<String> values) {
            addCriterion("bak8 in", values, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotIn(List<String> values) {
            addCriterion("bak8 not in", values, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8Between(String value1, String value2) {
            addCriterion("bak8 between", value1, value2, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak8NotBetween(String value1, String value2) {
            addCriterion("bak8 not between", value1, value2, "bak8");
            return (Criteria) this;
        }

        public Criteria andBak9IsNull() {
            addCriterion("bak9 is null");
            return (Criteria) this;
        }

        public Criteria andBak9IsNotNull() {
            addCriterion("bak9 is not null");
            return (Criteria) this;
        }

        public Criteria andBak9EqualTo(String value) {
            addCriterion("bak9 =", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotEqualTo(String value) {
            addCriterion("bak9 <>", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9GreaterThan(String value) {
            addCriterion("bak9 >", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9GreaterThanOrEqualTo(String value) {
            addCriterion("bak9 >=", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9LessThan(String value) {
            addCriterion("bak9 <", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9LessThanOrEqualTo(String value) {
            addCriterion("bak9 <=", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9Like(String value) {
            addCriterion("bak9 like", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotLike(String value) {
            addCriterion("bak9 not like", value, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9In(List<String> values) {
            addCriterion("bak9 in", values, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotIn(List<String> values) {
            addCriterion("bak9 not in", values, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9Between(String value1, String value2) {
            addCriterion("bak9 between", value1, value2, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak9NotBetween(String value1, String value2) {
            addCriterion("bak9 not between", value1, value2, "bak9");
            return (Criteria) this;
        }

        public Criteria andBak10IsNull() {
            addCriterion("bak10 is null");
            return (Criteria) this;
        }

        public Criteria andBak10IsNotNull() {
            addCriterion("bak10 is not null");
            return (Criteria) this;
        }

        public Criteria andBak10EqualTo(String value) {
            addCriterion("bak10 =", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotEqualTo(String value) {
            addCriterion("bak10 <>", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10GreaterThan(String value) {
            addCriterion("bak10 >", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10GreaterThanOrEqualTo(String value) {
            addCriterion("bak10 >=", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10LessThan(String value) {
            addCriterion("bak10 <", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10LessThanOrEqualTo(String value) {
            addCriterion("bak10 <=", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10Like(String value) {
            addCriterion("bak10 like", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotLike(String value) {
            addCriterion("bak10 not like", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10In(List<String> values) {
            addCriterion("bak10 in", values, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotIn(List<String> values) {
            addCriterion("bak10 not in", values, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10Between(String value1, String value2) {
            addCriterion("bak10 between", value1, value2, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotBetween(String value1, String value2) {
            addCriterion("bak10 not between", value1, value2, "bak10");
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