package com.pcitc.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
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
import com.pcitc.mapper.common.CommonMapper;
import com.pcitc.mapper.financial.BrandConstructionPayMapper;
import com.pcitc.mapper.financial.DayCashFlowMapper;
import com.pcitc.mapper.financial.InvisibleCapitalDevelopMapper;
import com.pcitc.mapper.financial.ScientificBaseBuildFeeMapper;
import com.pcitc.mapper.financial.ScientificInstrumentPayMapper;
import com.pcitc.mapper.financial.TopicDevelopMapper;
import com.pcitc.mapper.financial.TotalCostOutComprehensiveMapper;
import com.pcitc.service.IDecisionFinancialService;


@Service("decisionFinancialService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class DecisionFinancialServiceImpl implements IDecisionFinancialService {
	
	     private final static Logger logger = LoggerFactory.getLogger(DecisionFinancialServiceImpl.class);
	     
	     @Autowired
	     private ScientificBaseBuildFeeMapper scientificBaseBuildFeeMapper;
	     
	     
	     @Autowired
	     private TotalCostOutComprehensiveMapper totalCostOutComprehensiveMapper;
	     
	     
	     
	     @Autowired
	     private ScientificInstrumentPayMapper scientificInstrumentPayMapper;
	     
	     
	     
	     @Autowired
	     private InvisibleCapitalDevelopMapper invisibleCapitalDevelopMapper;
	     
	     
	     
	     @Autowired
	     private BrandConstructionPayMapper brandConstructionPayMapper;
	     
	     
	     
	     @Autowired
	     private TopicDevelopMapper topicDevelopMapper;
	     
	     @Autowired
	     private CommonMapper commonMapper;
	     
	     

	     @Autowired
	     private DayCashFlowMapper dayCashFlowMapper;
	     
	     
	     
		    
		 public List<TotalCostProjectPay01> getTotalCostProjectPay01Report(Map map) throws Exception 
		 {
			    JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			    logger.info("=====研究院科研经费预算批复和实际支出全成本分析参数: "+jSONObject.toJSONString());
				return totalCostOutComprehensiveMapper.getTotalCostProjectPay01Report(map);
		 }
		
		  //类型分析
		  public List<TotalCostProjectPay01> getTotalCostProjectPay01ReportBy_G0XMGLLX(Map map)throws Exception
		  {
			  
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("========= 类型分析参数: "+jSONObject.toJSONString());
			  return totalCostOutComprehensiveMapper.getTotalCostProjectPay01ReportBy_G0XMGLLX(map);
		  }
		  //来源分析
		  public List<TotalCostProjectPay01> getTotalCostProjectPay01ReportBy_G0XMGLLY(Map map)throws Exception
		  {
			  
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("===== 来源分析参数: "+jSONObject.toJSONString());
			  return totalCostOutComprehensiveMapper.getTotalCostProjectPay01ReportBy_G0XMGLLY(map);
		  }
		  //级别分析
		  public List<TotalCostProjectPay01> getTotalCostProjectPay01ReportBy_G0XMGLJB(Map map)throws Exception
		  {
			  
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=======级别分析参数: "+jSONObject.toJSONString());
			  return totalCostOutComprehensiveMapper.getTotalCostProjectPay01ReportBy_G0XMGLJB(map);
		  }
		  //费用细分类型使用率分析 
		  public List<TotalCostProjectPay02> getTotalCostProjectPay02ReportBy_G0FYFL(Map map)throws Exception
		  {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("======费用细分类型使用率分析参数 : "+jSONObject.toJSONString());
			  return totalCostOutComprehensiveMapper.getTotalCostProjectPay02ReportBy_G0FYFL(map);
		  }
		  //费用细分类型占比分析
		  public List<TotalCostProjectPay02> getTotalCostProjectPay02ReportBy_G0FYFL_02(Map map)throws Exception
		  {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=======费用细分类型占比分析参数: "+jSONObject.toJSONString());
			  return totalCostOutComprehensiveMapper.getTotalCostProjectPay02ReportBy_G0FYFL_02(map);
		  }
		  //研究院实际支出占比分析
		  public List<TotalCostProjectPay02> getTotalCostProjectPay02ReportBy_G0GSJC(Map map)throws Exception
		  {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====研究院实际支出占比分析参数: "+jSONObject.toJSONString());
			  return totalCostOutComprehensiveMapper.getTotalCostProjectPay02ReportBy_G0GSJC(map);
		  }
		  
		  
		  //研究院人均实际支出分析
		  public List<TotalCostProjectPay03> getTotalCostProjectPay03Report(Map map)throws Exception
		  {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====研究院人均实际支出分析: "+jSONObject.toJSONString());
			  return totalCostOutComprehensiveMapper.getTotalCostProjectPay03Report(map);
		  }
		  
		  
		  
		  /**======================================科研基建投资支出分析============================*/
		  
		  //科研基建支出分析-5年支出趋势 H1AS_KY_CB_1003_01
		  public List<ScientificBaseBuildFee01> getScientificBaseBuildFee01Report(Map map)throws Exception
		  {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====科研基建支出分析-- 5年支出趋势: "+jSONObject.toJSONString());
			  return scientificBaseBuildFeeMapper.getScientificBaseBuildFee01Report(map);
		  }
		  //科研基建支出分析-同比占比分析
		  public List<ScientificBaseBuildFee02> getScientificBaseBuildFee02Report(Map map)throws Exception
		  {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====科研基建支出分析-- 同比占比分析: "+jSONObject.toJSONString());
			  
			  return scientificBaseBuildFeeMapper.getScientificBaseBuildFee02Report(map);
		  }
		  //科研基建支出分析-人均指标  H1AS_KY_CB_1003_03
	      public List<ScientificBaseBuildFee03> getScientificBaseBuildFee03Report(Map map)throws Exception
	      {
	    	  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====科研基建支出分析 --人均指标: "+jSONObject.toJSONString());
			  return scientificBaseBuildFeeMapper.getScientificBaseBuildFee03Report(map);
	      }
	      
	      
	      
	      
	      
	    public LayuiTableData getScientificBaseBuildFee04Page(LayuiTableParam param)throws Exception
	  	{
	  		//每页显示条数
	  		int pageSize = param.getLimit();
	  		//从第多少条开始
	  		//int pageStart = (param.getPage()-1)*pageSize;
	  		//当前是第几页
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String g0TXT50=(String)param.getParam().get("g0TXT50");
	  		String g0GSJC=(String)param.getParam().get("g0GSJC");
	  		String g0ZCMS=(String)param.getParam().get("g0ZCMS");
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0TXT50", g0TXT50);
	  		map.put("g0ZCMS", g0ZCMS);
	  		map.put("g0GSJC", g0GSJC);
	  		
	  		List<ScientificBaseBuildFee04> list = scientificBaseBuildFeeMapper.getList(map);
	  		Integer totalRecords = scientificBaseBuildFeeMapper.getCount(map);
	  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
	  	}
	    
	    public List<ScientificBaseBuildFee04> getScientificBaseBuildFee04List(Map map)throws Exception
	    {
	    	return scientificBaseBuildFeeMapper.getList(map);
	    }
	    /**====================================== 科研基建投资支出分析 end ============================*/
	    
	    
	    
	    
	    /**====================================== 科研仪器设备支出分析===========================*/
	    
	    public LayuiTableData getScientificInstrumentPayDetailPage(LayuiTableParam param)throws Exception
	  	{
	  		//每页显示条数
	  		int pageSize = param.getLimit();
	  		//从第多少条开始
	  		//int pageStart = (param.getPage()-1)*pageSize;
	  		//当前是第几页
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String g0TXT50=(String)param.getParam().get("g0TXT50");
	  		String g0GSJC=(String)param.getParam().get("g0GSJC");
	  		String g0ZCMS=(String)param.getParam().get("g0ZCMS");
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0TXT50", g0TXT50);
	  		map.put("g0ZCMS", g0ZCMS);
	  		map.put("g0GSJC", g0GSJC);
	  		
	  		List<ScientificInstrumentPayDetail> list = scientificInstrumentPayMapper.getList(map);
	  		Integer totalRecords = scientificInstrumentPayMapper.getCount(map);
	  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
	  	}
	    
	    
	    public List<ScientificInstrumentPayDetail> getScientificInstrumentPayDetailList(Map map)throws Exception
	    {
	    	return scientificInstrumentPayMapper.getList(map);
	    }
	    
	    
	    
	    
	    
	     //科研仪器设备支出分析-5年支出趋势
		 public List<ScientificInstrumentPay> getScientificInstrumentPayReport(Map map)throws Exception
		 {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====科研仪器设备支分析-- 5年支出趋势: "+jSONObject.toJSONString());
			  return scientificInstrumentPayMapper.getScientificInstrumentPayReport(map);
		 }
		 //科研仪器设备支出分析-同比占比分析--按资产类别
		 public List<ScientificInstrumentPay> getScientificInstrumentPayByG0ZCMSReport(Map map)throws Exception
		 {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("====科研仪器设备支出分析-同比占比分析--按资产类别: "+jSONObject.toJSONString());
			  return scientificInstrumentPayMapper.getScientificInstrumentPayByG0ZCMSReport(map);
		 }
		 //科研仪器设备支出分析-同比占比分析--按研究院
		 public List<ScientificInstrumentPay> getScientificInstrumentPayByG0GSJCReport(Map map)throws Exception
		 {
			 JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("====科研仪器设备支出分析-同比占比分析--按研究院: "+jSONObject.toJSONString());
			  return scientificInstrumentPayMapper.getScientificInstrumentPayByG0GSJCReport(map);
		 }
		 
	      
	     
		  
	    /**======================================科研仪器设备支出分析 end ============================*/
		 
		 
		 

		  
		  
		  /**===================================无形资产的开发支出分析==================================*/
		   //报表--EXCEL导出
	      public LayuiTableData getInvisibleCapitalDevelopDetailPage(LayuiTableParam param)throws Exception
	      {
	    	//每页显示条数
		  		int pageSize = param.getLimit();
		  		//从第多少条开始
		  		//int pageStart = (param.getPage()-1)*pageSize;
		  		//当前是第几页
		  		int pageNum = param.getPage();
		  		Page p=new Page(pageNum,pageSize);
				int start=(pageNum-1)*p.getPageSize();
		  		String g0TXT50=(String)param.getParam().get("g0TXT50");
		  		String g0GSJC=(String)param.getParam().get("g0GSJC");
		  		String g0ZCMS=(String)param.getParam().get("g0ZCMS");
		  		String month=(String)param.getParam().get("month");
		  		String companyCode=(String)param.getParam().get("companyCode");
		  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
		  		Map map=new HashMap();
		  		map.put("start", start);
		  		map.put("pageSize", pageSize);
		  		map.put("month", month);
		  		map.put("companyCode", companyCode);
		  		map.put("g0TXT50", g0TXT50);
		  		map.put("g0ZCMS", g0ZCMS);
		  		map.put("g0GSJC", g0GSJC);
		  		
		  		List<InvisibleCapitalDevelop> list = invisibleCapitalDevelopMapper.getList(map);
		  		Integer totalRecords = invisibleCapitalDevelopMapper.getCount(map);
		  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
		  		LayuiTableData data = new LayuiTableData();
		  		data.setData(list);
		  		data.setCount(totalRecords);
		  	    return data;
	      }
	      public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopPayDetailList(Map map)throws Exception
	      {
	    	  return invisibleCapitalDevelopMapper.getList(map);
	      }
	      //年度趋势分析
		  public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopReport(Map map)throws Exception
	      {

			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====无形资产 年度趋势分析: "+jSONObject.toJSONString());
			  return invisibleCapitalDevelopMapper.getInvisibleCapitalDevelopReport(map);
	      }
		   //按资产类别分析
		  public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopByG0ZCMSReport(Map map)throws Exception
	      {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====无形资产-按资产类别分析: "+jSONObject.toJSONString());
			  return invisibleCapitalDevelopMapper.getInvisibleCapitalDevelopByG0ZCMSReport(map);
	      }
		  //按研究院分析
		  public List<InvisibleCapitalDevelop> getInvisibleCapitalDevelopByG0GSJCReport(Map map)throws Exception
	      {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====无形资产-按研究院分析: "+jSONObject.toJSONString());
			  return invisibleCapitalDevelopMapper.getInvisibleCapitalDevelopByG0GSJCReport(map);
	      }
	      
		  /**===================================无形资产的开发支出分析 end==================================*/
		  
		  
		  
		  /**===================================品牌建设支出分析分析==================================*/
		  //报表--EXCEL导出
	      public LayuiTableData getBrandConstructionPayDetailPage(LayuiTableParam param)throws Exception
	      {
	    	//每页显示条数
		  		int pageSize = param.getLimit();
		  		//从第多少条开始
		  		//int pageStart = (param.getPage()-1)*pageSize;
		  		//当前是第几页
		  		int pageNum = param.getPage();
		  		Page p=new Page(pageNum,pageSize);
				int start=(pageNum-1)*p.getPageSize();
		  		String g0PZTTWB=(String)param.getParam().get("g0PZTTWB");
		  		String g0GSJC=(String)param.getParam().get("g0GSJC");
		  		String g0ZCMS=(String)param.getParam().get("g0ZCMS");
		  		String month=(String)param.getParam().get("month");
		  		String companyCode=(String)param.getParam().get("companyCode");
		  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
		  		Map map=new HashMap();
		  		map.put("start", start);
		  		map.put("pageSize", pageSize);
		  		map.put("month", month);
		  		map.put("companyCode", companyCode);
		  		map.put("g0PZTTWB", g0PZTTWB);
		  		map.put("g0ZCMS", g0ZCMS);
		  		map.put("g0GSJC", g0GSJC);
		  		
		  		List<BrandConstructionPay> list = brandConstructionPayMapper.getList(map);
		  		Integer totalRecords = brandConstructionPayMapper.getCount(map);
		  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
		  		LayuiTableData data = new LayuiTableData();
		  		data.setData(list);
		  		data.setCount(totalRecords);
		  	    return data;
	      }
	      public List<BrandConstructionPay> getBrandConstructionPayDetailList(Map map)throws Exception
	      {
	    	  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====无形资产-按研究院分析: "+jSONObject.toJSONString());
			  return brandConstructionPayMapper.getList(map);
	      }
	      //年度趋势分析
		  public List<BrandConstructionPay> getBrandConstructionPayReport(Map map)throws Exception
	      {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====无形资产-按研究院分析: "+jSONObject.toJSONString());
			  return brandConstructionPayMapper.getBrandConstructionPayReport(map);
	      }
		  //按资产类别分析
		  public List<BrandConstructionPay> getBrandConstructionPayByG0ZCMSReport(Map map)throws Exception
	      {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====无形资产-按研究院分析: "+jSONObject.toJSONString());
			  return brandConstructionPayMapper.getBrandConstructionPayByG0ZCMSReport(map);
	      }
		  //按研究院分析
		  public List<BrandConstructionPay> getBrandConstructionPayByG0GSJCReport(Map map)throws Exception
	      {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====无形资产-按研究院分析: "+jSONObject.toJSONString());
			  return brandConstructionPayMapper.getBrandConstructionPayByG0GSJCReport(map);
	      }
	      
		  /**===================================品牌建设支出分析分析 end==================================*/
		  
		  
		  /**===================================课题研发支出分析==================================*/
		  public List<TopicDevelop> getTopicDevelopPotList(Map map)throws Exception
		  {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====课题研发 气泡: "+jSONObject.toJSONString());
			  return topicDevelopMapper.getTopicDevelopPotList(map);
		  }
		  public List<TopicDevelop> getTopicDevelopPotById(Map map)throws Exception
		  {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====课题研发 详情: "+jSONObject.toJSONString());
			  return topicDevelopMapper.getlist(map);
		  }
		  
		  
		  public LayuiTableData getTopicDevelopPotByIdPage(LayuiTableParam param)throws Exception
	      {
	    	    //每页显示条数
		  		int pageSize = param.getLimit();
		  		int pageNum = param.getPage();
		  		Page p=new Page(pageNum,pageSize);
				int start=(pageNum-1)*p.getPageSize();
		  		String month=(String)param.getParam().get("month");
		  		String g0PROJCODE=(String)param.getParam().get("g0PROJCODE");
		  		logger.info("===课题研发支出参数 param: "+JSONObject.toJSONString(param));
		  		Map map=new HashMap();
		  		map.put("start", start);
		  		map.put("pageSize", pageSize);
		  		map.put("month", month);
		  		map.put("g0PROJCODE", g0PROJCODE);
		  		
		  		List<TopicDevelop> list = topicDevelopMapper.getlist(map);
		  		Integer totalRecords = topicDevelopMapper.getCount(map);
		  		System.out.println(">>>>>>>>>课题研发支出查询分页结果"+totalRecords);
		  		LayuiTableData data = new LayuiTableData();
		  		data.setData(list);
		  		data.setCount(totalRecords);
		  	    return data;
	      }
		  
		  
		  
		  
		  
		  
		  /**===================================课题研发支出分析 end==================================*/
		  
		  public List<DayCashFlow> getDayCashFlowReport(Map map)throws Exception
		  {
			  JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
			  logger.info("=====日现金流: "+jSONObject.toJSONString());
			  return dayCashFlowMapper.getDayCashFlowReport(map);
		  }
		  
		  public LayuiTableData getXjrllfx(LayuiTableParam param)throws Exception
	      {
	    	    //每页显示条数
		  		int pageSize = param.getLimit();
		  		int pageNum = param.getPage();
		  		Page p=new Page(pageNum,pageSize);
				int start=(pageNum-1)*p.getPageSize();
		  		String month=(String)param.getParam().get("month");
		  		String g0PROJCODE=(String)param.getParam().get("g0PROJCODE");
		  		logger.info("===课题研发支出参数 param: "+JSONObject.toJSONString(param));
		  		Map map=new HashMap();
		  		map.put("start", start);
		  		map.put("pageSize", pageSize);
		  		map.put("month", month);
		  		map.put("g0PROJCODE", g0PROJCODE);
		  		
		  		List<TopicDevelop> list = topicDevelopMapper.getlist(map);
		  		Integer totalRecords = topicDevelopMapper.getCount(map);
		  		System.out.println(">>>>>>>>>课题研发支出查询分页结果"+totalRecords);
		  		LayuiTableData data = new LayuiTableData();
		  		data.setData(list);
		  		data.setCount(totalRecords);
		  	    return data;
	      }
		  
		  
		  
		  

}
