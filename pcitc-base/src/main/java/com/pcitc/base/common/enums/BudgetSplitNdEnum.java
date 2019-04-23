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
	
	
	//集团公司一级分类
	TYPE_STOCK_2018("2018", BudgetSplitEnum.SPLIT_STOCK_YJY,BudgetSplitEnum.SPLIT_STOCK_FZGS,BudgetSplitEnum.SPLIT_STOCK_JTDW,BudgetSplitEnum.SPLIT_STOCK_WBDW,BudgetSplitEnum.SPLIT_STOCK_YK,BudgetSplitEnum.SPLIT_STOCK_XSD,BudgetSplitEnum.SPLIT_STOCK_ZD),
	TYPE_STOCK_2019("2019", BudgetSplitEnum.SPLIT_STOCK_YJY,BudgetSplitEnum.SPLIT_STOCK_FZGS,BudgetSplitEnum.SPLIT_STOCK_JTDW,BudgetSplitEnum.SPLIT_STOCK_WBDW,BudgetSplitEnum.SPLIT_STOCK_YK,BudgetSplitEnum.SPLIT_STOCK_XSD,BudgetSplitEnum.SPLIT_STOCK_ZD),
	TYPE_STOCK_2020("2020", BudgetSplitEnum.SPLIT_STOCK_YJY,BudgetSplitEnum.SPLIT_STOCK_FZGS,BudgetSplitEnum.SPLIT_STOCK_JTDW,BudgetSplitEnum.SPLIT_STOCK_WBDW,BudgetSplitEnum.SPLIT_STOCK_YK,BudgetSplitEnum.SPLIT_STOCK_XSD,BudgetSplitEnum.SPLIT_STOCK_ZD),
	
	//直属院
	SPLIT_STOCK_ZSY_2018("2018", BudgetSplitEnum.SPLIT_STOCK_YJY_KTY, BudgetSplitEnum.SPLIT_STOCK_YJY_GCY,BudgetSplitEnum.SPLIT_STOCK_YJY_WTY, BudgetSplitEnum.SPLIT_STOCK_YJY_SKY,BudgetSplitEnum.SPLIT_STOCK_YJY_FSY, BudgetSplitEnum.SPLIT_STOCK_YJY_BHY,BudgetSplitEnum.SPLIT_STOCK_YJY_SHY, BudgetSplitEnum.SPLIT_STOCK_YJY_AGY),
	SPLIT_STOCK_ZSY_2019("2019", BudgetSplitEnum.SPLIT_STOCK_YJY_KTY, BudgetSplitEnum.SPLIT_STOCK_YJY_GCY,BudgetSplitEnum.SPLIT_STOCK_YJY_WTY, BudgetSplitEnum.SPLIT_STOCK_YJY_SKY,BudgetSplitEnum.SPLIT_STOCK_YJY_FSY, BudgetSplitEnum.SPLIT_STOCK_YJY_BHY,BudgetSplitEnum.SPLIT_STOCK_YJY_SHY, BudgetSplitEnum.SPLIT_STOCK_YJY_AGY),
	SPLIT_STOCK_ZSY_2020("2020", BudgetSplitEnum.SPLIT_STOCK_YJY_KTY, BudgetSplitEnum.SPLIT_STOCK_YJY_GCY,BudgetSplitEnum.SPLIT_STOCK_YJY_WTY, BudgetSplitEnum.SPLIT_STOCK_YJY_SKY,BudgetSplitEnum.SPLIT_STOCK_YJY_FSY, BudgetSplitEnum.SPLIT_STOCK_YJY_BHY,BudgetSplitEnum.SPLIT_STOCK_YJY_SHY, BudgetSplitEnum.SPLIT_STOCK_YJY_AGY),
	//系统外
	SPLIT_STOCK_XTW_2018("2018", BudgetSplitEnum.SPLIT_STOCK_JTDW, BudgetSplitEnum.SPLIT_STOCK_WBDW,BudgetSplitEnum.SPLIT_STOCK_YK),
	SPLIT_STOCK_XTW_2019("2019", BudgetSplitEnum.SPLIT_STOCK_JTDW, BudgetSplitEnum.SPLIT_STOCK_WBDW,BudgetSplitEnum.SPLIT_STOCK_YK),
	SPLIT_STOCK_XTW_2020("2020", BudgetSplitEnum.SPLIT_STOCK_JTDW, BudgetSplitEnum.SPLIT_STOCK_WBDW,BudgetSplitEnum.SPLIT_STOCK_YK),
	
	//分子公司
	SPLIT_STOCK_ZGS_2018("2018", BudgetSplitEnum.SPLIT_STOCK_FZGS,BudgetSplitEnum.SPLIT_STOCK_XSD,BudgetSplitEnum.SPLIT_STOCK_ZD),
	SPLIT_STOCK_ZGS_2019("2019", BudgetSplitEnum.SPLIT_STOCK_FZGS,BudgetSplitEnum.SPLIT_STOCK_XSD,BudgetSplitEnum.SPLIT_STOCK_ZD),
	SPLIT_STOCK_ZGS_2020("2020", BudgetSplitEnum.SPLIT_STOCK_FZGS,BudgetSplitEnum.SPLIT_STOCK_XSD,BudgetSplitEnum.SPLIT_STOCK_ZD);
		
	
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
	//股份公司分类
	public static BudgetSplitNdEnum getStockTotalTypes(String nd)
	{
		for(BudgetSplitNdEnum v:BudgetSplitNdEnum.values()) 
		{
			if(v.name().contains("TYPE_STOCK") && v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return TYPE_STOCK_2018;
	}
	
	//直属院
	public static BudgetSplitNdEnum getStockSplitZsyByNd(String nd)
	{
		for(BudgetSplitNdEnum v:BudgetSplitNdEnum.values()) 
		{
			if(v.name().contains("SPLIT_STOCK_ZSY") && v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return SPLIT_STOCK_ZSY_2018;
	}
	public static BudgetSplitNdEnum getStockSplitXtwByNd(String nd)
	{
		for(BudgetSplitNdEnum v:BudgetSplitNdEnum.values()) 
		{
			if(v.name().contains("SPLIT_STOCK_XTW") && v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return SPLIT_STOCK_XTW_2018;
	}
	public static BudgetSplitNdEnum getStockSplitZgsByNd(String nd)
	{
		for(BudgetSplitNdEnum v:BudgetSplitNdEnum.values()) 
		{
			if(v.name().contains("SPLIT_STOCK_ZGS") && v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return SPLIT_STOCK_ZGS_2018;
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
