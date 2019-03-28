package com.pcitc.common;
/**
 * 预算分解
 * @author uuy
 *
 */
public enum BudgetSplitEnum 
{
	SPLIT_GROUP_YF(101,"油服"),
	SPLIT_GROUP_JX(102,"机械"),
	SPLIT_GROUP_QT(103,"其他"),
	
	SPLIT_ASSET_LY(201,"资产部"),
	SPLIT_ASSET_HG(202,"化工部"),
		
	SPLIT_STOCK_YJY(301,"股份付直属院"),
	SPLIT_STOCK_YJY_KTY(3011,"勘探院"),
	SPLIT_STOCK_YJY_GCY(3012,"工程院"),
	SPLIT_STOCK_YJY_WTY(3013,"物探院"),
	SPLIT_STOCK_YJY_SKY(3014,"石科院"),
	SPLIT_STOCK_YJY_FSY(3015,"抚顺院"),
	SPLIT_STOCK_YJY_BHY(3016,"北化院"),
	SPLIT_STOCK_YJY_SHY(3017,"上海院"),
	SPLIT_STOCK_YJY_AGY(3018,"安工院"),
	SPLIT_STOCK_FZGS(302,"股份付分子公司"),
	SPLIT_STOCK_JTDW(303,"股份付集团单位"),
	SPLIT_STOCK_WBDW(304,"股份付外部单位"),
	SPLIT_STOCK_YK(305,"股份付盈科"),
	SPLIT_STOCK_XSD(306,"股份付休斯顿"),
	SPLIT_STOCK_ZD(307,"股份付中东");						
	
	
	private BudgetSplitEnum(Integer code, String desc) {
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
