package com.pcitc.base.common.enums;

public enum DelFlagEnum 
{
	STATUS_NORMAL(0,"正常"),
	STATUS_DEL(1,"删除");
	
	private DelFlagEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private Integer code;
	private String desc;

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


	
}
