package com.pcitc.base.system;


import java.util.ArrayList;
import java.util.List;

public class SysFileConfigExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SysFileConfigExample() {
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


        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(String value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(String value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(String value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(String value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(String value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLike(String value) {
            addCriterion("menu_id like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLike(String value) {
            addCriterion("menu_id not like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<String> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<String> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(String value1, String value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(String value1, String value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(String value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(String value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(String value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(String value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(String value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(String value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLike(String value) {
            addCriterion("file_size like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotLike(String value) {
            addCriterion("file_size not like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<String> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<String> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(String value1, String value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(String value1, String value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileCountIsNull() {
            addCriterion("file_count is null");
            return (Criteria) this;
        }

        public Criteria andFileCountIsNotNull() {
            addCriterion("file_count is not null");
            return (Criteria) this;
        }

        public Criteria andFileCountEqualTo(String value) {
            addCriterion("file_count =", value, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountNotEqualTo(String value) {
            addCriterion("file_count <>", value, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountGreaterThan(String value) {
            addCriterion("file_count >", value, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountGreaterThanOrEqualTo(String value) {
            addCriterion("file_count >=", value, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountLessThan(String value) {
            addCriterion("file_count <", value, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountLessThanOrEqualTo(String value) {
            addCriterion("file_count <=", value, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountLike(String value) {
            addCriterion("file_count like", value, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountNotLike(String value) {
            addCriterion("file_count not like", value, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountIn(List<String> values) {
            addCriterion("file_count in", values, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountNotIn(List<String> values) {
            addCriterion("file_count not in", values, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountBetween(String value1, String value2) {
            addCriterion("file_count between", value1, value2, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileCountNotBetween(String value1, String value2) {
            addCriterion("file_count not between", value1, value2, "fileCount");
            return (Criteria) this;
        }

        public Criteria andFileHeightIsNull() {
            addCriterion("file_height is null");
            return (Criteria) this;
        }

        public Criteria andFileHeightIsNotNull() {
            addCriterion("file_height is not null");
            return (Criteria) this;
        }

        public Criteria andFileHeightEqualTo(String value) {
            addCriterion("file_height =", value, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightNotEqualTo(String value) {
            addCriterion("file_height <>", value, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightGreaterThan(String value) {
            addCriterion("file_height >", value, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightGreaterThanOrEqualTo(String value) {
            addCriterion("file_height >=", value, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightLessThan(String value) {
            addCriterion("file_height <", value, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightLessThanOrEqualTo(String value) {
            addCriterion("file_height <=", value, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightLike(String value) {
            addCriterion("file_height like", value, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightNotLike(String value) {
            addCriterion("file_height not like", value, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightIn(List<String> values) {
            addCriterion("file_height in", values, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightNotIn(List<String> values) {
            addCriterion("file_height not in", values, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightBetween(String value1, String value2) {
            addCriterion("file_height between", value1, value2, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileHeightNotBetween(String value1, String value2) {
            addCriterion("file_height not between", value1, value2, "fileHeight");
            return (Criteria) this;
        }

        public Criteria andFileWidthIsNull() {
            addCriterion("file_width is null");
            return (Criteria) this;
        }

        public Criteria andFileWidthIsNotNull() {
            addCriterion("file_width is not null");
            return (Criteria) this;
        }

        public Criteria andFileWidthEqualTo(String value) {
            addCriterion("file_width =", value, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthNotEqualTo(String value) {
            addCriterion("file_width <>", value, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthGreaterThan(String value) {
            addCriterion("file_width >", value, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthGreaterThanOrEqualTo(String value) {
            addCriterion("file_width >=", value, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthLessThan(String value) {
            addCriterion("file_width <", value, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthLessThanOrEqualTo(String value) {
            addCriterion("file_width <=", value, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthLike(String value) {
            addCriterion("file_width like", value, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthNotLike(String value) {
            addCriterion("file_width not like", value, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthIn(List<String> values) {
            addCriterion("file_width in", values, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthNotIn(List<String> values) {
            addCriterion("file_width not in", values, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthBetween(String value1, String value2) {
            addCriterion("file_width between", value1, value2, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileWidthNotBetween(String value1, String value2) {
            addCriterion("file_width not between", value1, value2, "fileWidth");
            return (Criteria) this;
        }

        public Criteria andFileKeyIsNull() {
            addCriterion("file_key is null");
            return (Criteria) this;
        }

        public Criteria andFileKeyIsNotNull() {
            addCriterion("file_key is not null");
            return (Criteria) this;
        }

        public Criteria andFileKeyEqualTo(String value) {
            addCriterion("file_key =", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyNotEqualTo(String value) {
            addCriterion("file_key <>", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyGreaterThan(String value) {
            addCriterion("file_key >", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyGreaterThanOrEqualTo(String value) {
            addCriterion("file_key >=", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyLessThan(String value) {
            addCriterion("file_key <", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyLessThanOrEqualTo(String value) {
            addCriterion("file_key <=", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyLike(String value) {
            addCriterion("file_key like", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyNotLike(String value) {
            addCriterion("file_key not like", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyIn(List<String> values) {
            addCriterion("file_key in", values, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyNotIn(List<String> values) {
            addCriterion("file_key not in", values, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyBetween(String value1, String value2) {
            addCriterion("file_key between", value1, value2, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyNotBetween(String value1, String value2) {
            addCriterion("file_key not between", value1, value2, "fileKey");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileThemeIsNull() {
            addCriterion("file_theme is null");
            return (Criteria) this;
        }

        public Criteria andFileThemeIsNotNull() {
            addCriterion("file_theme is not null");
            return (Criteria) this;
        }

        public Criteria andFileThemeEqualTo(String value) {
            addCriterion("file_theme =", value, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeNotEqualTo(String value) {
            addCriterion("file_theme <>", value, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeGreaterThan(String value) {
            addCriterion("file_theme >", value, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeGreaterThanOrEqualTo(String value) {
            addCriterion("file_theme >=", value, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeLessThan(String value) {
            addCriterion("file_theme <", value, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeLessThanOrEqualTo(String value) {
            addCriterion("file_theme <=", value, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeLike(String value) {
            addCriterion("file_theme like", value, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeNotLike(String value) {
            addCriterion("file_theme not like", value, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeIn(List<String> values) {
            addCriterion("file_theme in", values, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeNotIn(List<String> values) {
            addCriterion("file_theme not in", values, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeBetween(String value1, String value2) {
            addCriterion("file_theme between", value1, value2, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andFileThemeNotBetween(String value1, String value2) {
            addCriterion("file_theme not between", value1, value2, "fileTheme");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andImgTypeIsNull() {
            addCriterion("img_type is null");
            return (Criteria) this;
        }

        public Criteria andImgTypeIsNotNull() {
            addCriterion("img_type is not null");
            return (Criteria) this;
        }

        public Criteria andImgTypeEqualTo(String value) {
            addCriterion("img_type =", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotEqualTo(String value) {
            addCriterion("img_type <>", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeGreaterThan(String value) {
            addCriterion("img_type >", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("img_type >=", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLessThan(String value) {
            addCriterion("img_type <", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLessThanOrEqualTo(String value) {
            addCriterion("img_type <=", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLike(String value) {
            addCriterion("img_type like", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotLike(String value) {
            addCriterion("img_type not like", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeIn(List<String> values) {
            addCriterion("img_type in", values, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotIn(List<String> values) {
            addCriterion("img_type not in", values, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeBetween(String value1, String value2) {
            addCriterion("img_type between", value1, value2, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotBetween(String value1, String value2) {
            addCriterion("img_type not between", value1, value2, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgDescIsNull() {
            addCriterion("img_desc is null");
            return (Criteria) this;
        }

        public Criteria andImgDescIsNotNull() {
            addCriterion("img_desc is not null");
            return (Criteria) this;
        }

        public Criteria andImgDescEqualTo(String value) {
            addCriterion("img_desc =", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotEqualTo(String value) {
            addCriterion("img_desc <>", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescGreaterThan(String value) {
            addCriterion("img_desc >", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescGreaterThanOrEqualTo(String value) {
            addCriterion("img_desc >=", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescLessThan(String value) {
            addCriterion("img_desc <", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescLessThanOrEqualTo(String value) {
            addCriterion("img_desc <=", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescLike(String value) {
            addCriterion("img_desc like", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotLike(String value) {
            addCriterion("img_desc not like", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescIn(List<String> values) {
            addCriterion("img_desc in", values, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotIn(List<String> values) {
            addCriterion("img_desc not in", values, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescBetween(String value1, String value2) {
            addCriterion("img_desc between", value1, value2, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotBetween(String value1, String value2) {
            addCriterion("img_desc not between", value1, value2, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgQualityIsNull() {
            addCriterion("img_quality is null");
            return (Criteria) this;
        }

        public Criteria andImgQualityIsNotNull() {
            addCriterion("img_quality is not null");
            return (Criteria) this;
        }

        public Criteria andImgQualityEqualTo(String value) {
            addCriterion("img_quality =", value, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityNotEqualTo(String value) {
            addCriterion("img_quality <>", value, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityGreaterThan(String value) {
            addCriterion("img_quality >", value, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityGreaterThanOrEqualTo(String value) {
            addCriterion("img_quality >=", value, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityLessThan(String value) {
            addCriterion("img_quality <", value, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityLessThanOrEqualTo(String value) {
            addCriterion("img_quality <=", value, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityLike(String value) {
            addCriterion("img_quality like", value, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityNotLike(String value) {
            addCriterion("img_quality not like", value, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityIn(List<String> values) {
            addCriterion("img_quality in", values, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityNotIn(List<String> values) {
            addCriterion("img_quality not in", values, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityBetween(String value1, String value2) {
            addCriterion("img_quality between", value1, value2, "imgQuality");
            return (Criteria) this;
        }

        public Criteria andImgQualityNotBetween(String value1, String value2) {
            addCriterion("img_quality not between", value1, value2, "imgQuality");
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