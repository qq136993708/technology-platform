package com.pcitc.base.common.enums;

/**
 * 业务处理过程中出现异常
 * 
 * @author fengbo
 */
public enum RequestProcessStatusEnum 
{
	
	OK(200,"成功!"),
	
	SERVER_BUSY(501,"服务器端繁忙，请稍后再试!"),
	NETWORK_ERROR(502,"网络异常，请稍后再试！");
	
	
	private RequestProcessStatusEnum(Integer statusCode, String statusDesc) 
	{
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}
	
	private Integer statusCode;
	private String statusDesc;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	
}
