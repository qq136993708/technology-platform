package com.pcitc.base.common.enums;

/**
 * 合同拨付状态
 * @author uuy
 *
 */
public enum BudgetPaymentStatusEnum 
{
	PAYMENT_NO(0,"未拨付"),
	PAYMENT_END(1,"已拨付");
	
	private BudgetPaymentStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	

	private Integer code;
	private String desc;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	

}
