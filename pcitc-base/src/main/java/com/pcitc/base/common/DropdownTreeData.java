package com.pcitc.base.common;

import java.util.List;

public class DropdownTreeData 
{
	private String title = "";
	private String href = "#";
	private List<DropdownTreeDataProperties> dataAttrs;//包含属性列表
	private List<DropdownTreeData> data;//子节点
	
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<DropdownTreeDataProperties> getDataAttrs() {
		return dataAttrs;
	}
	public void setDataAttrs(List<DropdownTreeDataProperties> dataAttrs) {
		this.dataAttrs = dataAttrs;
	}
	public List<DropdownTreeData> getData() {
		return data;
	}
	public void setData(List<DropdownTreeData> data) {
		this.data = data;
	}
	
	
}
