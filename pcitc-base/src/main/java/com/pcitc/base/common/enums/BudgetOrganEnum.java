package com.pcitc.base.common.enums;
/**
 * 预算处部门分解
 * @author uuy
 *
 */
public enum BudgetOrganEnum 
{
	ORG_YTC(1,"YTC","30130055","油田处"),
	ORG_LYC(2,"LYC","30130056","炼油处"),
	ORG_HGC(3,"HGC","30130057","化工处"),
	ORG_CLC(4,"CLC","30130058","材料处"),
	ORG_ZCC(5,"ZZC","30130059","装储处"),
	ORG_ZHJHC(6,"ZHJHC","30130054","综合计划处"),
	ORG_JSJDC(7,"JSJDC","30130063","技术监督处"),
	ORG_SJC(8,"SJC","30130062","三剂处"),
	ORG_ZSCQC(9,"ZSCQC","30130061","知识产权处"),
	ORG_WZB(10,"WZB","30130011","物装部"),
	ORG_XXB(11,"XXB",null,"信息部"),
	ORG_GCB(12,"GCB",null,"工程部"),
	ORG_LYSYBJG(13,"LYSYBJG",null,"炼油事业部（军工）"),	
	ORG_LYSYBB2C(14,"LYSYBB2C","30130009","炼油事业部（B2、C类）"),
	ORG_HGSYBB2C(15,"HGSYBB2C","30130016","化工事业部（B2、C类）"),
	ORG_ZX(16,"ZX",null,"专项"),
	ORG_JD(17,"JD",null,"机动"),
	
	ORG_KTKFC(21,"KTKFC","30130064","勘探开发处"),
	ORG_GCJSC(22,"GCJSC","30130065","工程技术处");
	
	
	private BudgetOrganEnum(Integer id,String code,String unitCode,String name) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.unitCode = unitCode;
	}
	public static BudgetOrganEnum getById(Integer id)
	{
		for(BudgetOrganEnum v:BudgetOrganEnum.values()) 
		{
			if(v.getId().equals(id)) 
			{
				return v;
			}
		}
		return null;
	}
	public static BudgetOrganEnum getByCode(String code)
	{
		for(BudgetOrganEnum v:BudgetOrganEnum.values()) 
		{
			if(v.getCode().equals(code)) 
			{
				return v;
			}
		}
		return null;
	}
	public static BudgetOrganEnum getByUnitCode(String unitCode)
	{
		for(BudgetOrganEnum v:BudgetOrganEnum.values()) 
		{
			if(v.getUnitCode().equals(unitCode)) 
			{
				return v;
			}
		}
		return null;
	}
	
	private Integer id;
	private String code;
	private String unitCode;
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
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	
}
