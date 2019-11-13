package com.pcitc.base.common;

import java.util.List;
import java.util.Map;

public class ChartDataMulti {
	
	private String indexName;    //指标名称
	private List<Map<String, Object>> list ;
	
	
	
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	
	
}
