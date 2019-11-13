package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class ChartCircle {
	
	private String name;
	private	List<Child> children=new ArrayList<Child>();
	
	private ChartCircleItemStyle itemStyle;
	private String value;
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ChartCircleItemStyle getItemStyle() {
		return itemStyle;
	}
	public void setItemStyle(ChartCircleItemStyle itemStyle) {
		this.itemStyle = itemStyle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Child> getChildren() {
		return children;
	}
	public void setChildren(List<Child> children) {
		this.children = children;
	}
	
	
	

}
