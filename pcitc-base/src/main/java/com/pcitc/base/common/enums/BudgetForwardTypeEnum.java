package com.pcitc.base.common.enums;
/**
 *  
 * @author fb
 *
 */
public enum BudgetForwardTypeEnum 
{
	TYPE_STOCK(1,"A","A股份公司"),
	TYPE_GROUP(2,"B","B集团公司"),
	TYPE_ASSET(3,"C","C资产公司");
	
	public static BudgetForwardTypeEnum getByCode(Integer code) 
	{
		for(BudgetForwardTypeEnum v:BudgetForwardTypeEnum.values()) 
		{
			if(v.getCode().equals(code)) 
			{
				return v;
			}
		}
		return null;
	}
	
	private BudgetForwardTypeEnum(Integer code, String type,String name) {
		this.code = code;
		this.name = name;
		this.type = type;
	}

	private Integer code;
	private String type;
	private String name;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
