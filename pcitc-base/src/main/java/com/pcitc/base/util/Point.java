package com.pcitc.base.util;

public class Point 
{
	private Integer rowIndex;//行号
	private Integer colIndex;//列号
	
	public Point() {
		super();
	}
	public Point(Integer rowIndex, Integer colIndex) {
		super();
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}
	public Integer getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}
	public Integer getColIndex() {
		return colIndex;
	}
	public void setColIndex(Integer colIndex) {
		this.colIndex = colIndex;
	}
	@Override
	public String toString() {
		return this.rowIndex+"_"+this.colIndex;
	}
	
}
