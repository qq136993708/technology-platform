package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class ChartSingleLineResultData {
	  private	List<String> xAxisDataList=new ArrayList<String>();
	  private	List<Object> seriesDataList=new ArrayList<Object>();
	  private	String title;
	public List<String> getxAxisDataList() {
		return xAxisDataList;
	}
	public void setxAxisDataList(List<String> xAxisDataList) {
		this.xAxisDataList = xAxisDataList;
	}
	public List<Object> getSeriesDataList() {
		return seriesDataList;
	}
	public void setSeriesDataList(List<Object> seriesDataList) {
		this.seriesDataList = seriesDataList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	  
	  
	  
	    

}
