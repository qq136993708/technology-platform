package com.pcitc.base.stp.budget.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

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
	
	//预算检索返回结果
	private List<Map<String,Object>> rsItems = new ArrayList<Map<String,Object>>();
	
	/**
	 * 获取总预算数（只包含费用性）
	 * @param 
	 * @return
	 */
	public Double getBudgetTotal() 
	{
		Double total = 0d;
		for(Map<String,Object> map:getRsItems()) 
		{
			//移除直属研究院和股份公司（避免重复统计 ）
			if("ROOT_ZGSHJT_GFGS_ZSYJY".equals(map.get("budgetItemCode"))
				||"STOCK_TOTAL".equals(map.get("budgetItemCode"))) {
				continue;
			}
			total += ((Double)map.get("xq")+(Double)map.get("jz"));
		}
		return total;
	}
	/**
	 * 获取结转数（只包含费用性）
	 * @param 
	 * @return
	 */
	public Double getBudgetJz() 
	{
		Double jz = 0d;
		for(Map<String,Object> map:getRsItems()) 
		{
			//移除直属研究院（避免重复统计 ）
			if("ROOT_ZGSHJT_GFGS_ZSYJY".equals(map.get("budgetItemCode"))
				||"STOCK_TOTAL".equals(map.get("budgetItemCode"))) {
				continue;
			}
			jz += (Double)map.get("jz");
		}
		return jz;
	}
	/**
	 * 获取新签数（只包含费用性）
	 * @param 
	 * @return
	 */
	public Double getBudgetXq() 
	{
		Double xq = 0d;
		for(Map<String,Object> map:getRsItems()) 
		{
			//移除直属研究院（避免重复统计 ）
			if("ROOT_ZGSHJT_GFGS_ZSYJY".equals(map.get("budgetItemCode"))
				||"STOCK_TOTAL".equals(map.get("budgetItemCode"))) {
				continue;
			}
			xq += (Double)map.get("xq");
		}
		return xq;
	}
	/**
	 * 获取指定机构按预算项目[研究院、分子公司、外部单位...]汇总结果，如果不指定则获取所有机构
	 * @return
	 */
	public List<Map<String,Object>> getBudgetByAllUnit() 
	{
		return getBudgetByUnit(new LinkedHashSet<String>(unitIds));
	}
	/**
	 * 获取指定机构按预算项目[研究院、分子公司、外部单位...]汇总结果
	 * @param unitId
	 * @return
	 */
	public List<Map<String,Object>> getBudgetByUnit(String unitId) 
	{
		Set<String> set = new HashSet<String>();
		set.add(unitId);
		return getBudgetByUnit(set);
	}
	/**
	 * 获取所有机构按预算项目[研究院、分子公司、外部单位...]汇总结果
	 * @param unitIds
	 * @return
	 */
	public List<Map<String,Object>> getBudgetByUnit(Set<String> unitIds) 
	{
		List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list = getRsItems().stream()
				.filter(a -> unitIds.contains(a.get("unitId")))
				.collect(Collectors.toList());
		for(Map<String,Object> map:list) 
		{
			Map<String,Object> m = null;
			Optional<Map<String,Object>> dt = rs.stream()
					.filter(a -> a.get("budgetItemCode").equals(map.get("budgetItemCode")))
					.findFirst();
			if(dt != null && dt.isPresent()) {
				m = dt.get();
				m.put("total", (Double)m.get("total")+(Double)map.get("total"));
				m.put("jz", (Double)m.get("jz")+(Double)map.get("jz"));
				m.put("xq", (Double)m.get("xq")+(Double)map.get("xq"));
				m.put("otherPayMoney", (Double)m.get("otherPayMoney")+(Double)map.get("otherPayMoney"));
			}else {
				m = new HashMap<String,Object>();
				
				m.put("unitId", JSON.toJSONString(unitIds));
				m.put("unitName", JSON.toJSONString(unitIds));
				m.put("budgetItemCode", map.get("budgetItemCode"));
				m.put("budgetItemName", map.get("budgetItemName"));
				m.put("total", map.get("total"));
				m.put("jz", map.get("jz"));
				m.put("xq", map.get("xq"));
				m.put("otherPayMoney", map.get("otherPayMoney"));
				rs.add(m);
			}
		}
		//计算股份公司合计
		processStockSum(rs);
		return rs;
	}
	/**
	 * 计算股份公司求和（各研究院和研究院汇总不能重复计算）
	 * @param data
	 */
	private void processStockSum(List<Map<String,Object>> data) 
	{
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("unitId", JSON.toJSONString(unitIds));
		m.put("unitName", JSON.toJSONString(unitIds));
		m.put("budgetItemCode", "STOCK_TOTAL");
		m.put("budgetItemName", "股份公司");
		m.put("total", 0d);
		m.put("jz", 0d);
		m.put("xq", 0d);
		m.put("otherPayMoney", 0d);
		for(Map<String,Object> map:data) 
		{
			//排除研究院、集团公司、资产公司
			if("ROOT_ZGSHJT_GFGS_ZSYJY".equals(map.get("budgetItemCode"))
			||"GROUP_TOTAL".equals(map.get("budgetItemCode"))
			||"ASSET_TOTAL".equals(map.get("budgetItemCode"))) {
				continue;
			}
			m.put("total", (Double)m.get("total")+(Double)map.get("total"));
			m.put("jz", (Double)m.get("jz")+(Double)map.get("jz"));
			m.put("xq", (Double)m.get("xq")+(Double)map.get("xq"));
			m.put("otherPayMoney", (Double)m.get("otherPayMoney")+(Double)map.get("otherPayMoney"));
		}
		data.add(m);
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
