package com.pcitc.base.stp.budget.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 分解表基础对象
 * @author uuy
 *
 */
public class BudgetSplitBaseDataVo 
{

	private Integer no;
	private String dataVersion;
	private String nd;
	private Integer organId;
    private String organCode;
    private String organName;
    private Integer budgetType;
    private String budgetTypeName;  
    private String budgetInfoId;
   
    
    private Map<String,SplitItemVo> items = new HashMap<String,SplitItemVo>();
    
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
	public String getDataVersion() {
		return dataVersion;
	}
	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public Integer getOrganId() {
		return organId;
	}
	public void setOrganId(Integer organId) {
		this.organId = organId;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	
	public Integer getBudgetType() {
		return budgetType;
	}
	public void setBudgetType(Integer budgetType) {
		this.budgetType = budgetType;
	}
	public String getBudgetTypeName() {
		return budgetTypeName;
	}
	public void setBudgetTypeName(String budgetTypeName) {
		this.budgetTypeName = budgetTypeName;
	}
	public String getBudgetInfoId() {
		return budgetInfoId;
	}
	public void setBudgetInfoId(String budgetInfoId) {
		this.budgetInfoId = budgetInfoId;
	}
	
	public Map<String, SplitItemVo> getItems() {
		return items;
	}
	public void setItems(Map<String, SplitItemVo> items) {
		this.items = items;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	
	
}
