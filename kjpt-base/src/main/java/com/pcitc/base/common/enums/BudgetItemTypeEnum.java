package com.pcitc.base.common.enums;

/**
 * 预算项类别
 * @author fb
 *
 */
public enum BudgetItemTypeEnum {

	BUDGET_ITEM_PROJECT(1,"预算项"),
	BUDGET_ITEM_COMPANY(2,"预算项公司");
	
	private BudgetItemTypeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public static BudgetItemTypeEnum getTypeByCode(Integer code)
	{
		for(BudgetItemTypeEnum v:BudgetItemTypeEnum.values()) 
		{
			if(v.getCode().equals(code)) 
			{
				return v;
			}
		}
		return BUDGET_ITEM_PROJECT;
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
