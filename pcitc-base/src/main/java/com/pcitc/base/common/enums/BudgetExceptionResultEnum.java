package com.pcitc.base.common.enums;

import com.pcitc.base.common.Result;

public enum BudgetExceptionResultEnum 
{
	ERROR_FLOWING(501,new Result(false,null,"审批中不可修改!")),
	ERROR_FLOWEND(502,new Result(false,null,"审批完成不可修改!")),
	ERROR_FLOWRELASE(503,new Result(false,null,"最终版本不可修改!")),
	ERROR(500,new Result(false,null,"操作异常"));
	
	private Integer code;
	private Result result;
	
	private BudgetExceptionResultEnum(Integer code, Result result) {
		this.code = code;
		this.result = result;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
