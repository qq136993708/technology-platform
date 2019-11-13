package com.pcitc.base.common;

public enum WorkFlowStatusEnum 
{
	STATUS_WAITING(0,"待审批"),
	STATUS_RUNNING(1,"审批中"),
	STATUS_PASS(2,"已通过"),
	STATUS_RETURN(-1,"审批驳回");
	private WorkFlowStatusEnum(Integer code, String desc) {
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
