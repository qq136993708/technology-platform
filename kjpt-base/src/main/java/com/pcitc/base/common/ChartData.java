package com.pcitc.base.common;

public class ChartData {
	
	
	private String name;    //类别名称
    private int    value;   //销量
    
    
    public ChartData(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

    
    
}
