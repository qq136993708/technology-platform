package com.pcitc.base.common.enums;

import java.util.ArrayList;
import java.util.List;
/**
 * 年度預算分配項目
 * @author uuy
 *
 */
public enum BudgetStockNdEnum 
{
	
	//集团公司一级分类
	TYPE_STOCK_2018("2018", BudgetStockEnum.SPLIT_STOCK_YJY,BudgetStockEnum.SPLIT_STOCK_YJY_KTY, BudgetStockEnum.SPLIT_STOCK_YJY_GCY,BudgetStockEnum.SPLIT_STOCK_YJY_WTY, BudgetStockEnum.SPLIT_STOCK_YJY_SKY,BudgetStockEnum.SPLIT_STOCK_YJY_FSY, BudgetStockEnum.SPLIT_STOCK_YJY_BHY,BudgetStockEnum.SPLIT_STOCK_YJY_SHY, BudgetStockEnum.SPLIT_STOCK_YJY_AGY,BudgetStockEnum.SPLIT_STOCK_FZGS,BudgetStockEnum.SPLIT_STOCK_JTDW,BudgetStockEnum.SPLIT_STOCK_WBDW,BudgetStockEnum.SPLIT_STOCK_YK,BudgetStockEnum.SPLIT_STOCK_XSD,BudgetStockEnum.SPLIT_STOCK_ZD),
	TYPE_STOCK_2019("2019", BudgetStockEnum.SPLIT_STOCK_YJY,BudgetStockEnum.SPLIT_STOCK_YJY_KTY, BudgetStockEnum.SPLIT_STOCK_YJY_GCY,BudgetStockEnum.SPLIT_STOCK_YJY_WTY, BudgetStockEnum.SPLIT_STOCK_YJY_SKY,BudgetStockEnum.SPLIT_STOCK_YJY_FSY, BudgetStockEnum.SPLIT_STOCK_YJY_BHY,BudgetStockEnum.SPLIT_STOCK_YJY_SHY, BudgetStockEnum.SPLIT_STOCK_YJY_AGY,BudgetStockEnum.SPLIT_STOCK_FZGS,BudgetStockEnum.SPLIT_STOCK_JTDW,BudgetStockEnum.SPLIT_STOCK_WBDW,BudgetStockEnum.SPLIT_STOCK_YK,BudgetStockEnum.SPLIT_STOCK_XSD,BudgetStockEnum.SPLIT_STOCK_ZD,BudgetStockEnum.SPLIT_STOCK_MYSGZS),
	TYPE_STOCK_2020("2020", BudgetStockEnum.SPLIT_STOCK_YJY,BudgetStockEnum.SPLIT_STOCK_YJY_KTY, BudgetStockEnum.SPLIT_STOCK_YJY_GCY,BudgetStockEnum.SPLIT_STOCK_YJY_WTY, BudgetStockEnum.SPLIT_STOCK_YJY_SKY,BudgetStockEnum.SPLIT_STOCK_YJY_FSY, BudgetStockEnum.SPLIT_STOCK_YJY_BHY,BudgetStockEnum.SPLIT_STOCK_YJY_SHY, BudgetStockEnum.SPLIT_STOCK_YJY_AGY,BudgetStockEnum.SPLIT_STOCK_FZGS,BudgetStockEnum.SPLIT_STOCK_JTDW,BudgetStockEnum.SPLIT_STOCK_WBDW,BudgetStockEnum.SPLIT_STOCK_YK,BudgetStockEnum.SPLIT_STOCK_XSD,BudgetStockEnum.SPLIT_STOCK_ZD),
	
	//直属院
	SPLIT_STOCK_ZSY_2018("2018", BudgetStockEnum.SPLIT_STOCK_YJY_KTY, BudgetStockEnum.SPLIT_STOCK_YJY_GCY,BudgetStockEnum.SPLIT_STOCK_YJY_WTY, BudgetStockEnum.SPLIT_STOCK_YJY_SKY,BudgetStockEnum.SPLIT_STOCK_YJY_FSY, BudgetStockEnum.SPLIT_STOCK_YJY_BHY,BudgetStockEnum.SPLIT_STOCK_YJY_SHY, BudgetStockEnum.SPLIT_STOCK_YJY_AGY),
	SPLIT_STOCK_ZSY_2019("2019", BudgetStockEnum.SPLIT_STOCK_YJY_KTY, BudgetStockEnum.SPLIT_STOCK_YJY_GCY,BudgetStockEnum.SPLIT_STOCK_YJY_WTY, BudgetStockEnum.SPLIT_STOCK_YJY_SKY,BudgetStockEnum.SPLIT_STOCK_YJY_FSY, BudgetStockEnum.SPLIT_STOCK_YJY_BHY,BudgetStockEnum.SPLIT_STOCK_YJY_SHY, BudgetStockEnum.SPLIT_STOCK_YJY_AGY),
	SPLIT_STOCK_ZSY_2020("2020", BudgetStockEnum.SPLIT_STOCK_YJY_KTY, BudgetStockEnum.SPLIT_STOCK_YJY_GCY,BudgetStockEnum.SPLIT_STOCK_YJY_WTY, BudgetStockEnum.SPLIT_STOCK_YJY_SKY,BudgetStockEnum.SPLIT_STOCK_YJY_FSY, BudgetStockEnum.SPLIT_STOCK_YJY_BHY,BudgetStockEnum.SPLIT_STOCK_YJY_SHY, BudgetStockEnum.SPLIT_STOCK_YJY_AGY),
	//系统外
	SPLIT_STOCK_XTW_2018("2018", BudgetStockEnum.SPLIT_STOCK_JTDW, BudgetStockEnum.SPLIT_STOCK_WBDW,BudgetStockEnum.SPLIT_STOCK_YK),
	SPLIT_STOCK_XTW_2019("2019", BudgetStockEnum.SPLIT_STOCK_JTDW, BudgetStockEnum.SPLIT_STOCK_WBDW,BudgetStockEnum.SPLIT_STOCK_YK),
	SPLIT_STOCK_XTW_2020("2020", BudgetStockEnum.SPLIT_STOCK_JTDW, BudgetStockEnum.SPLIT_STOCK_WBDW,BudgetStockEnum.SPLIT_STOCK_YK),
	
	//分子公司
	SPLIT_STOCK_ZGS_2018("2018", BudgetStockEnum.SPLIT_STOCK_FZGS,BudgetStockEnum.SPLIT_STOCK_XSD,BudgetStockEnum.SPLIT_STOCK_ZD),
	SPLIT_STOCK_ZGS_2019("2019", BudgetStockEnum.SPLIT_STOCK_FZGS,BudgetStockEnum.SPLIT_STOCK_XSD,BudgetStockEnum.SPLIT_STOCK_ZD,BudgetStockEnum.SPLIT_STOCK_MYSGZS),
	SPLIT_STOCK_ZGS_2020("2020", BudgetStockEnum.SPLIT_STOCK_FZGS,BudgetStockEnum.SPLIT_STOCK_XSD,BudgetStockEnum.SPLIT_STOCK_ZD);
		
	
	private BudgetStockNdEnum(String nd,BudgetStockEnum ... splitList) 
	{
		this.nd = nd;
		this.splits = new ArrayList<>();
		if(splitList != null) {
			for(BudgetStockEnum split:splitList) {
				this.splits.add(split);
			}
		}
	}
	//股份公司分类
	public static BudgetStockNdEnum getStockTotalTypes(String nd)
	{
		for(BudgetStockNdEnum v:BudgetStockNdEnum.values()) 
		{
			if(v.name().contains("TYPE_STOCK") && v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return TYPE_STOCK_2018;
	}
	
	//直属院
	public static BudgetStockNdEnum getStockSplitZsyByNd(String nd)
	{
		for(BudgetStockNdEnum v:BudgetStockNdEnum.values()) 
		{
			if(v.name().contains("SPLIT_STOCK_ZSY") && v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return SPLIT_STOCK_ZSY_2018;
	}
	public static BudgetStockNdEnum getStockSplitXtwByNd(String nd)
	{
		for(BudgetStockNdEnum v:BudgetStockNdEnum.values()) 
		{
			if(v.name().contains("SPLIT_STOCK_XTW") && v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return SPLIT_STOCK_XTW_2018;
	}
	public static BudgetStockNdEnum getStockSplitZgsByNd(String nd)
	{
		for(BudgetStockNdEnum v:BudgetStockNdEnum.values()) 
		{
			if(v.name().contains("SPLIT_STOCK_ZGS") && v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return SPLIT_STOCK_ZGS_2018;
	}
	private String nd;
	private List<BudgetStockEnum> splits;
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public List<BudgetStockEnum> getSplits() {
		return splits;
	}
	public void setSplits(List<BudgetStockEnum> splits) {
		this.splits = splits;
	}
}
