package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class Child {
	
	
	private String name;
	private String value;
	private	List<NameValue> children=new ArrayList<NameValue>();
	
	private ChartCircleItemStyle itemStyle;
	
	
	
	

	public ChartCircleItemStyle getItemStyle() {
		return itemStyle;
	}

	public void setItemStyle(ChartCircleItemStyle itemStyle) {
		this.itemStyle = itemStyle;
	}

	public List<NameValue> getChildren() {
		return children;
	}

	public void setChildren(List<NameValue> children) {
		this.children = children;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
