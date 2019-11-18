package com.pcitc.base.exception;

public class SysException extends RuntimeException{

	/**
	 * @author ty
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	public SysException() {
		super();
	}
	
	public SysException(String msg) {
		super(msg);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String coede) {
		this.code = coede;
	}
}
