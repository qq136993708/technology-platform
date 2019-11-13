package com.pcitc.base.expert;

import java.util.ArrayList;
import java.util.List;

public class ZjkDataExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ZjkDataExample() {
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