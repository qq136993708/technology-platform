package com.pcitc.common;
/**
 * 预算表定义
 * @author fb
 *
 */
public enum BudgetInfoEnum 
{
	GROUP_TOTAL(1,"预算表（集团公司）"),
	ASSETS_TOTAL(2,"预算表（资产公司）"),
	STOCK_TOTAL(3,"预算表（股份公司）");
	
	private BudgetInfoEnum(Integer code, String desc) {
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
