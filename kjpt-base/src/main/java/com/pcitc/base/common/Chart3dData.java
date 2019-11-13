package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSON;

public class Chart3dData 
{
	private String x;
	private String y;
	
	private Object v;
	
	public Chart3dData() {
		super();
	}
	public Chart3dData(String x, String y, Object v) {
		super();
		this.x = x;
		this.y = y;
		this.v = v;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public Object getV() {
		return v;
	}
	public void setV(Object v) {
		this.v = v;
	}
	
	
	public static void main(String [] args)
	{
		String [] x = new String[] {"a","b","c","d"};
		String [] y = new String [] {"aa","bb","cc","dd","ee","ff","gg","kk"};
		
		List<String> lsx = new ArrayList<String>();
		for(String s:x) {lsx.add(s);}
		List<String> lsy = new ArrayList<String>();
		for(String s:y) {lsy.add(s);}
		List<Chart3dData> data = new ArrayList<Chart3dData>();
		for(String sx:lsx)
		{
			for(String sy:lsy) 
			{
				Chart3dData bean = new Chart3dData();
				bean.setX(sx);
				bean.setY(sy);
				
				Double d = new Random().nextDouble()*100;
				bean.setV(new Double(d.intValue()));
				data.add(bean);
			}
		}
		
		Chart3dResultData chardata = new Chart3dResultData(lsx,lsy,data);
		System.out.println(JSON.toJSONString(chardata));
		
	}
}
