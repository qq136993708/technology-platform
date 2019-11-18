package com.pcitc.web.utils;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "返回响应数据")
public class RestMessage implements Serializable{
	
	
	
	
	
	@ApiModelProperty(value = "执行结果")
    private boolean success;

	@ApiModelProperty(value = "结果集")
    private Object data;

	@ApiModelProperty(value = "返回信息")
    private String message;

	@ApiModelProperty(value = "返回状态码")
    private String code;

	@ApiModelProperty(value = "成功返回编码")
    public static final String RESPONSE_SUCC_CODE = "0";

	@ApiModelProperty(value = "默认消息")
    public static final String RESPONSE_SUCC_MSG = "success";

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static String getResponseSuccCode() {
		return RESPONSE_SUCC_CODE;
	}

	public static String getResponseSuccMsg() {
		return RESPONSE_SUCC_MSG;
	}
	
	
	

    public RestMessage() {

        this.success = true;
    }

    public RestMessage(boolean success) {

        this.success = success;
    }
	
	 public RestMessage(boolean success, Object data) {

	        this.success = success;
	        this.data = data;
	    }

	    public RestMessage(boolean success, Object data, String message) {

	        this.success = success;
	        this.data = data;
	        this.message = message;
	    }

	    public RestMessage(boolean success, Object data, String message, String code) {

	        this.success = success;
	        this.data = data;
	        this.message = message;
	        this.code = code;
	    }

	    public RestMessage(boolean success, String message) {

	        this.success = success;
	        this.message = message;
	    }
	
	
	
	
	
	
	
	
    

}
