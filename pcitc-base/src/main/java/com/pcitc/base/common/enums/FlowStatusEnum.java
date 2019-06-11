package com.pcitc.base.common.enums;
/**
 * 审批状态（包括开始状态、结束状态、审批通过状态)
 * @author fengbo
 *
 */
public enum FlowStatusEnum 
{
	FLOW_START_STATUS_NO(0,"未开始"),
	FLOW_START_STATUS_YES(1,"已开始"),
	
	FLOW_END_STATUS_NO(0,"未结束"),
	FLOW_END_STATUS_YES(1,"已结束"),
	
	FLOW_CURRENT_STATUS_ON(0,"审批中"),
	FLOW_CURRENT_STATUS_PASS(1,"审批通过"),
	FLOW_CURRENT_STATUS_NOPASS(-1,"审批未通过");
	
	public static String getStartStatus(Integer code){
		if(FLOW_START_STATUS_NO.code.equals(code)){
			return FLOW_START_STATUS_NO.desc;
		}
		if(FLOW_START_STATUS_YES.code.equals(code)){
			return FLOW_START_STATUS_YES.desc;
		}
		return null;
	}
	
	private FlowStatusEnum(Integer code, String desc) {
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
