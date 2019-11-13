package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class ChartDotResultData {
	
    private	List<ChartDot> dataList=new ArrayList<ChartDot>();
    //legend  data
    private	List<String> legendDataList=new ArrayList<String>();
    
    private List<List> arrDateList=new ArrayList<List>();

	public List<ChartDot> getDataList() {
		return dataList;
	}

	public void setDataList(List<ChartDot> dataList) {
		this.dataList = dataList;
	}

	public List<String> getLegendDataList() {
		return legendDataList;
	}

	public void setLegendDataList(List<String> legendDataList) {
		this.legendDataList = legendDataList;
	}

	public List<List> getArrDateList() {
		return arrDateList;
	}

	public void setArrDateList(List<List> arrDateList) {
		this.arrDateList = arrDateList;
	}
    
    

	
    
    
    
    
}
