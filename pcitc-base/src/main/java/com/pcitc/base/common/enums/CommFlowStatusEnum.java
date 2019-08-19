package com.pcitc.base.common.enums;

public enum CommFlowStatusEnum {

	STATUS_NO_START(0,"未提交","#5FB878"),
	STATUS_STARTING(1,"审核中","#FFB800"),
	STATUS_REFUSE(-1,"已驳回","#1E9FFF"),
	STATUS_PASS(2,"已通过","#1E9FFF");
	
	private CommFlowStatusEnum(Integer code, String desc,String color) {
		this.code = code;
		this.desc = desc;
		this.color = color;
	}
	public static CommFlowStatusEnum getStatusByCode(Integer code)
	{
		for(CommFlowStatusEnum v:CommFlowStatusEnum.values()) 
		{
			if(v.getCode().equals(code)) 
			{
				return v;
			}
		}
		return null;
	}

	private Integer code;
	private String desc;
	private String color;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
