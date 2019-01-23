package com.pcitc.service;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.BrandConstructionPay;
import com.pcitc.base.hana.report.DayCashFlow;
import com.pcitc.base.hana.report.InvisibleCapitalDevelop;
import com.pcitc.base.hana.report.ScientificBaseBuildFee01;
import com.pcitc.base.hana.report.ScientificBaseBuildFee02;
import com.pcitc.base.hana.report.ScientificBaseBuildFee03;
import com.pcitc.base.hana.report.ScientificBaseBuildFee04;
import com.pcitc.base.hana.report.ScientificInstrumentPay;
import com.pcitc.base.hana.report.ScientificInstrumentPayDetail;
import com.pcitc.base.hana.report.TopicDevelop;
import com.pcitc.base.hana.report.TotalCostProjectPay01;
import com.pcitc.base.hana.report.TotalCostProjectPay02;
import com.pcitc.base.hana.report.TotalCostProjectPay03;

public interface IDecisionFinancialService
{
	
	
	
	  //全成本项目支出综合分析_资金结余对比 H1AS_KY_CB_1001_01
	  public List<TotalCostProjectPay01> getTotalCostProjectPay01Report(Map map)throws Exception;
	  //类型分析
	  public List<TotalCostProjectPay01> getTotalCostProjectPay01ReportBy_G0XMGLLX(Map map)throws Exception;
	  //来源分析
	  public List<TotalCostProjectPay01> getTotalCostProjectPay01ReportBy_G0XMGLLY(Map map)throws Exception;
	  //级别分析
	  public List<TotalCostProjectPay01> getTotalCostProjectPay01ReportBy_G0XMGLJB(Map map)throws Exception;
	  
	  
	  //费用细分类型使用率分析 
	  public List<TotalCostProjectPay02> getTotalCostProjectPay02ReportBy_G0FYFL(Map map)throws Exception;
	  //费用细分类型占比分析
	  public List<TotalCostProjectPay02> getTotalCostProjectPay02ReportBy_G0FYFL_02(Map map)throws Exception;
	  //研究院实际支出占比分析
	  public List<TotalCostProjectPay02> getTotalCostProjectPay02ReportBy_G0GSJC(Map map)throws Exception;
	  
	  //研究院人均实际支出分析
	  public List<TotalCostProjectPay03> getTotalCostProjectPay03Report(Map map)throws Exception;
	  
	  
	  
	  //科研基建支出分析-5年支出趋势 H1AS_KY_CB_1003_01
	  public List<ScientificBaseBuildFee01> getScientificBaseBuildFee01Report(Map map)throws Exception;
	  //科研基建支出分析-同比占比分析
	  public List<ScientificBaseBuildFee02> getScientificBaseBuildFee02Report(Map map)throws Exception;
	  //科研基建支出分析-人均指标  H1AS_KY_CB_1003_03
      public List<ScientificBaseBuildFee03> getScientificBaseBuildFee03Report(Map map)throws Exception;
	  // 
      public LayuiTableData getScientificBaseBuildFee04Page(LayuiTableParam param)throws Exception;
      
      public List<ScientificBaseBuildFee04> getScientificBaseBuildFee04List(Map map)throws Exception;
      
      
      
      /**===================================科研仪器设备支出==================================*/
      public LayuiTableData getScientificInstrumentPayDetailPage(LayuiTableParam param)throws Exception;
      public List<ScientificInstrumentPayDetail> getScientificInstrumentPayDetailList(Map map)throws Exception;
      //科研仪器设备支出分析-5年支出趋势
	  public List<ScientificInstrumentPay> getScientificInstrumentPayReport(Map map)throws Exception;
	  //科研仪器设备支出分析-同比占比分析--按资产类别
	  public List<ScientificInstrumentPay> getScientificInstrumentPayByG0ZCMSReport(Map map)throws Exception;
	  //科研仪器设备支出分析-同比占比分析--按研究院
	  public List<ScientificInstrumentPay> getScientificInstrumentPayByG0GSJCReport(Map map)throws Exception;
      
	  /**===================================科研仪器设备支出 end==================================*/
	  
	  
	  
	  
	  
	  /**===================================无形资产的开发支出分析==================================*/
	   //报表--EXCEL导出
      public LayuiTableData getInvisibleCapitalDevelopDetailPage(LayuiTableParam param)throws Exception;
      public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopPayDetailList(Map map)throws Exception;
      //年度趋势分析
	  public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopReport(Map map)throws Exception;
	   //按资产类别分析
	  public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopByG0ZCMSReport(Map map)throws Exception;
	  //按研究院分析
	  public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopByG0GSJCReport(Map map)throws Exception;
      
	  /**===================================无形资产的开发支出分析 end==================================*/
	  
	  
	  
	  /**===================================品牌建设支出分析分析==================================*/
	  //报表--EXCEL导出
      public LayuiTableData getBrandConstructionPayDetailPage(LayuiTableParam param)throws Exception;
      public List<BrandConstructionPay> getBrandConstructionPayDetailList(Map map)throws Exception;
      //年度趋势分析
	  public List<BrandConstructionPay> getBrandConstructionPayReport(Map map)throws Exception;
	  //按资产类别分析
	  public List<BrandConstructionPay> getBrandConstructionPayByG0ZCMSReport(Map map)throws Exception;
	  //按研究院分析
	  public List<BrandConstructionPay> getBrandConstructionPayByG0GSJCReport(Map map)throws Exception;
      
	  /**===================================品牌建设支出分析分析 end==================================*/
	  
	  /**===================================课题研发支出分析==================================*/
      public List<TopicDevelop> getTopicDevelopPotList(Map map)throws Exception;
	  public List<TopicDevelop> getTopicDevelopPotById(Map map)throws Exception;
	  public LayuiTableData getTopicDevelopPotByIdPage(LayuiTableParam param)throws Exception;
	  /**===================================课题研发支出分析 end==================================*/
	  
	  
	  
	  public List<DayCashFlow> getDayCashFlowReport(Map map)throws Exception;
	  public LayuiTableData getDayCashFlowReport2(LayuiTableParam param)throws Exception;
	  public LayuiTableData getXjrllfx(LayuiTableParam param)throws Exception;
	  
	  
      
}
