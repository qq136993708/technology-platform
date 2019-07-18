package com.pcitc.base.stp.budget.vo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
	//检索参数【预算项编码列表】废弃
	@Deprecated
	private List<String> budgetItemCodes = new ArrayList<String>();
	
	//预算检索返回结果
	private List<Map<String,Object>> rsItems = new ArrayList<Map<String,Object>>();
	
	/**
	 * 获取总预算数（只包含费用性）
	 * @param nd
	 * @return
	 */
	public Double getBudgetTotal() 
	{
		Double total = 0d;
		for(Map<String,Object> map:rsItems) 
		{
			total += (Double)map.get("xq")+(Double)map.get("jz");
		}
		return total;
	}
	/**
	 * 获取指定机构按预算项目[研究院、分子公司、外部单位...]汇总结果
	 * @param unitId
	 * @return
	 */
	public List<Map<String,Object>> getBudgetByUnit(String unitId) 
	{
		List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> map:rsItems) 
		{
			if(unitId.equals(map.get("unitId"))) {
				rs.add(map);
			}
		}
		return rs;
	}
	/**
	 * 获取所有机构按预算项目[研究院、分子公司、外部单位...]汇总结果
	 * @return
	 */
	public List<Map<String,Object>> getBudgetByAllUnit() 
	{
		Map<String,Map<String,Object>> maps = new LinkedHashMap<String,Map<String,Object>>();
		for(Map<String,Object> map:rsItems) 
		{
			String budgetItemCode= map.get("budgetItemCode").toString();
			if(!maps.containsKey(budgetItemCode)) {
				map.put("unitName", "");
				map.put("unitId", "");
				maps.put(budgetItemCode, map);
			}else {
				Double jz = (Double)maps.get(budgetItemCode).get("jz");
				Double xq = (Double)maps.get(budgetItemCode).get("xq");
				Double total = (Double)maps.get(budgetItemCode).get("total");
				maps.get(budgetItemCode).put("jz", Double.valueOf(map.get("jz")+"")+jz);
				maps.get(budgetItemCode).put("xq", Double.valueOf(map.get("xq")+"")+xq);
				maps.get(budgetItemCode).put("total", Double.valueOf(map.get("total")+"")+total);
			}
		}
		return new ArrayList<Map<String,Object>>(maps.values());
	}
	/**
	 * 获取指定单位的指定预算项的值
	 * @param unitId
	 * @param ItemCode
	 * @return
	 */
	public Double getBudgetByUnitAndItem(String unitId,String ItemCode) 
	{
		Double total = 0d;
		List<Map<String,Object>> list = rsItems.stream()
				.filter(a -> a.get("unitId").equals(unitId))
				.filter(a -> a.get("budgetItemCode").equals(ItemCode))
				.collect(Collectors.toList());
		for(Map<String,Object> map:list) 
		{
			total += (Double)map.get("xq")+(Double)map.get("jz");
		}
		return total;
	}
	/**
	 * 根据年度，机构编码，预算项 获取预算数（总数）
	 * @param nd
	 * @param unitId
	 * @param budgetItemCode
	 * @return
	 */
	@Deprecated
	public Double getBudgetTotal(String nd,String unitId,String budgetItemCode) 
	{
		return getBudgetJZ(nd,unitId,budgetItemCode)+getBudgetXQ(nd,unitId,budgetItemCode);
	}
	/**
	 * 获得结转数
	 * @param nd
	 * @param unitId
	 * @param budgetItemCode
	 * @return
	 */
	@Deprecated
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
	@Deprecated
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
