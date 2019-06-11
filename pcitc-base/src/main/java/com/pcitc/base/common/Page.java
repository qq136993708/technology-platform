package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

public class Page {

	public static int PAGE_SIZE = 15;

	private int pageNo;
	private int pageSize;
	private int totalPages;
	private int totalRecords;
	private int showPage = 9;
	private int listbegin;
	private int listend;
	private int start;
	private float searSec;
	private List rows = new ArrayList();
	private JSONArray rowsJson = null;

	public Page() {
		super();
	}

	public JSONArray getRowsJson() {
		return rowsJson;
	}

	public void setRowsJson(JSONArray rowsJson) {
		this.rowsJson = rowsJson;
	}

	public int getShowPage() {
		return showPage;
	}

	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}

	public float getSearSec() {
		return searSec;
	}

	public void setSearSec(float searSec) {
		this.searSec = searSec;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public Page(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = (pageSize <= 0) ? 15 : pageSize;
	}

	public Page(int pageNo) {
		this.pageNo = pageNo;

		this.pageSize = 15;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {

		if (totalPages < pageNo && totalPages > 0) {
			pageNo = totalPages;
		}
		if (pageNo < 1) {
			pageNo = 1;
		}
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		if (totalRecords != 0) {
			if (totalRecords % this.pageSize == 0) {
				this.totalPages = this.totalRecords / this.pageSize;
			} else {
				this.totalPages = this.totalRecords / this.pageSize + 1;
			}
		}

	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public int getListbegin() {
		return listbegin;
	}

	public void setListbegin(int listbegin) {

		this.listbegin = listbegin;
	}

	public int getListend() {
		return listend;
	}

	public void setListend(int listend) {
		this.listend = listend;
	}

	public int getStart() {
		return start;
	}

	public void setStart() {
		this.start = (pageNo - 1) * pageSize;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
