package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.List;

public class SysPostExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public SysPostExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
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

		public Criteria andPostNameIsNull() {
			addCriterion("post_name is null");
			return (Criteria) this;
		}

		public Criteria andPostNameIsNotNull() {
			addCriterion("post_name is not null");
			return (Criteria) this;
		}

		public Criteria andPostNameEqualTo(String value) {
			addCriterion("post_name =", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameNotEqualTo(String value) {
			addCriterion("post_name <>", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameGreaterThan(String value) {
			addCriterion("post_name >", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameGreaterThanOrEqualTo(String value) {
			addCriterion("post_name >=", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameLessThan(String value) {
			addCriterion("post_name <", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameLessThanOrEqualTo(String value) {
			addCriterion("post_name <=", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameLike(String value) {
			addCriterion("post_name like", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameNotLike(String value) {
			addCriterion("post_name not like", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameIn(List<String> values) {
			addCriterion("post_name in", values, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameNotIn(List<String> values) {
			addCriterion("post_name not in", values, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameBetween(String value1, String value2) {
			addCriterion("post_name between", value1, value2, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameNotBetween(String value1, String value2) {
			addCriterion("post_name not between", value1, value2, "postName");
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

		public Criteria andPostFlagIsNull() {
			addCriterion("post_flag is null");
			return (Criteria) this;
		}

		public Criteria andPostFlagIsNotNull() {
			addCriterion("post_flag is not null");
			return (Criteria) this;
		}

		public Criteria andPostFlagEqualTo(String value) {
			addCriterion("post_flag =", value, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagNotEqualTo(String value) {
			addCriterion("post_flag <>", value, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagGreaterThan(String value) {
			addCriterion("post_flag >", value, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagGreaterThanOrEqualTo(String value) {
			addCriterion("post_flag >=", value, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagLessThan(String value) {
			addCriterion("post_flag <", value, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagLessThanOrEqualTo(String value) {
			addCriterion("post_flag <=", value, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagLike(String value) {
			addCriterion("post_flag like", value, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagNotLike(String value) {
			addCriterion("post_flag not like", value, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagIn(List<String> values) {
			addCriterion("post_flag in", values, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagNotIn(List<String> values) {
			addCriterion("post_flag not in", values, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagBetween(String value1, String value2) {
			addCriterion("post_flag between", value1, value2, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostFlagNotBetween(String value1, String value2) {
			addCriterion("post_flag not between", value1, value2, "postFlag");
			return (Criteria) this;
		}

		public Criteria andPostKindIsNull() {
			addCriterion("post_kind is null");
			return (Criteria) this;
		}

		public Criteria andPostKindIsNotNull() {
			addCriterion("post_kind is not null");
			return (Criteria) this;
		}

		public Criteria andPostKindEqualTo(String value) {
			addCriterion("post_kind =", value, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindNotEqualTo(String value) {
			addCriterion("post_kind <>", value, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindGreaterThan(String value) {
			addCriterion("post_kind >", value, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindGreaterThanOrEqualTo(String value) {
			addCriterion("post_kind >=", value, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindLessThan(String value) {
			addCriterion("post_kind <", value, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindLessThanOrEqualTo(String value) {
			addCriterion("post_kind <=", value, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindLike(String value) {
			addCriterion("post_kind like", value, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindNotLike(String value) {
			addCriterion("post_kind not like", value, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindIn(List<String> values) {
			addCriterion("post_kind in", values, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindNotIn(List<String> values) {
			addCriterion("post_kind not in", values, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindBetween(String value1, String value2) {
			addCriterion("post_kind between", value1, value2, "postKind");
			return (Criteria) this;
		}

		public Criteria andPostKindNotBetween(String value1, String value2) {
			addCriterion("post_kind not between", value1, value2, "postKind");
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

		public Criteria andPostExtendIsNull() {
			addCriterion("post_extend is null");
			return (Criteria) this;
		}

		public Criteria andPostExtendIsNotNull() {
			addCriterion("post_extend is not null");
			return (Criteria) this;
		}

		public Criteria andPostExtendEqualTo(String value) {
			addCriterion("post_extend =", value, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendNotEqualTo(String value) {
			addCriterion("post_extend <>", value, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendGreaterThan(String value) {
			addCriterion("post_extend >", value, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendGreaterThanOrEqualTo(String value) {
			addCriterion("post_extend >=", value, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendLessThan(String value) {
			addCriterion("post_extend <", value, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendLessThanOrEqualTo(String value) {
			addCriterion("post_extend <=", value, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendLike(String value) {
			addCriterion("post_extend like", value, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendNotLike(String value) {
			addCriterion("post_extend not like", value, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendIn(List<String> values) {
			addCriterion("post_extend in", values, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendNotIn(List<String> values) {
			addCriterion("post_extend not in", values, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendBetween(String value1, String value2) {
			addCriterion("post_extend between", value1, value2, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostExtendNotBetween(String value1, String value2) {
			addCriterion("post_extend not between", value1, value2, "postExtend");
			return (Criteria) this;
		}

		public Criteria andPostOrderIsNull() {
			addCriterion("post_order is null");
			return (Criteria) this;
		}

		public Criteria andPostOrderIsNotNull() {
			addCriterion("post_order is not null");
			return (Criteria) this;
		}

		public Criteria andPostOrderEqualTo(Integer value) {
			addCriterion("post_order =", value, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostOrderNotEqualTo(Integer value) {
			addCriterion("post_order <>", value, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostOrderGreaterThan(Integer value) {
			addCriterion("post_order >", value, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostOrderGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_order >=", value, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostOrderLessThan(Integer value) {
			addCriterion("post_order <", value, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostOrderLessThanOrEqualTo(Integer value) {
			addCriterion("post_order <=", value, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostOrderIn(List<Integer> values) {
			addCriterion("post_order in", values, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostOrderNotIn(List<Integer> values) {
			addCriterion("post_order not in", values, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostOrderBetween(Integer value1, Integer value2) {
			addCriterion("post_order between", value1, value2, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostOrderNotBetween(Integer value1, Integer value2) {
			addCriterion("post_order not between", value1, value2, "postOrder");
			return (Criteria) this;
		}

		public Criteria andPostCommentIsNull() {
			addCriterion("post_comment is null");
			return (Criteria) this;
		}

		public Criteria andPostCommentIsNotNull() {
			addCriterion("post_comment is not null");
			return (Criteria) this;
		}

		public Criteria andPostCommentEqualTo(String value) {
			addCriterion("post_comment =", value, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentNotEqualTo(String value) {
			addCriterion("post_comment <>", value, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentGreaterThan(String value) {
			addCriterion("post_comment >", value, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentGreaterThanOrEqualTo(String value) {
			addCriterion("post_comment >=", value, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentLessThan(String value) {
			addCriterion("post_comment <", value, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentLessThanOrEqualTo(String value) {
			addCriterion("post_comment <=", value, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentLike(String value) {
			addCriterion("post_comment like", value, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentNotLike(String value) {
			addCriterion("post_comment not like", value, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentIn(List<String> values) {
			addCriterion("post_comment in", values, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentNotIn(List<String> values) {
			addCriterion("post_comment not in", values, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentBetween(String value1, String value2) {
			addCriterion("post_comment between", value1, value2, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostCommentNotBetween(String value1, String value2) {
			addCriterion("post_comment not between", value1, value2, "postComment");
			return (Criteria) this;
		}

		public Criteria andPostDelflagIsNull() {
			addCriterion("post_delflag is null");
			return (Criteria) this;
		}

		public Criteria andPostDelflagIsNotNull() {
			addCriterion("post_delflag is not null");
			return (Criteria) this;
		}

		public Criteria andPostDelflagEqualTo(Integer value) {
			addCriterion("post_delflag =", value, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostDelflagNotEqualTo(Integer value) {
			addCriterion("post_delflag <>", value, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostDelflagGreaterThan(Integer value) {
			addCriterion("post_delflag >", value, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostDelflagGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_delflag >=", value, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostDelflagLessThan(Integer value) {
			addCriterion("post_delflag <", value, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostDelflagLessThanOrEqualTo(Integer value) {
			addCriterion("post_delflag <=", value, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostDelflagIn(List<Integer> values) {
			addCriterion("post_delflag in", values, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostDelflagNotIn(List<Integer> values) {
			addCriterion("post_delflag not in", values, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostDelflagBetween(Integer value1, Integer value2) {
			addCriterion("post_delflag between", value1, value2, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostDelflagNotBetween(Integer value1, Integer value2) {
			addCriterion("post_delflag not between", value1, value2, "postDelflag");
			return (Criteria) this;
		}

		public Criteria andPostLevelIsNull() {
			addCriterion("post_level is null");
			return (Criteria) this;
		}

		public Criteria andPostLevelIsNotNull() {
			addCriterion("post_level is not null");
			return (Criteria) this;
		}

		public Criteria andPostLevelEqualTo(Integer value) {
			addCriterion("post_level =", value, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostLevelNotEqualTo(Integer value) {
			addCriterion("post_level <>", value, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostLevelGreaterThan(Integer value) {
			addCriterion("post_level >", value, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostLevelGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_level >=", value, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostLevelLessThan(Integer value) {
			addCriterion("post_level <", value, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostLevelLessThanOrEqualTo(Integer value) {
			addCriterion("post_level <=", value, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostLevelIn(List<Integer> values) {
			addCriterion("post_level in", values, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostLevelNotIn(List<Integer> values) {
			addCriterion("post_level not in", values, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostLevelBetween(Integer value1, Integer value2) {
			addCriterion("post_level between", value1, value2, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostLevelNotBetween(Integer value1, Integer value2) {
			addCriterion("post_level not between", value1, value2, "postLevel");
			return (Criteria) this;
		}

		public Criteria andPostRelationIsNull() {
			addCriterion("post_relation is null");
			return (Criteria) this;
		}

		public Criteria andPostRelationIsNotNull() {
			addCriterion("post_relation is not null");
			return (Criteria) this;
		}

		public Criteria andPostRelationEqualTo(String value) {
			addCriterion("post_relation =", value, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationNotEqualTo(String value) {
			addCriterion("post_relation <>", value, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationGreaterThan(String value) {
			addCriterion("post_relation >", value, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationGreaterThanOrEqualTo(String value) {
			addCriterion("post_relation >=", value, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationLessThan(String value) {
			addCriterion("post_relation <", value, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationLessThanOrEqualTo(String value) {
			addCriterion("post_relation <=", value, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationLike(String value) {
			addCriterion("post_relation like", value, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationNotLike(String value) {
			addCriterion("post_relation not like", value, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationIn(List<String> values) {
			addCriterion("post_relation in", values, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationNotIn(List<String> values) {
			addCriterion("post_relation not in", values, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationBetween(String value1, String value2) {
			addCriterion("post_relation between", value1, value2, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostRelationNotBetween(String value1, String value2) {
			addCriterion("post_relation not between", value1, value2, "postRelation");
			return (Criteria) this;
		}

		public Criteria andPostUnitIsNull() {
			addCriterion("post_unit is null");
			return (Criteria) this;
		}

		public Criteria andPostUnitIsNotNull() {
			addCriterion("post_unit is not null");
			return (Criteria) this;
		}

		public Criteria andPostUnitEqualTo(String value) {
			addCriterion("post_unit =", value, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitNotEqualTo(String value) {
			addCriterion("post_unit <>", value, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitGreaterThan(String value) {
			addCriterion("post_unit >", value, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitGreaterThanOrEqualTo(String value) {
			addCriterion("post_unit >=", value, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitLessThan(String value) {
			addCriterion("post_unit <", value, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitLessThanOrEqualTo(String value) {
			addCriterion("post_unit <=", value, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitLike(String value) {
			addCriterion("post_unit like", value, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitNotLike(String value) {
			addCriterion("post_unit not like", value, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitIn(List<String> values) {
			addCriterion("post_unit in", values, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitNotIn(List<String> values) {
			addCriterion("post_unit not in", values, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitBetween(String value1, String value2) {
			addCriterion("post_unit between", value1, value2, "postUnit");
			return (Criteria) this;
		}

		public Criteria andPostUnitNotBetween(String value1, String value2) {
			addCriterion("post_unit not between", value1, value2, "postUnit");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_post
	 * @mbg.generated  Wed Jun 13 09:17:02 CST 2018
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
     * This class corresponds to the database table sys_post
     *
     * @mbg.generated do_not_delete_during_merge Fri Apr 13 16:40:44 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}