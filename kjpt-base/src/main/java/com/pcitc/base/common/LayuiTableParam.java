package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fb
 *
 */
public class LayuiTableParam {
	private Integer page = 1;
	private Integer limit = 15;
	private Map<String, Object> sorts = new HashMap<String, Object>();
	private Map<String, Object> param = new HashMap<String, Object>();
	private String paramJson;

	private String orderKey;

	private String orderType;

	public LayuiTableParam() 
	{
		super();
	}
	
	
	public LayuiTableParam(Integer page, Integer limit) {
		super();
		this.page = page;
		this.limit = limit;
	}


	public String getOrderClause() {
		List<LayuiTableSortParam> orders = this.getSortList();
		if (orders.size() == 0) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (LayuiTableSortParam p : orders) {
			sb.append(p.getField() + " " + p.getType() + ",");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	/**
	 * 获得排序字段列表
	 * 
	 * @return
	 */
	public List<LayuiTableSortParam> getSortList() {
		List<LayuiTableSortParam> sortlist = new ArrayList<LayuiTableSortParam>();
		for (java.util.Iterator<String> iter = this.getSorts().keySet().iterator(); iter.hasNext();) {
			String key = iter.next();
			LayuiTableSortParam sp = new LayuiTableSortParam();
			sp.setField(key);
			sp.setType(this.getSorts().get(key).toString());

			sortlist.add(sp);
		}
		return sortlist;
	}

	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

	public String getParamJson() {
		return paramJson;
	}

	public void setParamJson(String paramJson) {
		this.paramJson = paramJson;
	}

	public Map<String, Object> getSorts() {
		return sorts;
	}

	public void setSorts(Map<String, Object> sorts) {
		this.sorts = sorts;
	}

	/*
	 * public List<LayuiTableSortParam> getSorts() { return sorts; } public void
	 * setSorts(List<LayuiTableSortParam> sorts) { this.sorts = sorts; }
	 */

}
