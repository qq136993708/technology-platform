package com.pcitc.base.common.enums;

/**
 * 数据操作状态（描述常用的数据处理状态）
 * 删、改
 * @author fengbo
 */
public enum DataOperationStatusEnum 
{
	DEL_OK(201,"操作成功"),
	DEL_DATA_NOEXIS(501,"数据不存在"),
	DEL_DATA_ERROR(502,"数据删除异常"),
	
	UPD_OK(202,"数据更新成功"),
	UPD_ERROR(510,"数据更新异常");
	
	
	private DataOperationStatusEnum(Integer statusCode, String statusDesc) 
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
