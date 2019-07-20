package com.pcitc.base.common.enums;
/**
 *  
 * @author fb
 *
 */
public enum BudgetReleaseEnum 
{
	STATUS_RELEASE(1,"已下发"),
	STATUS_NORELEASE(0,"未下发");
	
	public static BudgetReleaseEnum getByCode(Integer code) 
	{
		for(BudgetReleaseEnum v:BudgetReleaseEnum.values()) 
		{
			if(v.getCode().equals(code)) 
			{
				return v;
			}
		}
		return STATUS_RELEASE;
	}
	
	private BudgetReleaseEnum(Integer code, String desc) {
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
