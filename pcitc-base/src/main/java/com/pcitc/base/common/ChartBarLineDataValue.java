package com.pcitc.base.common;

public class ChartBarLineDataValue {
	
	private String    name;   
    private Object    value;
    private String    legendDataName;   
    
    private String    tav;   
    
    
    
    
    public String getTav() {
		return tav;
	}


	public void setTav(String tav) {
		this.tav = tav;
	}


	public String getLegendDataName() {
		return legendDataName; 
	}


	public void setLegendDataName(String legendDataName) {
		this.legendDataName = legendDataName;
	}


	public ChartBarLineDataValue(String legendDataName,String name, Object value) {
        this.name = name;
        this.value = value;
        this.legendDataName = legendDataName;
    }
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
    
	
    
    

}
