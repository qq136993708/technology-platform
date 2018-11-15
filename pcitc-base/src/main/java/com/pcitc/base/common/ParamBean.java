package com.pcitc.base.common;

public class ParamBean implements java.io.Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5718803036237645690L;
	
	private String name;
	private String value;
	
	public ParamBean() {
		super();
	}
	public ParamBean(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
