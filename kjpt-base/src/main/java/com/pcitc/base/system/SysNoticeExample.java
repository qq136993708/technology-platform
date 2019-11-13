package com.pcitc.base.system;

import java.util.ArrayList;
import java.util.List;

public class SysNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysNoticeExample() {
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

        public Criteria andNoticeIdIsNull() {
            addCriterion("notice_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNotNull() {
            addCriterion("notice_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdEqualTo(String value) {
            addCriterion("notice_id =", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotEqualTo(String value) {
            addCriterion("notice_id <>", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThan(String value) {
            addCriterion("notice_id >", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThanOrEqualTo(String value) {
            addCriterion("notice_id >=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThan(String value) {
            addCriterion("notice_id <", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThanOrEqualTo(String value) {
            addCriterion("notice_id <=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLike(String value) {
            addCriterion("notice_id like", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotLike(String value) {
            addCriterion("notice_id not like", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIn(List<String> values) {
            addCriterion("notice_id in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotIn(List<String> values) {
            addCriterion("notice_id not in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdBetween(String value1, String value2) {
            addCriterion("notice_id between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotBetween(String value1, String value2) {
            addCriterion("notice_id not between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNull() {
            addCriterion("notice_title is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNotNull() {
            addCriterion("notice_title is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleEqualTo(String value) {
            addCriterion("notice_title =", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotEqualTo(String value) {
            addCriterion("notice_title <>", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThan(String value) {
            addCriterion("notice_title >", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("notice_title >=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThan(String value) {
            addCriterion("notice_title <", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThanOrEqualTo(String value) {
            addCriterion("notice_title <=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLike(String value) {
            addCriterion("notice_title like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotLike(String value) {
            addCriterion("notice_title not like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIn(List<String> values) {
            addCriterion("notice_title in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotIn(List<String> values) {
            addCriterion("notice_title not in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleBetween(String value1, String value2) {
            addCriterion("notice_title between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotBetween(String value1, String value2) {
            addCriterion("notice_title not between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryIsNull() {
            addCriterion("notice_summary is null");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryIsNotNull() {
            addCriterion("notice_summary is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryEqualTo(String value) {
            addCriterion("notice_summary =", value, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryNotEqualTo(String value) {
            addCriterion("notice_summary <>", value, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryGreaterThan(String value) {
            addCriterion("notice_summary >", value, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("notice_summary >=", value, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryLessThan(String value) {
            addCriterion("notice_summary <", value, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryLessThanOrEqualTo(String value) {
            addCriterion("notice_summary <=", value, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryLike(String value) {
            addCriterion("notice_summary like", value, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryNotLike(String value) {
            addCriterion("notice_summary not like", value, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryIn(List<String> values) {
            addCriterion("notice_summary in", values, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryNotIn(List<String> values) {
            addCriterion("notice_summary not in", values, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryBetween(String value1, String value2) {
            addCriterion("notice_summary between", value1, value2, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeSummaryNotBetween(String value1, String value2) {
            addCriterion("notice_summary not between", value1, value2, "noticeSummary");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNull() {
            addCriterion("notice_content is null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNotNull() {
            addCriterion("notice_content is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentEqualTo(String value) {
            addCriterion("notice_content =", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotEqualTo(String value) {
            addCriterion("notice_content <>", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThan(String value) {
            addCriterion("notice_content >", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThanOrEqualTo(String value) {
            addCriterion("notice_content >=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThan(String value) {
            addCriterion("notice_content <", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThanOrEqualTo(String value) {
            addCriterion("notice_content <=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLike(String value) {
            addCriterion("notice_content like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotLike(String value) {
            addCriterion("notice_content not like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIn(List<String> values) {
            addCriterion("notice_content in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotIn(List<String> values) {
            addCriterion("notice_content not in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentBetween(String value1, String value2) {
            addCriterion("notice_content between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotBetween(String value1, String value2) {
            addCriterion("notice_content not between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterIsNull() {
            addCriterion("notice_creater is null");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterIsNotNull() {
            addCriterion("notice_creater is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterEqualTo(String value) {
            addCriterion("notice_creater =", value, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterNotEqualTo(String value) {
            addCriterion("notice_creater <>", value, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterGreaterThan(String value) {
            addCriterion("notice_creater >", value, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("notice_creater >=", value, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterLessThan(String value) {
            addCriterion("notice_creater <", value, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterLessThanOrEqualTo(String value) {
            addCriterion("notice_creater <=", value, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterLike(String value) {
            addCriterion("notice_creater like", value, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterNotLike(String value) {
            addCriterion("notice_creater not like", value, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterIn(List<String> values) {
            addCriterion("notice_creater in", values, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterNotIn(List<String> values) {
            addCriterion("notice_creater not in", values, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterBetween(String value1, String value2) {
            addCriterion("notice_creater between", value1, value2, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreaterNotBetween(String value1, String value2) {
            addCriterion("notice_creater not between", value1, value2, "noticeCreater");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeIsNull() {
            addCriterion("notice_createtime is null");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeIsNotNull() {
            addCriterion("notice_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeEqualTo(String value) {
            addCriterion("notice_createtime =", value, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeNotEqualTo(String value) {
            addCriterion("notice_createtime <>", value, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeGreaterThan(String value) {
            addCriterion("notice_createtime >", value, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("notice_createtime >=", value, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeLessThan(String value) {
            addCriterion("notice_createtime <", value, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("notice_createtime <=", value, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeLike(String value) {
            addCriterion("notice_createtime like", value, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeNotLike(String value) {
            addCriterion("notice_createtime not like", value, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeIn(List<String> values) {
            addCriterion("notice_createtime in", values, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeNotIn(List<String> values) {
            addCriterion("notice_createtime not in", values, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeBetween(String value1, String value2) {
            addCriterion("notice_createtime between", value1, value2, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeCreatetimeNotBetween(String value1, String value2) {
            addCriterion("notice_createtime not between", value1, value2, "noticeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverIsNull() {
            addCriterion("notice_receiver is null");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverIsNotNull() {
            addCriterion("notice_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverEqualTo(String value) {
            addCriterion("notice_receiver =", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverNotEqualTo(String value) {
            addCriterion("notice_receiver <>", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverGreaterThan(String value) {
            addCriterion("notice_receiver >", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("notice_receiver >=", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverLessThan(String value) {
            addCriterion("notice_receiver <", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverLessThanOrEqualTo(String value) {
            addCriterion("notice_receiver <=", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverLike(String value) {
            addCriterion("notice_receiver like", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverNotLike(String value) {
            addCriterion("notice_receiver not like", value, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverIn(List<String> values) {
            addCriterion("notice_receiver in", values, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverNotIn(List<String> values) {
            addCriterion("notice_receiver not in", values, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverBetween(String value1, String value2) {
            addCriterion("notice_receiver between", value1, value2, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceiverNotBetween(String value1, String value2) {
            addCriterion("notice_receiver not between", value1, value2, "noticeReceiver");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesIsNull() {
            addCriterion("notice_receiverNames is null");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesIsNotNull() {
            addCriterion("notice_receiverNames is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesEqualTo(String value) {
            addCriterion("notice_receiverNames =", value, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesNotEqualTo(String value) {
            addCriterion("notice_receiverNames <>", value, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesGreaterThan(String value) {
            addCriterion("notice_receiverNames >", value, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesGreaterThanOrEqualTo(String value) {
            addCriterion("notice_receiverNames >=", value, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesLessThan(String value) {
            addCriterion("notice_receiverNames <", value, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesLessThanOrEqualTo(String value) {
            addCriterion("notice_receiverNames <=", value, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesLike(String value) {
            addCriterion("notice_receiverNames like", value, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesNotLike(String value) {
            addCriterion("notice_receiverNames not like", value, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesIn(List<String> values) {
            addCriterion("notice_receiverNames in", values, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesNotIn(List<String> values) {
            addCriterion("notice_receiverNames not in", values, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesBetween(String value1, String value2) {
            addCriterion("notice_receiverNames between", value1, value2, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticeReceivernamesNotBetween(String value1, String value2) {
            addCriterion("notice_receiverNames not between", value1, value2, "noticeReceivernames");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherIsNull() {
            addCriterion("notice_publisher is null");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherIsNotNull() {
            addCriterion("notice_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherEqualTo(String value) {
            addCriterion("notice_publisher =", value, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherNotEqualTo(String value) {
            addCriterion("notice_publisher <>", value, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherGreaterThan(String value) {
            addCriterion("notice_publisher >", value, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherGreaterThanOrEqualTo(String value) {
            addCriterion("notice_publisher >=", value, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherLessThan(String value) {
            addCriterion("notice_publisher <", value, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherLessThanOrEqualTo(String value) {
            addCriterion("notice_publisher <=", value, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherLike(String value) {
            addCriterion("notice_publisher like", value, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherNotLike(String value) {
            addCriterion("notice_publisher not like", value, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherIn(List<String> values) {
            addCriterion("notice_publisher in", values, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherNotIn(List<String> values) {
            addCriterion("notice_publisher not in", values, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherBetween(String value1, String value2) {
            addCriterion("notice_publisher between", value1, value2, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublisherNotBetween(String value1, String value2) {
            addCriterion("notice_publisher not between", value1, value2, "noticePublisher");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeIsNull() {
            addCriterion("notice_publishtime is null");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeIsNotNull() {
            addCriterion("notice_publishtime is not null");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeEqualTo(String value) {
            addCriterion("notice_publishtime =", value, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeNotEqualTo(String value) {
            addCriterion("notice_publishtime <>", value, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeGreaterThan(String value) {
            addCriterion("notice_publishtime >", value, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("notice_publishtime >=", value, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeLessThan(String value) {
            addCriterion("notice_publishtime <", value, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeLessThanOrEqualTo(String value) {
            addCriterion("notice_publishtime <=", value, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeLike(String value) {
            addCriterion("notice_publishtime like", value, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeNotLike(String value) {
            addCriterion("notice_publishtime not like", value, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeIn(List<String> values) {
            addCriterion("notice_publishtime in", values, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeNotIn(List<String> values) {
            addCriterion("notice_publishtime not in", values, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeBetween(String value1, String value2) {
            addCriterion("notice_publishtime between", value1, value2, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andNoticePublishtimeNotBetween(String value1, String value2) {
            addCriterion("notice_publishtime not between", value1, value2, "noticePublishtime");
            return (Criteria) this;
        }

        public Criteria andIsPublishedIsNull() {
            addCriterion("is_published is null");
            return (Criteria) this;
        }

        public Criteria andIsPublishedIsNotNull() {
            addCriterion("is_published is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublishedEqualTo(Integer value) {
            addCriterion("is_published =", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotEqualTo(Integer value) {
            addCriterion("is_published <>", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedGreaterThan(Integer value) {
            addCriterion("is_published >", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_published >=", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedLessThan(Integer value) {
            addCriterion("is_published <", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedLessThanOrEqualTo(Integer value) {
            addCriterion("is_published <=", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedIn(List<Integer> values) {
            addCriterion("is_published in", values, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotIn(List<Integer> values) {
            addCriterion("is_published not in", values, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedBetween(Integer value1, Integer value2) {
            addCriterion("is_published between", value1, value2, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_published not between", value1, value2, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsVariableIsNull() {
            addCriterion("is_variable is null");
            return (Criteria) this;
        }

        public Criteria andIsVariableIsNotNull() {
            addCriterion("is_variable is not null");
            return (Criteria) this;
        }

        public Criteria andIsVariableEqualTo(Integer value) {
            addCriterion("is_variable =", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableNotEqualTo(Integer value) {
            addCriterion("is_variable <>", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableGreaterThan(Integer value) {
            addCriterion("is_variable >", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_variable >=", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableLessThan(Integer value) {
            addCriterion("is_variable <", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableLessThanOrEqualTo(Integer value) {
            addCriterion("is_variable <=", value, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableIn(List<Integer> values) {
            addCriterion("is_variable in", values, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableNotIn(List<Integer> values) {
            addCriterion("is_variable not in", values, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableBetween(Integer value1, Integer value2) {
            addCriterion("is_variable between", value1, value2, "isVariable");
            return (Criteria) this;
        }

        public Criteria andIsVariableNotBetween(Integer value1, Integer value2) {
            addCriterion("is_variable not between", value1, value2, "isVariable");
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