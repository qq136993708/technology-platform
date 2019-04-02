package com.pcitc.base.stp.budget.vo;

import java.util.Map;

/**
 * 分解表基础对象
 * @author uuy
 *
 */
public class BudgetSplitBaseDataVo 
{

	private Integer no;
	private String dataId;
	private String dataVersion;
	private String nd;
	private Integer organId;
    private String organCode;
    private Integer splitId;
    private String splitCode;
    private Integer budgetType;
    private String budgetTypeName;  
    private String budgetInfoId;
    private Integer delFlag;
    
    private Map<String,SplitItemVo> items;
    
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
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
	public Integer getSplitId() {
		return splitId;
	}
	public void setSplitId(Integer splitId) {
		this.splitId = splitId;
	}
	public String getSplitCode() {
		return splitCode;
	}
	public void setSplitCode(String splitCode) {
		this.splitCode = splitCode;
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
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public Map<String, SplitItemVo> getItems() {
		return items;
	}
	public void setItems(Map<String, SplitItemVo> items) {
		this.items = items;
	}
}
