package com.pcitc.base.common.enums;

public enum IntlExternalCheckStatusEnum {

	STATUS_STARTING(0,"协议谈判中"),
	STATUS_PASS(1,"协议达成"),
	STATUS_REFUSE(-1,"协议未达成");
	private IntlExternalCheckStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public static IntlExternalCheckStatusEnum getStatusByCode(Integer code)
	{
		for(IntlExternalCheckStatusEnum v:IntlExternalCheckStatusEnum.values()) 
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
