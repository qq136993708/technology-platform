package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.InvisibleCapitalDevelop;

public interface InvisibleCapitalDevelopMapper {
	
	public List<InvisibleCapitalDevelop> getList(Map map);
	 
	 public Integer getCount(Map map);
	 
	 //科研仪器设备支出分析-5年支出趋势
	 public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopReport(Map map);
	 //科研仪器设备支出分析-同比占比分析--按研究院
	 public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopByG0ZCMSReport(Map map);
	 //科研仪器设备支出分析-同比占比分析--按研究院
	 public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopByG0GSJCReport(Map map);

}
