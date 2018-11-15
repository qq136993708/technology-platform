package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class ChartBarLineSeries
{
	
	
	//指标名称
	private String name;
	//图标类型
	private String type;
	//数据
	private List<Object> data=new ArrayList<Object>();
	
	private Integer yAxisIndex;
	
	private String  stack;
	
	private Object  areaStyle;
	
	private String  color;
	private boolean smooth;
	
	
	
	public boolean isSmooth() {
		return smooth;
	}
	public void setSmooth(boolean smooth) {
		this.smooth = smooth;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStack() {
		return stack;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}
	public Object getAreaStyle() {
		return areaStyle;
	}
	public void setAreaStyle(Object areaStyle) {
		this.areaStyle = areaStyle;
	}
	public Integer getyAxisIndex() {
		return yAxisIndex;
	}
	public void setyAxisIndex(Integer yAxisIndex) {
		this.yAxisIndex = yAxisIndex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	

}
