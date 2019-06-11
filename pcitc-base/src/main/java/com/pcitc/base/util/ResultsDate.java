package com.pcitc.base.util;

public class ResultsDate {

	public final static String RETURN_CODE_SUCCESS = "SUCCESS";
	public final static String RETURN_CODE_FAIL = "FAIL";
	private Object returnData = "";// 返回数据
	private String resultCode = "FAIL";// SUCCESS/FAIL 反回结果，成功或失败
	private String returnDesc = "";// 返回结果描述
	// 如果resultCode==FAIL，errCode才有值
	private String errCode;// 错误代码 1参数为空，2用户不存在
	private String errCodeDesc = "";// 错误代码描述

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDesc() {
		return errCodeDesc;
	}

	public void setErrCodeDesc(String errCodeDesc) {
		this.errCodeDesc = errCodeDesc;
	}

	public String getReturnDesc() {
		return returnDesc;
	}

	public void setReturnDesc(String returnDesc) {
		this.returnDesc = returnDesc;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}

}
