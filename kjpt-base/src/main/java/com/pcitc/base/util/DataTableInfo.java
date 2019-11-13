package com.pcitc.base.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * DataTable 属性封装
 * 
 * @author masir
 *
 */
public class DataTableInfo implements Serializable {

	private static final long serialVersionUID = 7168380689533533667L;
	private String sEcho;
	private Integer iColumns;
	private Integer iDisplayStart = 0;//默认值
	private Integer iDisplayLength = 15;//默认值
	private List<String> mDataProp; // 存放列名
	private String sSearch;// 搜索条件
	private Integer iSortCol_0;
	private String iSortCol;// 排序的列名
	private String sSortDir_0;// asc 或 desc
	
	private Map<String,Object> params = new HashMap<String,Object>();
	private String params_0;
	private String params_1;
	private String params_2;
	private String params_3;
	private String params_4;
	private String params_5;

	// 默认的构造器一定要有，否则作为请求体 发送请求会错误（400）
	public DataTableInfo() {
		super();
	}

	public DataTableInfo(String sEcho, Integer iColumns, Integer iDisplayStart, Integer iDisplayLength, String sSearch,
			Integer iSortCol_0, String iSortCol, String sSortDir_0, List<String> mDataProp) {
		super();
		this.sEcho = sEcho;
		this.iColumns = iColumns;
		this.iDisplayStart = iDisplayStart;
		this.iDisplayLength = iDisplayLength;
		this.sSearch = sSearch;
		this.iSortCol_0 = iSortCol_0;
		this.iSortCol = iSortCol;
		this.sSortDir_0 = sSortDir_0;
		this.mDataProp = mDataProp;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public Integer getiColumns() {
		return iColumns;
	}

	public void setiColumns(Integer iColumns) {
		this.iColumns = iColumns;
	}

	public Integer getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public Integer getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public String getsSearch() {
		return sSearch;
	}

	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	public Integer getiSortCol_0() {
		return iSortCol_0;
	}

	public void setiSortCol_0(Integer iSortCol_0) {
		this.iSortCol_0 = iSortCol_0;
	}

	public String getiSortCol() {
		return iSortCol;
	}

	public void setiSortCol(String iSortCol) {
		this.iSortCol = stringChange(iSortCol);
	}

	public String getsSortDir_0() {
		return sSortDir_0;
	}

	public void setsSortDir_0(String sSortDir_0) {
		this.sSortDir_0 = sSortDir_0;
	}

	public List<String> getmDataProp() {
		return mDataProp;
	}

	public void setmDataProp(List<String> mDataProp) {
		this.mDataProp = mDataProp;
	}

	public String getParams_0() {
		return params_0;
	}

	public void setParams_0(String params_0) {
		this.params_0 = params_0;
	}

	public String getParams_1() {
		return params_1;
	}

	public void setParams_1(String params_1) {
		this.params_1 = params_1;
	}

	public String getParams_2() {
		return params_2;
	}

	public void setParams_2(String params_2) {
		this.params_2 = params_2;
	}

	public String getParams_3() {
		return params_3;
	}

	public void setParams_3(String params_3) {
		this.params_3 = params_3;
	}

	public String getParams_4() {
		return params_4;
	}

	public void setParams_4(String params_4) {
		this.params_4 = params_4;
	}

	public String getParams_5() {
		return params_5;
	}

	public void setParams_5(String params_5) {
		this.params_5 = params_5;
	}

	@SuppressWarnings("static-access")
	private String stringChange(String s) {
		StringBuilder sb = null;
		if (s == null || s == "" || s.trim() == "") {
			return s;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (Character.isUpperCase(s.charAt(i))) {
					s = s.replace(s.charAt(i), s.valueOf(s.charAt(i)).toLowerCase().charAt(0));
					sb = new StringBuilder(s);
					sb.insert(i, "_");
					s = sb.toString();
				}
			}
			return (sb != null) ? sb.toString() : s;
		}
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
