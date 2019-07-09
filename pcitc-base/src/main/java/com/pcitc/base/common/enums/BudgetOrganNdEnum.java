package com.pcitc.base.common.enums;

import java.util.ArrayList;
import java.util.List;
/**
 * 年度預算分配項目
 * @author uuy
 *
 */
public enum BudgetOrganNdEnum 
{
	ORGAN_2018("2018",BudgetOrganEnum.ORG_YTC,BudgetOrganEnum.ORG_LYC,BudgetOrganEnum.ORG_HGC,BudgetOrganEnum.ORG_CLC,BudgetOrganEnum.ORG_ZCC,BudgetOrganEnum.ORG_ZHJHC,BudgetOrganEnum.ORG_JSJDC,BudgetOrganEnum.ORG_SJC,BudgetOrganEnum.ORG_ZSCQC,BudgetOrganEnum.ORG_WZB,BudgetOrganEnum.ORG_XXB,BudgetOrganEnum.ORG_GCB,BudgetOrganEnum.ORG_LYSYBJG,BudgetOrganEnum.ORG_LYSYBB2C,BudgetOrganEnum.ORG_HGSYBB2C,BudgetOrganEnum.ORG_ZX,BudgetOrganEnum.ORG_JD),
	ORGAN_2019("2019",BudgetOrganEnum.ORG_KTKFC,BudgetOrganEnum.ORG_GCJSC,BudgetOrganEnum.ORG_LYC,BudgetOrganEnum.ORG_HGC,BudgetOrganEnum.ORG_CLC,BudgetOrganEnum.ORG_ZCC,BudgetOrganEnum.ORG_ZHJHC,BudgetOrganEnum.ORG_JSJDC,BudgetOrganEnum.ORG_SJC,BudgetOrganEnum.ORG_ZSCQC,BudgetOrganEnum.ORG_WZB,BudgetOrganEnum.ORG_XXB,BudgetOrganEnum.ORG_GCB,BudgetOrganEnum.ORG_LYSYBJG,BudgetOrganEnum.ORG_LYSYBB2C,BudgetOrganEnum.ORG_HGSYBB2C,BudgetOrganEnum.ORG_ZX,BudgetOrganEnum.ORG_JD),
	ORGAN_2020("2020",BudgetOrganEnum.ORG_KTKFC,BudgetOrganEnum.ORG_GCJSC,BudgetOrganEnum.ORG_LYC,BudgetOrganEnum.ORG_HGC,BudgetOrganEnum.ORG_CLC,BudgetOrganEnum.ORG_ZCC,BudgetOrganEnum.ORG_ZHJHC,BudgetOrganEnum.ORG_JSJDC,BudgetOrganEnum.ORG_SJC,BudgetOrganEnum.ORG_ZSCQC,BudgetOrganEnum.ORG_WZB,BudgetOrganEnum.ORG_XXB,BudgetOrganEnum.ORG_GCB,BudgetOrganEnum.ORG_LYSYBJG,BudgetOrganEnum.ORG_LYSYBB2C,BudgetOrganEnum.ORG_HGSYBB2C,BudgetOrganEnum.ORG_ZX,BudgetOrganEnum.ORG_JD);
	private BudgetOrganNdEnum(String nd,BudgetOrganEnum ... organList) 
	{
		this.nd = nd;
		this.organs = new ArrayList<>();
		if(organList != null) {
			for(BudgetOrganEnum organ:organList) {
				this.organs.add(organ);
			}
		}
	}
	public static BudgetOrganNdEnum getByNd(String nd)
	{
		for(BudgetOrganNdEnum v:BudgetOrganNdEnum.values()) 
		{
			if(v.getNd().equals(nd)) 
			{
				return v;
			}
		}
		return ORGAN_2019;
	}
	
	
	private String nd;
	private List<BudgetOrganEnum> organs;
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public List<BudgetOrganEnum> getOrgans() {
		return organs;
	}
	public void setOrgans(List<BudgetOrganEnum> organs) {
		this.organs = organs;
	}
	
	
}
