package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.List;

public class SysPostFunctionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public SysPostFunctionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
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

		public Criteria andRelIdIsNull() {
			addCriterion("rel_id is null");
			return (Criteria) this;
		}

		public Criteria andRelIdIsNotNull() {
			addCriterion("rel_id is not null");
			return (Criteria) this;
		}

		public Criteria andRelIdEqualTo(String value) {
			addCriterion("rel_id =", value, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdNotEqualTo(String value) {
			addCriterion("rel_id <>", value, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdGreaterThan(String value) {
			addCriterion("rel_id >", value, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdGreaterThanOrEqualTo(String value) {
			addCriterion("rel_id >=", value, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdLessThan(String value) {
			addCriterion("rel_id <", value, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdLessThanOrEqualTo(String value) {
			addCriterion("rel_id <=", value, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdLike(String value) {
			addCriterion("rel_id like", value, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdNotLike(String value) {
			addCriterion("rel_id not like", value, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdIn(List<String> values) {
			addCriterion("rel_id in", values, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdNotIn(List<String> values) {
			addCriterion("rel_id not in", values, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdBetween(String value1, String value2) {
			addCriterion("rel_id between", value1, value2, "relId");
			return (Criteria) this;
		}

		public Criteria andRelIdNotBetween(String value1, String value2) {
			addCriterion("rel_id not between", value1, value2, "relId");
			return (Criteria) this;
		}

		public Criteria andUnitIdIsNull() {
			addCriterion("unit_id is null");
			return (Criteria) this;
		}

		public Criteria andUnitIdIsNotNull() {
			addCriterion("unit_id is not null");
			return (Criteria) this;
		}

		public Criteria andUnitIdEqualTo(String value) {
			addCriterion("unit_id =", value, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdNotEqualTo(String value) {
			addCriterion("unit_id <>", value, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdGreaterThan(String value) {
			addCriterion("unit_id >", value, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdGreaterThanOrEqualTo(String value) {
			addCriterion("unit_id >=", value, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdLessThan(String value) {
			addCriterion("unit_id <", value, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdLessThanOrEqualTo(String value) {
			addCriterion("unit_id <=", value, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdLike(String value) {
			addCriterion("unit_id like", value, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdNotLike(String value) {
			addCriterion("unit_id not like", value, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdIn(List<String> values) {
			addCriterion("unit_id in", values, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdNotIn(List<String> values) {
			addCriterion("unit_id not in", values, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdBetween(String value1, String value2) {
			addCriterion("unit_id between", value1, value2, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitIdNotBetween(String value1, String value2) {
			addCriterion("unit_id not between", value1, value2, "unitId");
			return (Criteria) this;
		}

		public Criteria andUnitCodeIsNull() {
			addCriterion("unit_code is null");
			return (Criteria) this;
		}

		public Criteria andUnitCodeIsNotNull() {
			addCriterion("unit_code is not null");
			return (Criteria) this;
		}

		public Criteria andUnitCodeEqualTo(String value) {
			addCriterion("unit_code =", value, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeNotEqualTo(String value) {
			addCriterion("unit_code <>", value, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeGreaterThan(String value) {
			addCriterion("unit_code >", value, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeGreaterThanOrEqualTo(String value) {
			addCriterion("unit_code >=", value, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeLessThan(String value) {
			addCriterion("unit_code <", value, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeLessThanOrEqualTo(String value) {
			addCriterion("unit_code <=", value, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeLike(String value) {
			addCriterion("unit_code like", value, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeNotLike(String value) {
			addCriterion("unit_code not like", value, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeIn(List<String> values) {
			addCriterion("unit_code in", values, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeNotIn(List<String> values) {
			addCriterion("unit_code not in", values, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeBetween(String value1, String value2) {
			addCriterion("unit_code between", value1, value2, "unitCode");
			return (Criteria) this;
		}

		public Criteria andUnitCodeNotBetween(String value1, String value2) {
			addCriterion("unit_code not between", value1, value2, "unitCode");
			return (Criteria) this;
		}

		public Criteria andPostIdIsNull() {
			addCriterion("post_id is null");
			return (Criteria) this;
		}

		public Criteria andPostIdIsNotNull() {
			addCriterion("post_id is not null");
			return (Criteria) this;
		}

		public Criteria andPostIdEqualTo(String value) {
			addCriterion("post_id =", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotEqualTo(String value) {
			addCriterion("post_id <>", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdGreaterThan(String value) {
			addCriterion("post_id >", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdGreaterThanOrEqualTo(String value) {
			addCriterion("post_id >=", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdLessThan(String value) {
			addCriterion("post_id <", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdLessThanOrEqualTo(String value) {
			addCriterion("post_id <=", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdLike(String value) {
			addCriterion("post_id like", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotLike(String value) {
			addCriterion("post_id not like", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdIn(List<String> values) {
			addCriterion("post_id in", values, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotIn(List<String> values) {
			addCriterion("post_id not in", values, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdBetween(String value1, String value2) {
			addCriterion("post_id between", value1, value2, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotBetween(String value1, String value2) {
			addCriterion("post_id not between", value1, value2, "postId");
			return (Criteria) this;
		}

		public Criteria andPostCodeIsNull() {
			addCriterion("post_code is null");
			return (Criteria) this;
		}

		public Criteria andPostCodeIsNotNull() {
			addCriterion("post_code is not null");
			return (Criteria) this;
		}

		public Criteria andPostCodeEqualTo(String value) {
			addCriterion("post_code =", value, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeNotEqualTo(String value) {
			addCriterion("post_code <>", value, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeGreaterThan(String value) {
			addCriterion("post_code >", value, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
			addCriterion("post_code >=", value, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeLessThan(String value) {
			addCriterion("post_code <", value, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeLessThanOrEqualTo(String value) {
			addCriterion("post_code <=", value, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeLike(String value) {
			addCriterion("post_code like", value, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeNotLike(String value) {
			addCriterion("post_code not like", value, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeIn(List<String> values) {
			addCriterion("post_code in", values, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeNotIn(List<String> values) {
			addCriterion("post_code not in", values, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeBetween(String value1, String value2) {
			addCriterion("post_code between", value1, value2, "postCode");
			return (Criteria) this;
		}

		public Criteria andPostCodeNotBetween(String value1, String value2) {
			addCriterion("post_code not between", value1, value2, "postCode");
			return (Criteria) this;
		}

		public Criteria andFunctionIdIsNull() {
			addCriterion("function_id is null");
			return (Criteria) this;
		}

		public Criteria andFunctionIdIsNotNull() {
			addCriterion("function_id is not null");
			return (Criteria) this;
		}

		public Criteria andFunctionIdEqualTo(String value) {
			addCriterion("function_id =", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdNotEqualTo(String value) {
			addCriterion("function_id <>", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdGreaterThan(String value) {
			addCriterion("function_id >", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdGreaterThanOrEqualTo(String value) {
			addCriterion("function_id >=", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdLessThan(String value) {
			addCriterion("function_id <", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdLessThanOrEqualTo(String value) {
			addCriterion("function_id <=", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdLike(String value) {
			addCriterion("function_id like", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdNotLike(String value) {
			addCriterion("function_id not like", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdIn(List<String> values) {
			addCriterion("function_id in", values, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdNotIn(List<String> values) {
			addCriterion("function_id not in", values, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdBetween(String value1, String value2) {
			addCriterion("function_id between", value1, value2, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdNotBetween(String value1, String value2) {
			addCriterion("function_id not between", value1, value2, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeIsNull() {
			addCriterion("function_code is null");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeIsNotNull() {
			addCriterion("function_code is not null");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeEqualTo(String value) {
			addCriterion("function_code =", value, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeNotEqualTo(String value) {
			addCriterion("function_code <>", value, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeGreaterThan(String value) {
			addCriterion("function_code >", value, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeGreaterThanOrEqualTo(String value) {
			addCriterion("function_code >=", value, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeLessThan(String value) {
			addCriterion("function_code <", value, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeLessThanOrEqualTo(String value) {
			addCriterion("function_code <=", value, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeLike(String value) {
			addCriterion("function_code like", value, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeNotLike(String value) {
			addCriterion("function_code not like", value, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeIn(List<String> values) {
			addCriterion("function_code in", values, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeNotIn(List<String> values) {
			addCriterion("function_code not in", values, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeBetween(String value1, String value2) {
			addCriterion("function_code between", value1, value2, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionCodeNotBetween(String value1, String value2) {
			addCriterion("function_code not between", value1, value2, "functionCode");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsIsNull() {
			addCriterion("function_buttons is null");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsIsNotNull() {
			addCriterion("function_buttons is not null");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsEqualTo(String value) {
			addCriterion("function_buttons =", value, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsNotEqualTo(String value) {
			addCriterion("function_buttons <>", value, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsGreaterThan(String value) {
			addCriterion("function_buttons >", value, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsGreaterThanOrEqualTo(String value) {
			addCriterion("function_buttons >=", value, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsLessThan(String value) {
			addCriterion("function_buttons <", value, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsLessThanOrEqualTo(String value) {
			addCriterion("function_buttons <=", value, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsLike(String value) {
			addCriterion("function_buttons like", value, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsNotLike(String value) {
			addCriterion("function_buttons not like", value, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsIn(List<String> values) {
			addCriterion("function_buttons in", values, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsNotIn(List<String> values) {
			addCriterion("function_buttons not in", values, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsBetween(String value1, String value2) {
			addCriterion("function_buttons between", value1, value2, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andFunctionButtonsNotBetween(String value1, String value2) {
			addCriterion("function_buttons not between", value1, value2, "functionButtons");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdIsNull() {
			addCriterion("create_person_id is null");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdIsNotNull() {
			addCriterion("create_person_id is not null");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdEqualTo(String value) {
			addCriterion("create_person_id =", value, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdNotEqualTo(String value) {
			addCriterion("create_person_id <>", value, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdGreaterThan(String value) {
			addCriterion("create_person_id >", value, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdGreaterThanOrEqualTo(String value) {
			addCriterion("create_person_id >=", value, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdLessThan(String value) {
			addCriterion("create_person_id <", value, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdLessThanOrEqualTo(String value) {
			addCriterion("create_person_id <=", value, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdLike(String value) {
			addCriterion("create_person_id like", value, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdNotLike(String value) {
			addCriterion("create_person_id not like", value, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdIn(List<String> values) {
			addCriterion("create_person_id in", values, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdNotIn(List<String> values) {
			addCriterion("create_person_id not in", values, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdBetween(String value1, String value2) {
			addCriterion("create_person_id between", value1, value2, "createPersonId");
			return (Criteria) this;
		}

		public Criteria andCreatePersonIdNotBetween(String value1, String value2) {
			addCriterion("create_person_id not between", value1, value2, "createPersonId");
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
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_post_function
	 * @mbg.generated  Wed Jun 20 16:42:28 CST 2018
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_post_function_rel
     *
     * @mbg.generated do_not_delete_during_merge Wed Jun 13 09:11:27 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}