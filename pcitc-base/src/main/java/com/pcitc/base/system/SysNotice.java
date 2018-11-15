package com.pcitc.base.system;

import com.pcitc.base.util.DataTableInfo;

public class SysNotice extends DataTableInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9023735155187842907L;

	private String noticeId;

	private String noticeTitle;

	private String noticeSummary;

	private String noticeContent;

	private String noticeCreater;

	private String noticeCreatetime;

	private String noticeReceiver;

	private String noticeReceivernames;

	private String noticePublisher;

	private String noticePublishtime;

	private Integer isPublished;

	private Integer isVariable;

	private Integer userNoticeStatus;

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeSummary() {
		return noticeSummary;
	}

	public void setNoticeSummary(String noticeSummary) {
		this.noticeSummary = noticeSummary;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeCreater() {
		return noticeCreater;
	}

	public void setNoticeCreater(String noticeCreater) {
		this.noticeCreater = noticeCreater;
	}

	public String getNoticeCreatetime() {
		return noticeCreatetime;
	}

	public void setNoticeCreatetime(String noticeCreatetime) {
		this.noticeCreatetime = noticeCreatetime;
	}

	public String getNoticeReceiver() {
		return noticeReceiver;
	}

	public void setNoticeReceiver(String noticeReceiver) {
		this.noticeReceiver = noticeReceiver;
	}

	public String getNoticeReceivernames() {
		return noticeReceivernames;
	}

	public void setNoticeReceivernames(String noticeReceivernames) {
		this.noticeReceivernames = noticeReceivernames;
	}

	public String getNoticePublisher() {
		return noticePublisher;
	}

	public void setNoticePublisher(String noticePublisher) {
		this.noticePublisher = noticePublisher;
	}

	public String getNoticePublishtime() {
		return noticePublishtime;
	}

	public void setNoticePublishtime(String noticePublishtime) {
		this.noticePublishtime = noticePublishtime;
	}

	public Integer getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Integer isPublished) {
		this.isPublished = isPublished;
	}

	public Integer getIsVariable() {
		return isVariable;
	}

	public void setIsVariable(Integer isVariable) {
		this.isVariable = isVariable;
	}

	public Integer getUserNoticeStatus() {
		return userNoticeStatus;
	}

	public void setUserNoticeStatus(Integer userNoticeStatus) {
		this.userNoticeStatus = userNoticeStatus;
	}

}