package com.pcitc.base.common.enums;

import java.util.ArrayList;
import java.util.List;
/**
 * 年度預算分配項目
 * @author uuy
 *
 */
public enum BudgetSplitNdEnum 
{
	//集团分解
	SPLIT_GROUP_2018("2018",BudgetSplitEnum.SPLIT_GROUP_YF,BudgetSplitEnum.SPLIT_GROUP_JX,BudgetSplitEnum.SPLIT_GROUP_QT),
	SPLIT_GROUP_2019("2019",BudgetSplitEnum.SPLIT_GROUP_YF,BudgetSplitEnum.SPLIT_GROUP_JX,BudgetSplitEnum.SPLIT_GROUP_QT),
	SPLIT_GROUP_2020("2020",BudgetSplitEnum.SPLIT_GROUP_YF,BudgetSplitEnum.SPLIT_GROUP_JX,BudgetSplitEnum.SPLIT_GROUP_QT),
	//资产分解
	SPLIT_ASSET_2018("2018",BudgetSplitEnum.SPLIT_ASSET_LY,BudgetSplitEnum.SPLIT_ASSET_HG),
	SPLIT_ASSET_2019("2019",BudgetSplitEnum.SPLIT_ASSET_LY,BudgetSplitEnum.SPLIT_ASSET_HG),
	SPLIT_ASSET_2020("2020",BudgetSplitEnum.SPLIT_ASSET_LY,BudgetSplitEnum.SPLIT_ASSET_HG),
	
	
	
	SPLIT_2018("2018",BudgetSplitEnum.SPLIT_GROUP_YF,BudgetSplitEnum.SPLIT_GROUP_JX,BudgetSplitEnum.SPLIT_GROUP_QT,BudgetSplitEnum.SPLIT_ASSET_LY,BudgetSplitEnum.SPLIT_ASSET_HG,BudgetSplitEnum.SPLIT_STOCK_YJY,BudgetSplitEnum.SPLIT_STOCK_FZGS,BudgetSplitEnum.SPLIT_STOCK_JTDW,BudgetSplitEnum.SPLIT_STOCK_WBDW,BudgetSplitEnum.SPLIT_STOCK_YK,BudgetSplitEnum.SPLIT_STOCK_XSD,BudgetSplitEnum.SPLIT_STOCK_ZD,BudgetSplitEnum.SPLIT_STOCK_YJY_KTY,BudgetSplitEnum.SPLIT_STOCK_YJY_GCY,BudgetSplitEnum.SPLIT_STOCK_YJY_WTY,BudgetSplitEnum.SPLIT_STOCK_YJY_SKY,BudgetSplitEnum.SPLIT_STOCK_YJY_FSY,BudgetSplitEnum.SPLIT_STOCK_YJY_BHY,BudgetSplitEnum.SPLIT_STOCK_YJY_SHY,BudgetSplitEnum.SPLIT_STOCK_YJY_AGY),
	SPLIT_2019("2019",BudgetSplitEnum.SPLIT_GROUP_YF,BudgetSplitEnum.SPLIT_GROUP_JX,BudgetSplitEnum.SPLIT_GROUP_QT,BudgetSplitEnum.SPLIT_ASSET_LY,BudgetSplitEnum.SPLIT_ASSET_HG,BudgetSplitEnum.SPLIT_STOCK_YJY,BudgetSplitEnum.SPLIT_STOCK_FZGS,BudgetSplitEnum.SPLIT_STOCK_JTDW,BudgetSplitEnum.SPLIT_STOCK_WBDW,BudgetSplitEnum.SPLIT_STOCK_YK,BudgetSplitEnum.SPLIT_STOCK_XSD,BudgetSplitEnum.SPLIT_STOCK_ZD,BudgetSplitEnum.SPLIT_STOCK_YJY_KTY,BudgetSplitEnum.SPLIT_STOCK_YJY_GCY,BudgetSplitEnum.SPLIT_STOCK_YJY_WTY,BudgetSplitEnum.SPLIT_STOCK_YJY_SKY,BudgetSplitEnum.SPLIT_STOCK_YJY_FSY,BudgetSplitEnum.SPLIT_STOCK_YJY_BHY,BudgetSplitEnum.SPLIT_STOCK_YJY_SHY,BudgetSplitEnum.SPLIT_STOCK_YJY_AGY),
	SPLIT_2020("2020",BudgetSplitEnum.SPLIT_GROUP_YF,BudgetSplitEnum.SPLIT_GROUP_JX,BudgetSplitEnum.SPLIT_GROUP_QT,BudgetSplitEnum.SPLIT_ASSET_LY,BudgetSplitEnum.SPLIT_ASSET_HG,BudgetSplitEnum.SPLIT_STOCK_YJY,BudgetSplitEnum.SPLIT_STOCK_FZGS,BudgetSplitEnum.SPLIT_STOCK_JTDW,BudgetSplitEnum.SPLIT_STOCK_WBDW,BudgetSplitEnum.SPLIT_STOCK_YK,BudgetSplitEnum.SPLIT_STOCK_XSD,BudgetSplitEnum.SPLIT_STOCK_ZD,BudgetSplitEnum.SPLIT_STOCK_YJY_KTY,BudgetSplitEnum.SPLIT_STOCK_YJY_GCY,BudgetSplitEnum.SPLIT_STOCK_YJY_WTY,BudgetSplitEnum.SPLIT_STOCK_YJY_SKY,BudgetSplitEnum.SPLIT_STOCK_YJY_FSY,BudgetSplitEnum.SPLIT_STOCK_YJY_BHY,BudgetSplitEnum.SPLIT_STOCK_YJY_SHY,BudgetSplitEnum.SPLIT_STOCK_YJY_AGY);
	
	private BudgetSplitNdEnum(String nd,BudgetSplitEnum ... splitList) 
	{
		this.nd = nd;
		this.splits = new ArrayList<>();
		if(splitList != null) {
			for(BudgetSplitEnum split:splitList) {
				this.splits.add(split);
			}
		}
	}
	public static BudgetSplitNdEnum getSplitByNd(String nd)
	{
		for(BudgetSplitNdEnum v:BudgetSplitNdEnum.values()) 
		{
			if(v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return SPLIT_2018;
	}
	
	
	private String nd;
	private List<BudgetSplitEnum> splits;
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public List<BudgetSplitEnum> getSplits() {
		return splits;
	}
	public void setSplits(List<BudgetSplitEnum> splits) {
		this.splits = splits;
	}
}
