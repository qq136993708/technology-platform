package com.pcitc.base.common;

import com.alibaba.fastjson.annotation.JSONField;

public class ChartPieDataValue {
	
	@JSONField(ordinal=1)
	private Object    value;
	
	@JSONField(ordinal=2)
	private String    name;   

	public ChartPieDataValue( Object value, String name) {
		this.value = value;
        this.name = name;
        
    }

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    

}
