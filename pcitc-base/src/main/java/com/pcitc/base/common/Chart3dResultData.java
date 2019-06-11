package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chart3dResultData {

	private List<String> x;
	private List<String> y;
	private List<Object[]> val;
	
	public Chart3dResultData() {
		super();
	}
	public Chart3dResultData(List<String> x, List<String> y, List<Chart3dData> data) {
		super();
		this.x = x;
		this.y = y;
		//init data
		Map<String,Object> kvmap = new HashMap<String,Object>();
		for(Chart3dData dt:data) 
		{
			kvmap.put(dt.getX()+"_"+dt.getY(), dt.getV());
		}
		
		this.val = new ArrayList<Object[]>();
		//data [x,y,z]
		for(int i=0;i<x.size();i++) 
		{
			for(int j=0;j<y.size();j++) 
			{
				Object v = kvmap.get(x.get(i)+"_"+y.get(j));
				this.val.add(new Object[] {i,j,v==null?0:v});
			}
		}
	}
	public List<String> getX() {
		return x;
	}
	public void setX(List<String> x) {
		this.x = x;
	}
	public List<String> getY() {
		return y;
	}
	public void setY(List<String> y) {
		this.y = y;
	}
	public List<Object[]> getVal() {
		return val;
	}
	public void setVal(List<Object[]> val) {
		this.val = val;
	}
}
