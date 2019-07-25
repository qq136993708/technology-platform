package com.pcitc.base.common.enums;
/**
 * 预算表定义
 * @author fb
 *
 */
public enum BudgetInfoEnum 
{
	TOTAL(100,"预算总表（集团、资产、股份）"),
	GROUP_TOTAL(101,"集团公司预算表"),
	ASSETS_TOTAL(102,"资产公司预算表"),
	STOCK_TOTAL(103,"股份公司预算表"),
	
	ITEM_TOTAL(200,"预算分解表总表"),
	B2C_SPLIT(201,"预算分解表（炼油、化工事业部预算）"),
	TECH_SPLIT(202,"预算分解表（专项预算）"),
	GROUP_SPLIT(203,"集团公司预算分解表"),
	ASSET_SPLIT(204,"资产公司预算分解表"),
	STOCK_ZSY_SPLIT(205,"股份公司预算分解表（直属院）"),
	STOCK_XTY_SPLIT(206,"股份公司预算分解表（集团单位、外部单位、盈科）"),
	STOCK_ZGS_SPLIT(207,"股份公司预算分解表（分子公司等）");
	
	public static BudgetInfoEnum getByCode(Integer code) 
	{
		for(BudgetInfoEnum v:BudgetInfoEnum.values()) 
		{
			if(v.getCode().equals(code)) 
			{
				return v;
			}
		}
		return TOTAL;
	}
	
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
