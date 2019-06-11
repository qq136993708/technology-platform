package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class ChartCircle2 {
	
	private String name;
	private	List<Child2> children=new ArrayList<Child2>();
	private ChartCircleItemStyle itemStyle;
	private Object value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Child2> getChildren() {
		return children;
	}
	public void setChildren(List<Child2> children) {
		this.children = children;
	}
	public ChartCircleItemStyle getItemStyle() {
		return itemStyle;
	}
	public void setItemStyle(ChartCircleItemStyle itemStyle) {
		this.itemStyle = itemStyle;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	
	
	
	
	
	
	

}
