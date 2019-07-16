package com.pcitc.base.stp.budget.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 预算检索对象
 * @author uuy
 *
 */
public class BudgetItemSearchVo 
{
	//检索参数【年度】
	private String nd;
	//检索参数【单位编码列表】
	private List<String> unitIds = new ArrayList<String>();
	//检索参数【预算项编码列表】
	private List<String> budgetItemCodes = new ArrayList<String>();
	
	
	private List<Map<String,Object>> rsItems = new ArrayList<Map<String,Object>>();
	
	/**
	 * 根据年度，机构编码，预算项 获取预算数（总数）
	 * @param nd
	 * @param unitId
	 * @param budgetItemCode
	 * @return
	 */
	public Double getBudgetTotal(String nd,String unitId,String budgetItemCode) 
	{
		return getBudgetJZ(nd,unitId,budgetItemCode)+getBudgetJZ(nd,unitId,budgetItemCode);
	}
	/**
	 * 获得结转数
	 * @param nd
	 * @param unitId
	 * @param budgetItemCode
	 * @return
	 */
	public Double getBudgetJZ(String nd,String unitId,String budgetItemCode) 
	{
		Optional<Map<String,Object>> dt = rsItems.stream()
				.filter(a -> a.get("unitId").equals(unitId))
				.filter(a -> a.get("budgetItemCode").equals(budgetItemCode))
				.findFirst();
		if(dt != null && dt.isPresent()) 
		{
			return (Double)dt.get().get("jz");
		}
		return 0d;
	}
	/**
	 * 获得新签数
	 * @param nd
	 * @param unitId
	 * @param budgetItemCode
	 * @return
	 */
	public Double getBudgetXQ(String nd,String unitId,String budgetItemCode) 
	{
		Optional<Map<String,Object>> dt = rsItems.stream()
				.filter(a -> a.get("unitId").equals(unitId))
				.filter(a -> a.get("budgetItemCode").equals(budgetItemCode))
				.findFirst();
		if(dt != null && dt.isPresent()) 
		{
			return (Double)dt.get().get("xq");
		}
		return 0d;
	}
	

	public String getNd() {
		return nd;
	}


	public void setNd(String nd) {
		this.nd = nd;
	}


	public List<String> getUnitIds() {
		return unitIds;
	}


	public void setUnitIds(List<String> unitIds) {
		this.unitIds = unitIds;
	}


	

	public List<String> getBudgetItemCodes() {
		return budgetItemCodes;
	}
	public void setBudgetItemCodes(List<String> budgetItemCodes) {
		this.budgetItemCodes = budgetItemCodes;
	}
	public List<Map<String, Object>> getRsItems() {
		return rsItems;
	}
	public void setRsItems(List<Map<String, Object>> rsItems) {
		this.rsItems = rsItems;
	}
	
	
	
}
