package com.pcitc.base.common.enums;

public enum BudgetAuditStatusEnum {

	AUDIT_STATUS_NO_START(0,"编制中"),
	AUDIT_STATUS_START(1,"审批中"),
	AUDIT_STATUS_REFUSE(-1,"审批驳回"),
	AUDIT_STATUS_PASS(2,"审批通过");
	
	private BudgetAuditStatusEnum(Integer code, String desc) {
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
