package com.pcitc.base.system;

import java.util.Date;

import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.SearchInfo;

/**
 * DataTable参数传递 的扩展
 * 
 * @author ms
 *
 */
public class SysNoticeVo extends SearchInfo {

	private String noticeId;

	private String noticeTitle;

	private String noticeContent;

	private String noticeCreater;

	private String noticeReceiver;

	private String noticeCreatetime;

	private Date noticePublishtime;

	private Integer isPublished;

	private Integer isVariable;

	private Integer userNoticeStatus;

	private String userId;

	private DataTableInfoVo dataTableInfoVo;

	private String page;

	private String limit;

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

	public String getNoticeReceiver() {
		return noticeReceiver;
	}

	public void setNoticeReceiver(String noticeReceiver) {
		this.noticeReceiver = noticeReceiver;
	}

	public String getNoticeCreatetime() {
		return noticeCreatetime;
	}

	public void setNoticeCreatetime(String noticeCreatetime) {
		this.noticeCreatetime = noticeCreatetime;
	}

	public Date getNoticePublishtime() {
		return noticePublishtime;
	}

	public void setNoticePublishtime(Date noticePublishtime) {
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

	public DataTableInfoVo getDataTableInfoVo() {
		return dataTableInfoVo;
	}

	public void setDataTableInfoVo(DataTableInfoVo dataTableInfoVo) {
		this.dataTableInfoVo = dataTableInfoVo;
	}

	public Integer getUserNoticeStatus() {
		return userNoticeStatus;
	}

	public void setUserNoticeStatus(Integer userNoticeStatus) {
		this.userNoticeStatus = userNoticeStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

}
