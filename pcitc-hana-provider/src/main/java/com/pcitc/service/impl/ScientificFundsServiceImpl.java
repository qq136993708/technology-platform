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
	 
	 
	 
	 
	 
	//原材料支出统计表
	 public List<ScientificFunds> getYclzctjbData(Map  map)throws Exception
  	 {
  		List<ScientificFunds> list = scientificFundsMapper.getYclzctjbData(map);
  	    return list;
  	}
	 
	 
	 
	    //能耗支出统计表
		 public LayuiTableData getNhzctjbData(LayuiTableParam param)throws Exception
	  	 {
	  		//每页显示条数
	  		int pageSize = param.getLimit();
	  		//从第多少条开始
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		
	  		List<ScientificFunds> list = scientificFundsMapper.getNhzctjbData(map);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(1000);
	  	    return data;
	  	}
			
		 
		 
		//项目资金流向分析
		 public LayuiTableData getXmzjlxfxData(LayuiTableParam param)throws Exception
	  	 {
	  		//每页显示条数
	  		int pageSize = param.getLimit();
	  		//从第多少条开始
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		
	  		List<ScientificFunds> list = scientificFundsMapper.getXmzjlxfxData(map);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(1000);
	  	    return data;
	  	}
			
}
