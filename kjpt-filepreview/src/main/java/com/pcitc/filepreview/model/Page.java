package com.pcitc.filepreview.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页器
 * @param <T> 具体类型
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 8295617143922186889L;

	//分页结果
	private long count;
	// 页码
	private int pageNum;
	//每页条数
	private int pageSize;
	//数据
	private List<T> data;
	//页数
	private int pageCount;
	
	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public long getCount() {
		return count;
	}
 
	public int getPageNum() {
		return pageNum;
	}
 
	public List<T> getData() {
		if(data == null) {
			return new ArrayList<T>(); 
		}
		return data;
	}

	public Page(List<T> data, long count) {
		this.count = count;
		this.data = data;
	}
	
	public Page(List<T> data, long count, int pageSize, int pageNum) {
		this.count = count; 
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		
		if(this.pageSize>0) {
			if(count == 0) {
				this.pageCount = 0;
			} else {
				this.pageCount = (int) (count - 1) / pageSize + 1;
			}
			
			if(this.pageNum > this.pageCount) {
				this.pageNum = this.pageCount;
			}
		}
		
		this.data = data;
	}
	
}
