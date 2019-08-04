package com.pcitc.base.common.enums;
/**
 * 预算处部门分解
 * @author uuy
 *
 */
public enum BudgetOrganEnum 
{
	ORG_YTC(1,"YTC","30130055","102","油田处"),
	ORG_LYC(2,"LYC","30130056","105","炼油处"),
	ORG_HGC(3,"HGC","30130057","106","化工处"),
	ORG_CLC(4,"CLC","30130058","107","材料处"),
	ORG_ZCC(5,"ZZC","30130059","108","装储处"),
	ORG_ZHJHC(6,"ZHJHC","30130054","101","综合计划处"),
	ORG_JSJDC(7,"JSJDC","30130063","111","技术监督处"),
	ORG_SJC(8,"SJC","30130062","110","三剂处"),
	ORG_ZSCQC(9,"ZSCQC","30130061","109","知识产权处"),
	ORG_WZB(10,"WZB","30130011","112","物装部"),
	ORG_XXB(11,"XXB","30130017","XXB","信息部"),
	ORG_GCB(12,"GCB","30130018","GCB","工程部"),
	ORG_LYSYBJG(13,"LYSYBJG","3013000902","LYSYBJG","炼油事业部（军工）"),	
	ORG_LYSYBB2C(14,"LYSYBB2C","30130009","113","炼油事业部（B2、C类）"),
	ORG_HGSYBB2C(15,"HGSYBB2C","30130016","115","化工事业部（B2、C类）"),
	ORG_ZX(16,"ZX","ZX","ZX","专项"),
	ORG_JD(17,"JD","JD","JD","机动"),
	
	ORG_KTKFC(21,"KTKFC","30130064","KTKFC","勘探开发处"),
	ORG_GCJSC(22,"GCJSC","30130065","GCJSC","石油工程处");
	
	/*105炼油处
	107材料处
	113炼油部
	102油田处
	115化工部
	108装备与储运处
	106化工处
	101综合计划处
	110三剂处
	109知识产权处
	112物装部
	111技术监督处*/

	
	
	private BudgetOrganEnum(Integer id,String code,String unitCode,String projectCode,String name) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.projectCode = projectCode;
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
	public static BudgetOrganEnum getByProjectCode(String projectCode)
	{
		for(BudgetOrganEnum v:BudgetOrganEnum.values()) 
		{
			if(v.getProjectCode().equals(projectCode)) 
			{
				return v;
			}
		}
		return null;
	}
	
	private Integer id;
	private String code;
	private String unitCode;
	private String projectCode;//合同系统处部门编码
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
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
}
