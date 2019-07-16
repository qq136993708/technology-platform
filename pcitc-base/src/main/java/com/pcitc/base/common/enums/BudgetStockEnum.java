package com.pcitc.base.common.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 预算分解
 * @author uuy
 *
 */
public enum BudgetStockEnum 
{
	SPLIT_STOCK_YJY(301,"GFFZSY","ROOT_ZGSHJT_GFGS_ZSYJY","直属研究院"),
	SPLIT_STOCK_YJY_KTY(3011,"ZSY_KTY","ROOT_ZGSHJT_GFGS_ZSYJY_KTY","勘探院"),
	SPLIT_STOCK_YJY_GCY(3012,"ZSY_GCY","ROOT_ZGSHJT_GFGS_ZSYJY_GCY","工程院"),
	SPLIT_STOCK_YJY_WTY(3013,"ZSY_WTY","ROOT_ZGSHJT_GFGS_ZSYJY_WTY","物探院"),
	SPLIT_STOCK_YJY_SKY(3014,"ZSY_SKY","ROOT_ZGSHJT_GFGS_ZSYJY_SKY","石科院"),
	SPLIT_STOCK_YJY_FSY(3015,"ZSY_FSY","ROOT_ZGSHJT_GFGS_ZSYJY_DLY","大连院"),
	SPLIT_STOCK_YJY_BHY(3016,"ZSY_BHY","ROOT_ZGSHJT_GFGS_ZSYJY_BHY","北化院"),
	SPLIT_STOCK_YJY_SHY(3017,"ZSY_SHY","ROOT_ZGSHJT_GFGS_ZSYJY_SHY","上海院"),
	SPLIT_STOCK_YJY_AGY(3018,"ZSY_AGY","ROOT_ZGSHJT_GFGS_ZSYJY_AGY","安工院"),
	SPLIT_STOCK_FZGS(302,"GFFFZGS","ROOT_ZGSHJT_GFGS_FZGS","分子公司"),
	SPLIT_STOCK_JTDW(303,"GFFJTDW","ROOT_ZGSHJT_GFGS_JTDW","集团单位"),
	SPLIT_STOCK_WBDW(304,"GFFWBDW","ROOT_ZGSHJT_GFGS_WBDW","外部单位"),
	SPLIT_STOCK_YK(305,"GFFYK","ROOT_ZGSHJT_GFGS_SHYK","盈科"),
	SPLIT_STOCK_XSD(306,"GFFXSD","ROOT_ZGSHJT_GFGS_XSDYFZX","休斯顿研发中心"),
	SPLIT_STOCK_ZD(307,"GFFZD","ROOT_ZGSHJT_GFGS_ZDYFZX","中东研发中心"),
	SPLIT_STOCK_MYSGZS(308,"MYSGZS","ROOT_ZGSHJT_GFGS_MYSGZS","马永生工作室");			
	
	//股份公司分类
	public static List<BudgetStockEnum> getStockSplitTypes()
	{
		List<BudgetStockEnum> enums = new ArrayList<BudgetStockEnum>();
		for(BudgetStockEnum v:BudgetStockEnum.values())
		{
			if(v.name().contains("SPLIT_STOCK") && v.getId()>300 && v.getId()<399)
			{
				enums.add(v);
			}
		}
		return enums;
	}
	public static BudgetStockEnum getById(Integer id)
	{
		for(BudgetStockEnum v:BudgetStockEnum.values()) 
		{
			if(v.getId().equals(id)) 
			{
				return v;
			}
		}
		return null;
	}
	public static BudgetStockEnum getByCode(String code)
	{
		for(BudgetStockEnum v:BudgetStockEnum.values()) 
		{
			if(v.getCode().equals(code)) 
			{
				return v;
			}
		}
		return null;
	}
	public static BudgetStockEnum getByUnitCode(String unitCode)
	{
		for(BudgetStockEnum v:BudgetStockEnum.values()) 
		{
			if(v.getUnitCode().equals(unitCode)) 
			{
				return v;
			}
		}
		return null;
	}
	private BudgetStockEnum(Integer id,String code,String unitCode,String name) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.unitCode = unitCode;
	}
	private Integer id;
	private String code;
	private String name;
	private String unitCode;
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

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	
}
