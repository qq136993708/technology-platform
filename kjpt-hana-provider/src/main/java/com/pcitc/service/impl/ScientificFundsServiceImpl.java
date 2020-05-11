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

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.hana.report.ScientificFunds;
import com.pcitc.mapper.financial.ScientificFundsMapper;
import com.pcitc.service.IScientificFundsService;
@Service("scientificFundsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ScientificFundsServiceImpl implements IScientificFundsService {
     private final static Logger logger = LoggerFactory.getLogger(DecisionFinancialServiceImpl.class);
     @Autowired
     private ScientificFundsMapper scientificFundsMapper;
     
	 public List<ScientificFunds> getKtzjjfytjbData(Map  map)throws Exception
  	 {
  		List<ScientificFunds> list = scientificFundsMapper.getKtzjjfytjbData(map);
  	    return list;
  	}
	 public List<ScientificFunds> getKtzjjfytjbData_detail(Map  map)throws Exception
  	 {
  		List<ScientificFunds> list = scientificFundsMapper.getKtzjjfytjbData_detail(map);
  	    return list;
  	}
	 public LayuiTableData getKtzjjfytjbData_detail_page(LayuiTableParam param)throws Exception
	 {
		    //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		
	  		
	  		String g0PROJCODE=(String)param.getParam().get("g0PROJCODE");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		 
	  		
	  		logger.info("=====getKtzjjfytjbData_detail_page param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		
	  		map.put("g0PROJCODE", g0PROJCODE);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		
	  		List<ScientificFunds> list =      scientificFundsMapper.getKtzjjfytjbData_detail(map);
	  		Integer totalRecords =            scientificFundsMapper.getKtzjjfytjbData_detail_Count(map);
	  		System.out.println(">>>>getTzxmcgjdtjbDetailPage>>totalRecords："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;

	 }
	 
	 
	 
	 
	 
		//人工成本支出统计表
	 public List<ScientificFunds> getRgcbzctjbData(Map  map)throws Exception
  	 {
  		List<ScientificFunds> list = scientificFundsMapper.getRgcbzctjbData(map);
  	    return list;
  	}
	 public List<ScientificFunds> getRgcbzctjbDataDetail(Map  map)throws Exception
  	 {
  		List<ScientificFunds> list = scientificFundsMapper.getRgcbzctjbDataDetail(map);
  	    return list;
  	}
	 public LayuiTableData getRgcbzctjbDataDetail_page(LayuiTableParam param)throws Exception
	 {
		 //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		String g0PROJCODE=(String)param.getParam().get("g0PROJCODE");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		logger.info("=====getRgcbzctjbDataDetail_page param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJCODE", g0PROJCODE);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		List<ScientificFunds> list =      scientificFundsMapper.getRgcbzctjbDataDetail(map);
	  		Integer totalRecords =            scientificFundsMapper.getRgcbzctjbDataDetail_Count(map);
	  		System.out.println(">>>>getRgcbzctjbDataDetail_page>>totalRecords："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
	 }
	 
	 
	 
	 
	//原材料支出统计表
	 public List<ScientificFunds> getYclzctjbData(Map  map)throws Exception
  	 {
  		List<ScientificFunds> list = scientificFundsMapper.getYclzctjbData(map);
  	    return list;
  	}
	 public List<ScientificFunds> getYclzctjbData_Detail(Map  map)throws Exception
  	 {
  		List<ScientificFunds> list = scientificFundsMapper.getYclzctjbData_Detail(map);
  	    return list;
  	}
	 public LayuiTableData getYclzctjbData_Detail_page(LayuiTableParam param)throws Exception
	 {
		//每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		String g0PROJCODE=(String)param.getParam().get("g0PROJCODE");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		logger.info("=====getYclzctjbData_Detail_page param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJCODE", g0PROJCODE);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		List<ScientificFunds> list =      scientificFundsMapper.getYclzctjbData_Detail(map);
	  		Integer totalRecords =            scientificFundsMapper.getYclzctjbData_Detail_Count(map);
	  		System.out.println(">>>>getYclzctjbData_Detail_page>>totalRecords："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
	 }
	 
	//能耗支出统计表
	 public List<ScientificFunds> getNhzctjbData(Map  map)throws Exception
  	 {
  		List<ScientificFunds> list = scientificFundsMapper.getNhzctjbData(map);
  	    return list;
  	}
	 public List<ScientificFunds> getNhzctjbData_detail(Map  map)throws Exception
  	 {
  		List<ScientificFunds> list = scientificFundsMapper.getNhzctjbData_detail(map);
  	    return list;
  	}
	 public LayuiTableData getNhzctjbData_detail_page(LayuiTableParam param)throws Exception
	 {
		//每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		String g0PROJCODE=(String)param.getParam().get("g0PROJCODE");
	  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
	  		logger.info("=====getNhzctjbData_detail_page param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		map.put("g0PROJCODE", g0PROJCODE);
	  		map.put("g0PROJTXT", g0PROJTXT);
	  		List<ScientificFunds> list =      scientificFundsMapper.getNhzctjbData_detail(map);
	  		Integer totalRecords =            scientificFundsMapper.getNhzctjbData_detail_Count(map);
	  		System.out.println(">>>>getNhzctjbData_detail_page>>totalRecords："+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
	 }
	 
	 
	   //项目资金流向分析
		 public List<ScientificFunds> getXmzjlxfxData(Map  map)throws Exception
	  	 {
	  		List<ScientificFunds> list = scientificFundsMapper.getXmzjlxfxData(map);
	  	    return list;
	  	}
		 public List<ScientificFunds> getXmzjlxfxData_detail(Map  map)throws Exception
	  	 {
	  		List<ScientificFunds> list = scientificFundsMapper.getXmzjlxfxData_detail(map);
	  	    return list;
	  	}
		 public LayuiTableData getXmzjlxfxData_detail_page(LayuiTableParam param)throws Exception
		 {
			//每页显示条数
		  		int pageSize = param.getLimit();
		  		int pageNum = param.getPage();
		  		Page p=new Page(pageNum,pageSize);
				int start=(pageNum-1)*p.getPageSize();
		  		String month=(String)param.getParam().get("month");
		  		String companyCode=(String)param.getParam().get("companyCode");
		  		String g0PROJCODE=(String)param.getParam().get("g0PROJCODE");
		  		String g0PROJTXT=(String)param.getParam().get("g0PROJTXT");
		  		logger.info("=====getXmzjlxfxData_detail_page param: "+JSONObject.toJSONString(param));
		  		Map map=new HashMap();
		  		map.put("start", start);
		  		map.put("pageSize", pageSize);
		  		map.put("month", month);
		  		map.put("companyCode", companyCode);
		  		map.put("g0PROJCODE", g0PROJCODE);
		  		map.put("g0PROJTXT", g0PROJTXT);
		  		List<ScientificFunds> list =      scientificFundsMapper.getXmzjlxfxData_detail(map);
		  		Integer totalRecords =            scientificFundsMapper.getXmzjlxfxData_detail_Count(map);
		  		System.out.println(">>>>getXmzjlxfxData_detail_page>>totalRecords："+totalRecords);
		  		LayuiTableData data = new LayuiTableData();
		  		data.setData(list);
		  		data.setCount(totalRecords);
		  	    return data;
		 }
	 
		
			
}
