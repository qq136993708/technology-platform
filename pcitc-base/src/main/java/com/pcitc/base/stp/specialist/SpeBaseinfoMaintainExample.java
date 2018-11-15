package com.pcitc.base.stp.specialist;

import java.util.ArrayList;
import java.util.List;

public class SpeBaseinfoMaintainExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SpeBaseinfoMaintainExample() {
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

		public Criteria andBaseIdIsNull() {
			addCriterion("base_id is null");
			return (Criteria) this;
		}

		public Criteria andBaseIdIsNotNull() {
			addCriterion("base_id is not null");
			return (Criteria) this;
		}

		public Criteria andBaseIdEqualTo(String value) {
			addCriterion("base_id =", value, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdNotEqualTo(String value) {
			addCriterion("base_id <>", value, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdGreaterThan(String value) {
			addCriterion("base_id >", value, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdGreaterThanOrEqualTo(String value) {
			addCriterion("base_id >=", value, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdLessThan(String value) {
			addCriterion("base_id <", value, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdLessThanOrEqualTo(String value) {
			addCriterion("base_id <=", value, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdLike(String value) {
			addCriterion("base_id like", value, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdNotLike(String value) {
			addCriterion("base_id not like", value, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdIn(List<String> values) {
			addCriterion("base_id in", values, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdNotIn(List<String> values) {
			addCriterion("base_id not in", values, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdBetween(String value1, String value2) {
			addCriterion("base_id between", value1, value2, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseIdNotBetween(String value1, String value2) {
			addCriterion("base_id not between", value1, value2, "baseId");
			return (Criteria) this;
		}

		public Criteria andBaseCodeIsNull() {
			addCriterion("base_code is null");
			return (Criteria) this;
		}

		public Criteria andBaseCodeIsNotNull() {
			addCriterion("base_code is not null");
			return (Criteria) this;
		}

		public Criteria andBaseCodeEqualTo(String value) {
			addCriterion("base_code =", value, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeNotEqualTo(String value) {
			addCriterion("base_code <>", value, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeGreaterThan(String value) {
			addCriterion("base_code >", value, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeGreaterThanOrEqualTo(String value) {
			addCriterion("base_code >=", value, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeLessThan(String value) {
			addCriterion("base_code <", value, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeLessThanOrEqualTo(String value) {
			addCriterion("base_code <=", value, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeLike(String value) {
			addCriterion("base_code like", value, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeNotLike(String value) {
			addCriterion("base_code not like", value, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeIn(List<String> values) {
			addCriterion("base_code in", values, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeNotIn(List<String> values) {
			addCriterion("base_code not in", values, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeBetween(String value1, String value2) {
			addCriterion("base_code between", value1, value2, "baseCode");
			return (Criteria) this;
		}

		public Criteria andBaseCodeNotBetween(String value1, String value2) {
			addCriterion("base_code not between", value1, value2, "baseCode");
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

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
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

		public Criteria andNativePlaceIsNull() {
			addCriterion("native_place is null");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIsNotNull() {
			addCriterion("native_place is not null");
			return (Criteria) this;
		}

		public Criteria andNativePlaceEqualTo(String value) {
			addCriterion("native_place =", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotEqualTo(String value) {
			addCriterion("native_place <>", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceGreaterThan(String value) {
			addCriterion("native_place >", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
			addCriterion("native_place >=", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLessThan(String value) {
			addCriterion("native_place <", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLessThanOrEqualTo(String value) {
			addCriterion("native_place <=", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLike(String value) {
			addCriterion("native_place like", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotLike(String value) {
			addCriterion("native_place not like", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIn(List<String> values) {
			addCriterion("native_place in", values, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotIn(List<String> values) {
			addCriterion("native_place not in", values, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceBetween(String value1, String value2) {
			addCriterion("native_place between", value1, value2, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotBetween(String value1, String value2) {
			addCriterion("native_place not between", value1, value2, "nativePlace");
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

		public Criteria andTitleInfoIsNull() {
			addCriterion("title_info is null");
			return (Criteria) this;
		}

		public Criteria andTitleInfoIsNotNull() {
			addCriterion("title_info is not null");
			return (Criteria) this;
		}

		public Criteria andTitleInfoEqualTo(String value) {
			addCriterion("title_info =", value, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoNotEqualTo(String value) {
			addCriterion("title_info <>", value, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoGreaterThan(String value) {
			addCriterion("title_info >", value, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoGreaterThanOrEqualTo(String value) {
			addCriterion("title_info >=", value, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoLessThan(String value) {
			addCriterion("title_info <", value, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoLessThanOrEqualTo(String value) {
			addCriterion("title_info <=", value, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoLike(String value) {
			addCriterion("title_info like", value, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoNotLike(String value) {
			addCriterion("title_info not like", value, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoIn(List<String> values) {
			addCriterion("title_info in", values, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoNotIn(List<String> values) {
			addCriterion("title_info not in", values, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoBetween(String value1, String value2) {
			addCriterion("title_info between", value1, value2, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andTitleInfoNotBetween(String value1, String value2) {
			addCriterion("title_info not between", value1, value2, "titleInfo");
			return (Criteria) this;
		}

		public Criteria andWorkResumeIsNull() {
			addCriterion("work_resume is null");
			return (Criteria) this;
		}

		public Criteria andWorkResumeIsNotNull() {
			addCriterion("work_resume is not null");
			return (Criteria) this;
		}

		public Criteria andWorkResumeEqualTo(String value) {
			addCriterion("work_resume =", value, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeNotEqualTo(String value) {
			addCriterion("work_resume <>", value, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeGreaterThan(String value) {
			addCriterion("work_resume >", value, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeGreaterThanOrEqualTo(String value) {
			addCriterion("work_resume >=", value, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeLessThan(String value) {
			addCriterion("work_resume <", value, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeLessThanOrEqualTo(String value) {
			addCriterion("work_resume <=", value, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeLike(String value) {
			addCriterion("work_resume like", value, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeNotLike(String value) {
			addCriterion("work_resume not like", value, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeIn(List<String> values) {
			addCriterion("work_resume in", values, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeNotIn(List<String> values) {
			addCriterion("work_resume not in", values, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeBetween(String value1, String value2) {
			addCriterion("work_resume between", value1, value2, "workResume");
			return (Criteria) this;
		}

		public Criteria andWorkResumeNotBetween(String value1, String value2) {
			addCriterion("work_resume not between", value1, value2, "workResume");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldIsNull() {
			addCriterion("technical_field is null");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldIsNotNull() {
			addCriterion("technical_field is not null");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldEqualTo(String value) {
			addCriterion("technical_field =", value, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldNotEqualTo(String value) {
			addCriterion("technical_field <>", value, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldGreaterThan(String value) {
			addCriterion("technical_field >", value, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldGreaterThanOrEqualTo(String value) {
			addCriterion("technical_field >=", value, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldLessThan(String value) {
			addCriterion("technical_field <", value, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldLessThanOrEqualTo(String value) {
			addCriterion("technical_field <=", value, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldLike(String value) {
			addCriterion("technical_field like", value, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldNotLike(String value) {
			addCriterion("technical_field not like", value, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldIn(List<String> values) {
			addCriterion("technical_field in", values, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldNotIn(List<String> values) {
			addCriterion("technical_field not in", values, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldBetween(String value1, String value2) {
			addCriterion("technical_field between", value1, value2, "technicalField");
			return (Criteria) this;
		}

		public Criteria andTechnicalFieldNotBetween(String value1, String value2) {
			addCriterion("technical_field not between", value1, value2, "technicalField");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoIsNull() {
			addCriterion("reward_punishment_info is null");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoIsNotNull() {
			addCriterion("reward_punishment_info is not null");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoEqualTo(String value) {
			addCriterion("reward_punishment_info =", value, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoNotEqualTo(String value) {
			addCriterion("reward_punishment_info <>", value, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoGreaterThan(String value) {
			addCriterion("reward_punishment_info >", value, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoGreaterThanOrEqualTo(String value) {
			addCriterion("reward_punishment_info >=", value, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoLessThan(String value) {
			addCriterion("reward_punishment_info <", value, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoLessThanOrEqualTo(String value) {
			addCriterion("reward_punishment_info <=", value, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoLike(String value) {
			addCriterion("reward_punishment_info like", value, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoNotLike(String value) {
			addCriterion("reward_punishment_info not like", value, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoIn(List<String> values) {
			addCriterion("reward_punishment_info in", values, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoNotIn(List<String> values) {
			addCriterion("reward_punishment_info not in", values, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoBetween(String value1, String value2) {
			addCriterion("reward_punishment_info between", value1, value2, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andRewardPunishmentInfoNotBetween(String value1, String value2) {
			addCriterion("reward_punishment_info not between", value1, value2, "rewardPunishmentInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoIsNull() {
			addCriterion("avoidance_info is null");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoIsNotNull() {
			addCriterion("avoidance_info is not null");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoEqualTo(String value) {
			addCriterion("avoidance_info =", value, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoNotEqualTo(String value) {
			addCriterion("avoidance_info <>", value, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoGreaterThan(String value) {
			addCriterion("avoidance_info >", value, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoGreaterThanOrEqualTo(String value) {
			addCriterion("avoidance_info >=", value, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoLessThan(String value) {
			addCriterion("avoidance_info <", value, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoLessThanOrEqualTo(String value) {
			addCriterion("avoidance_info <=", value, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoLike(String value) {
			addCriterion("avoidance_info like", value, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoNotLike(String value) {
			addCriterion("avoidance_info not like", value, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoIn(List<String> values) {
			addCriterion("avoidance_info in", values, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoNotIn(List<String> values) {
			addCriterion("avoidance_info not in", values, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoBetween(String value1, String value2) {
			addCriterion("avoidance_info between", value1, value2, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andAvoidanceInfoNotBetween(String value1, String value2) {
			addCriterion("avoidance_info not between", value1, value2, "avoidanceInfo");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationIsNull() {
			addCriterion("professional_classification is null");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationIsNotNull() {
			addCriterion("professional_classification is not null");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationEqualTo(String value) {
			addCriterion("professional_classification =", value, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationNotEqualTo(String value) {
			addCriterion("professional_classification <>", value, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationGreaterThan(String value) {
			addCriterion("professional_classification >", value, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationGreaterThanOrEqualTo(String value) {
			addCriterion("professional_classification >=", value, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationLessThan(String value) {
			addCriterion("professional_classification <", value, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationLessThanOrEqualTo(String value) {
			addCriterion("professional_classification <=", value, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationLike(String value) {
			addCriterion("professional_classification like", value, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationNotLike(String value) {
			addCriterion("professional_classification not like", value, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationIn(List<String> values) {
			addCriterion("professional_classification in", values, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationNotIn(List<String> values) {
			addCriterion("professional_classification not in", values, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationBetween(String value1, String value2) {
			addCriterion("professional_classification between", value1, value2, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andProfessionalClassificationNotBetween(String value1, String value2) {
			addCriterion("professional_classification not between", value1, value2, "professionalClassification");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeIsNull() {
			addCriterion("technical_qualification_type is null");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeIsNotNull() {
			addCriterion("technical_qualification_type is not null");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeEqualTo(String value) {
			addCriterion("technical_qualification_type =", value, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeNotEqualTo(String value) {
			addCriterion("technical_qualification_type <>", value, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeGreaterThan(String value) {
			addCriterion("technical_qualification_type >", value, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeGreaterThanOrEqualTo(String value) {
			addCriterion("technical_qualification_type >=", value, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeLessThan(String value) {
			addCriterion("technical_qualification_type <", value, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeLessThanOrEqualTo(String value) {
			addCriterion("technical_qualification_type <=", value, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeLike(String value) {
			addCriterion("technical_qualification_type like", value, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeNotLike(String value) {
			addCriterion("technical_qualification_type not like", value, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeIn(List<String> values) {
			addCriterion("technical_qualification_type in", values, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeNotIn(List<String> values) {
			addCriterion("technical_qualification_type not in", values, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeBetween(String value1, String value2) {
			addCriterion("technical_qualification_type between", value1, value2, "technicalQualificationType");
			return (Criteria) this;
		}

		public Criteria andTechnicalQualificationTypeNotBetween(String value1, String value2) {
			addCriterion("technical_qualification_type not between", value1, value2, "technicalQualificationType");
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