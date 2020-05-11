package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.TotalCostProjectPay01;
import com.pcitc.base.hana.report.TotalCostProjectPay02;
import com.pcitc.base.hana.report.TotalCostProjectPay03;

public interface TotalCostOutComprehensiveMapper {

	
	  public List<TotalCostProjectPay01> getTotalCostProjectPay01Report(Map map);
	  //类型分析
	  public List<TotalCostProjectPay01> getTotalCostProjectPay01ReportBy_G0XMGLLX(Map map);
	  //来源分析
	  public List<TotalCostProjectPay01> getTotalCostProjectPay01ReportBy_G0XMGLLY(Map map);
	  //级别分析
	  public List<TotalCostProjectPay01> getTotalCostProjectPay01ReportBy_G0XMGLJB(Map map);
	  
	  //费用细分类型使用率分析 
	  public List<TotalCostProjectPay02> getTotalCostProjectPay02ReportBy_G0FYFL(Map map);
	  //费用细分类型占比分析
	  public List<TotalCostProjectPay02> getTotalCostProjectPay02ReportBy_G0FYFL_02(Map map);
	  //研究院实际支出占比分析
	  public List<TotalCostProjectPay02> getTotalCostProjectPay02ReportBy_G0GSJC(Map map);
	  
	  //研究院人均实际支出分析
	  public List<TotalCostProjectPay03> getTotalCostProjectPay03Report(Map map);
	  
	  
	  
    
	  

}