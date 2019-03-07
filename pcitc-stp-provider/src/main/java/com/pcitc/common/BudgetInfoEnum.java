package com.pcitc.common;
/**
 * 预算表定义
 * @author fb
 *
 */
public enum BudgetInfoEnum 
{
	TOTAL(100,"预算总表（集团、资产、股份）"),
	GROUP_TOTAL(101,"预算表（集团公司）"),
	ASSETS_TOTAL(102,"预算表（资产公司）"),
	STOCK_TOTAL(103,"预算表（股份公司）");
	
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
