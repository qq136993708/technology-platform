package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pcitc.base.util.MyBeanUtils;

public class LayuiTableData 
{
	private Integer code=0;
	private String msg="";
	private Integer count;
	private List<?> data;
	/**
	 * 
	 * 在返回数据集中动态添加列
	 * 要求数据长度必须一致
	 */
	public void addPropertyAndValToData(List<Map<String,Object>> properties) 
	{
		if(this.getData() == null || properties.size() != this.getData().size()) 
		{
			return;
		}
		List<Map<String,Object>> newObjData = new ArrayList<Map<String,Object>>();
		for(int i = 0;i<this.getData().size();i++) {
			Object obj = this.getData().get(i);
			Map<String,Object> map = MyBeanUtils.transBean2Map(obj);
			map.putAll(properties.get(i));
			newObjData.add(map);
		}
		this.setData(newObjData);
	}
	/**
	 * 动态添加属性值到数据中,在每一行数据中添加相同的【key,val】
	 * 
	 */
	public void addPropertyToData(String property,Object val) 
	{
		if(this.getData() == null) 
		{
			return;
		}
		List<Map<String,Object>> newObjData = new ArrayList<Map<String,Object>>();
		for(Object obj:data) 
		{
			Map<String,Object> map = MyBeanUtils.transBean2Map(obj);
			map.put(property, val);
			newObjData.add(map);
		}
		this.setData(newObjData);
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
}
