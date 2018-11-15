package com.pcitc.common;

public enum AcceptStatusEnum 
{
	STATUS_WAITING(0,"待验收"),
	STATUS_REFUSE(-1,"未通过"),
	STATUS_PASS(1,"已通过");
	
	private AcceptStatusEnum(Integer code, String desc) {
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
