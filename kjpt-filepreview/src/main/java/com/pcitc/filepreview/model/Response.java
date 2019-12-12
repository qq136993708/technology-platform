package com.pcitc.filepreview.model;

import java.io.Serializable;

/**
 * 返回实体
 *
 * @param <T>
 */
public class Response<T> implements Serializable {

	/**
	 * 成功返回编码
	 */
	public static final String RESPONSE_SUCC_CODE = "0";
	
	/**
	 * 默认消息
	 */
	public static final String RESPONSE_SUCC_MSG = "success";
	 
	/**
	 * 响应编码
	 */
	private String resCode;
	
	/**
	 * 响应消息
	 */
	private String resMessage;
	
	/**
	 * 分页响应数据条数
	 */
	private long total;
	
	/**
	 * 分页响应实际页码
	 */
	private int pageNum;
	
	/**
	 * 分页响应页数
	 */
	private int pageCount;
	
	/**
	 * 数据
	 */
	private T result;
	
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMessage() {
		return resMessage;
	}
	public void setResMessage(String resMessage) {
		this.resMessage = resMessage;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	
}
