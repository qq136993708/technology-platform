package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class ChartPieResultData {
	
    private	List<ChartPieDataValue> dataList=new ArrayList<ChartPieDataValue>();
    
    private	List<String> legendDataList=new ArrayList<String>();
    
    private	String title;
    
    

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getLegendDataList() {
		return legendDataList;
	}

	public void setLegendDataList(List<String> legendDataList) {
		this.legendDataList = legendDataList;
	}

	public List<ChartPieDataValue> getDataList() {
		return dataList;
	}

	public void setDataList(List<ChartPieDataValue> dataList) {
		this.dataList = dataList;
	}

	
    
    

}
