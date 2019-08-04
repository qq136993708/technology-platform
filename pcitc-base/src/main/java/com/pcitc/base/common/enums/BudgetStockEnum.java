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
	SPLIT_STOCK_YJY(301,"GFFZSY","ROOT_ZGSHJT_GFGS_ZSYJY","A0101,A0102,A0103,A0104,A0105,A0106,A0107,A0108","直属研究院"),
	SPLIT_STOCK_YJY_KTY(3011,"ZSY_KTY","ROOT_ZGSHJT_GFGS_ZSYJY_KTY","A0101","勘探院"),
	SPLIT_STOCK_YJY_GCY(3012,"ZSY_GCY","ROOT_ZGSHJT_GFGS_ZSYJY_GCY","A0103","工程院"),
	SPLIT_STOCK_YJY_WTY(3013,"ZSY_WTY","ROOT_ZGSHJT_GFGS_ZSYJY_WTY","A0102","物探院"),
	SPLIT_STOCK_YJY_SKY(3014,"ZSY_SKY","ROOT_ZGSHJT_GFGS_ZSYJY_SKY","A0104","石科院"),
	SPLIT_STOCK_YJY_FSY(3015,"ZSY_FSY","ROOT_ZGSHJT_GFGS_ZSYJY_DLY","A0105","大连院"),
	SPLIT_STOCK_YJY_BHY(3016,"ZSY_BHY","ROOT_ZGSHJT_GFGS_ZSYJY_BHY","A0106","北化院"),
	SPLIT_STOCK_YJY_SHY(3017,"ZSY_SHY","ROOT_ZGSHJT_GFGS_ZSYJY_SHY","A0107","上海院"),
	SPLIT_STOCK_YJY_AGY(3018,"ZSY_AGY","ROOT_ZGSHJT_GFGS_ZSYJY_AGY","A0108","安工院"),
	SPLIT_STOCK_FZGS(302,"GFFFZGS","ROOT_ZGSHJT_GFGS_FZGS","A0201,A0202,A0203","分子公司"),
	SPLIT_STOCK_JTDW(303,"GFFJTDW","ROOT_ZGSHJT_GFGS_JTDW","A0700","集团单位"),
	SPLIT_STOCK_WBDW(304,"GFFWBDW","ROOT_ZGSHJT_GFGS_WBDW","A0301","外部单位"),
	SPLIT_STOCK_YK(305,"GFFYK","ROOT_ZGSHJT_GFGS_SHYK","A0400","盈科"),
	SPLIT_STOCK_XSD(306,"GFFXSD","ROOT_ZGSHJT_GFGS_XSDYFZX","A0500","休斯顿"),
	SPLIT_STOCK_ZD(307,"GFFZD","ROOT_ZGSHJT_GFGS_ZDYFZX","GFFZD","中东"),
	SPLIT_STOCK_MYSGZS(308,"MYSGZS","ROOT_ZGSHJT_GFGS_MYSGZS","MYSGZS","马永生工作室"),
	
	SPLIT_GROUP_TOTAL(309,"ROOT_JFYS_JTDWFL","GROUP_TOTAL","ROOT_JFYS_JTDWFL","集团公司"),
	SPLIT_ASSET_TOTAL(310,"ROOT_JFYS_ZCDWFL","ASSET_TOTAL","ROOT_JFYS_ZCDWFL","资产公司");
	
	/*A0101勘探院
	A0102物探院
	A0103工程院
	A0104石科院
	A0105大连院
	A0106北化院
	A0107上海院
	A0108安工院
	A0201分子公司-油田
	A0202分子公司-炼化
	A0203分子公司-销售及其他
	A0301外部单位-科研经费
	A0400盈科
	A0500休斯顿
	A0700集团单位
	A0800资产单位*/

	
	
	
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
	private BudgetStockEnum(Integer id,String code,String unitCode,String projectCode,String name) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.projectCode = projectCode;
		this.unitCode = unitCode;
	}
	private Integer id;
	private String code;
	private String name;
	private String projectCode;
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
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
}
