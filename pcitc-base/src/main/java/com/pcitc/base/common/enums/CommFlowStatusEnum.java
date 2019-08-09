package com.pcitc.base.common.enums;

public enum CommFlowStatusEnum {

	STATUS_NO_START(0,"未提交"),
	STATUS_START(1,"审批中"),
	STATUS_REFUSE(-1,"审批驳回"),
	STATUS_PASS(2,"审批通过");
	
	private CommFlowStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
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
