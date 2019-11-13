package com.pcitc.base.system.vo;

import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.system.SysUserProperty;

@SuppressWarnings("serial")
public class SysUserPropertyVo extends SysUserProperty{
	
	private String projectId;//项目
	
	private String projectCode;
	
	private String projectName;
		
	private List<SysUserProperty> properties;
	
	private String userIds;
	
	private List<String> userIdList;
	
	//当前页的数据 字符串
	private String currentPageDataId;
	
	//当前页 的数据集合
	private List<String> currentPageDataIdList;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<SysUserProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<SysUserProperty> properties) {
		this.properties = properties;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public List<String> getUserIdList() {
		return JSON.parseArray(userIds,String.class);
	}

	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}

	public String getCurrentPageDataId() {
		return currentPageDataId;
	}

	public void setCurrentPageDataId(String currentPageDataId) {
		this.currentPageDataId = currentPageDataId;
	}

	public List<String> getCurrentPageDataIdList() {
		return currentPageDataId==null?null:Arrays.asList(currentPageDataId.split(","));
	}

	public void setCurrentPageDataIdList(List<String> currentPageDataIdList) {
		this.currentPageDataIdList = currentPageDataIdList;
	}

	

}
