package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.ScientificInstrumentPay;
import com.pcitc.base.hana.report.ScientificInstrumentPayDetail;

public interface ScientificInstrumentPayMapper {
	
	
	 public List<ScientificInstrumentPayDetail> getList(Map map);
	 
	 public Integer getCount(Map map);
	 
	 //科研仪器设备支出分析-5年支出趋势
	 public List<ScientificInstrumentPay> getScientificInstrumentPayReport(Map map);
	 //科研仪器设备支出分析-同比占比分析--按研究院
	 public List<ScientificInstrumentPay> getScientificInstrumentPayByG0ZCMSReport(Map map);
	 //科研仪器设备支出分析-同比占比分析--按研究院
	 public List<ScientificInstrumentPay> getScientificInstrumentPayByG0GSJCReport(Map map);
	 
	 
	 
	 
	 
}
