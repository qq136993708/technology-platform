package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.BrandConstructionPay;

public interface BrandConstructionPayMapper {
	
	
     public List<BrandConstructionPay> getList(Map map);
	 
	 public Integer getCount(Map map);
	 
	 //科研仪器设备支出分析-5年支出趋势
	 public List<BrandConstructionPay> getBrandConstructionPayReport(Map map);
	 //科研仪器设备支出分析-同比占比分析--按研究院
	 public List<BrandConstructionPay> getBrandConstructionPayByG0ZCMSReport(Map map);
	 //科研仪器设备支出分析-同比占比分析--按研究院
	 public List<BrandConstructionPay> getBrandConstructionPayByG0GSJCReport(Map map);
	 
	 

}
