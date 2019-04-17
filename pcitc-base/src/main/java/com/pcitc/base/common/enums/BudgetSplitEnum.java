package com.pcitc.base.common.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 预算分解
 * @author uuy
 *
 */
public enum BudgetSplitEnum 
{
	SPLIT_GROUP_YF(101,"YF","油服"),
	SPLIT_GROUP_JX(102,"JX","机械"),
	SPLIT_GROUP_QT(103,"QT","其他"),
	
	SPLIT_ASSET_LY(201,"HGB","资产部"),
	SPLIT_ASSET_HG(202,"ZCB","化工部"),
		
	SPLIT_STOCK_YJY(301,"GFFZSY","股份付直属院"),
	SPLIT_STOCK_YJY_KTY(3011,"ZSY_KTY","勘探院"),
	SPLIT_STOCK_YJY_GCY(3012,"ZSY_GCY","工程院"),
	SPLIT_STOCK_YJY_WTY(3013,"ZSY_WTY","物探院"),
	SPLIT_STOCK_YJY_SKY(3014,"ZSY_SKY","石科院"),
	SPLIT_STOCK_YJY_FSY(3015,"ZSY_FSY","抚顺院"),
	SPLIT_STOCK_YJY_BHY(3016,"ZSY_BHY","北化院"),
	SPLIT_STOCK_YJY_SHY(3017,"ZSY_SHY","上海院"),
	SPLIT_STOCK_YJY_AGY(3018,"ZSY_AGY","安工院"),
	SPLIT_STOCK_FZGS(302,"GFFFZGS","股份付分子公司"),
	SPLIT_STOCK_JTDW(303,"GFFJTDW","股份付集团单位"),
	SPLIT_STOCK_WBDW(304,"GFFWBDW","股份付外部单位"),
	SPLIT_STOCK_YK(305,"GFFYK","股份付盈科"),
	SPLIT_STOCK_XSD(306,"GFFXSD","股份付休斯顿"),
	SPLIT_STOCK_ZD(307,"GFFZD","股份付中东");						
	
	//股份公司分类
	public static List<BudgetSplitEnum> getStockSplitTypes()
	{
		List<BudgetSplitEnum> enums = new ArrayList<BudgetSplitEnum>();
		for(BudgetSplitEnum v:BudgetSplitEnum.values()) 
		{
			if(v.name().contains("SPLIT_STOCK") && v.getId()>300 && v.getId()<399) 
			{
				enums.add(v);
			}
		}
		return enums;
	}
	
	private BudgetSplitEnum(Integer id,String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}
	private Integer id;
	private String code;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
