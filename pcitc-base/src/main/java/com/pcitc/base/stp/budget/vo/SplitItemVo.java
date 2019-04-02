package com.pcitc.base.stp.budget.vo;

/**
 * 
 * @author uuy
 *
 */
public class SplitItemVo extends BudgetSplitBaseDataVo 
{
	private Double total;
	private Double jz;
	private Double xq;
    private Double plan;
    
	public Double getTotal() 
	{
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getJz() {
		return jz;
	}
	public void setJz(Double jz) {
		this.jz = jz;
	}
	public Double getXq() {
		return xq;
	}
	public void setXq(Double xq) {
		this.xq = xq;
	}
	public Double getPlan() {
		return plan;
	}
	public void setPlan(Double plan) {
		this.plan = plan;
	}
    
    
}
