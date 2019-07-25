package com.pcitc.base.common.enums;
/**
 * 预算表定义
 * @author fb
 *
 */
public enum BudgetInfoEnum 
{
	TOTAL(100,"预算总表（集团、资产、股份）","/budget/budget_main_total"),
	GROUP_TOTAL(101,"集团公司预算表","/budget/budget_main_grouptotal"),
	ASSETS_TOTAL(102,"资产公司预算表","/budget/budget_main_assettotal"),
	STOCK_TOTAL(103,"股份公司预算表","/budget/budget_main_stocktotal"),
	
	ITEM_TOTAL(200,"预算分解表总表","/budget/budget_main_totalsplit"),
	B2C_SPLIT(201,"预算分解表（炼油、化工事业部预算）","/budget/budget_main_b2csplit"),
	TECH_SPLIT(202,"预算分解表（专项预算）","/budget/budget_main_techsplit"),
	GROUP_SPLIT(203,"集团公司预算分解表","/budget/budget_main_groupsplit"),
	ASSET_SPLIT(204,"资产公司预算分解表","/budget/budget_main_assetsplit"),
	STOCK_ZSY_SPLIT(205,"股份公司预算分解表（直属院）","/budget/budget_main_stocksplit_zsy"),
	STOCK_XTY_SPLIT(206,"股份公司预算分解表（集团单位、外部单位、盈科）","/budget/budget_main_stocksplit_xtw"),
	STOCK_ZGS_SPLIT(207,"股份公司预算分解表（分子公司等）","/budget/budget_main_stocksplit_zgs");
	
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
	
	private BudgetInfoEnum(Integer code, String desc,String mainUrl) {
		this.code = code;
		this.desc = desc;
		this.mainUrl = mainUrl;
	}

	private Integer code;
	private String desc;
	private String mainUrl;

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

	public String getMainUrl() {
		return mainUrl;
	}

	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}
	
}
