package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;
public class ChartBarLineResultData {
	
	
	
	//yAxis data
    private	List<String> yAxisDataList=new ArrayList<String>();
    
	//xAxis data
    private	List<String> xAxisDataList=new ArrayList<String>();
    
    //legend  data
    private	List<String> legendDataList=new ArrayList<String>();
    
	//X轴数据
	private	List<ChartBarLineSeries> seriesList=new ArrayList<ChartBarLineSeries>();
	
	

	public List<String> getyAxisDataList() {
		return yAxisDataList;
	}

	public void setyAxisDataList(List<String> yAxisDataList) {
		this.yAxisDataList = yAxisDataList;
	}

	public List<String> getxAxisDataList() {
		return xAxisDataList;
	}

	public void setxAxisDataList(List<String> xAxisDataList) {
		this.xAxisDataList = xAxisDataList;
	}

	public List<String> getLegendDataList() {
		return legendDataList;
	}

	public void setLegendDataList(List<String> legendDataList) {
		this.legendDataList = legendDataList;
	}

	public List<ChartBarLineSeries> getSeriesList() {
		return seriesList;
	}

	public void setSeriesList(List<ChartBarLineSeries> seriesList) {
		this.seriesList = seriesList;
	}
	
	
	
	
	
	
	
	
	
	

}
